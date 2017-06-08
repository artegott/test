package com.company.controller;


import com.company.persistence.dto.UrlDto;
import com.company.persistence.entity.Tag;
import com.company.persistence.entity.Url;
import com.company.service.UrlService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/urls")
public class UrlController {
    private final UrlService urlService;
    private final UserService userService;

    @Autowired
    public UrlController(UrlService urlService, UserService userService) {
        this.urlService = urlService;
        this.userService = userService;
    }

    @PostMapping
    public String add(@ModelAttribute("url") @Valid UrlDto urlDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "start-page";
        }
        Url url = new Url();
        url.setName(urlDto.getName());
        url.setDescription(urlDto.getDescription());
        Set<Tag> tags = new HashSet<>();
        for (String s : urlDto.getTags().split(",")) {
            tags.add(new Tag(s, null));
        }
        url.setTags(tags);
        url.setLongUrl(urlDto.getLongUrl());
        model.addAttribute("shortUtl", urlService.save(url).getShortUrl());
        return "start-page";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<Url> edit(@RequestBody Url url) {
        return new ResponseEntity<>(urlService.save(url), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Url>> get() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Url> links = urlService.findByUser(userService.findByLogin(user.getUsername()));
        return new ResponseEntity<>(links, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/info")
    public String info(@RequestParam(name = "url", required = false, defaultValue = "") String shortUrl, Model model) {
        if (!shortUrl.isEmpty()) {
            Url link = urlService.getByShortUrl(shortUrl);
            if (link != null) {
                model.addAllAttributes(getLinkAttributes(link));
                return "urls/info";
            }
        }
        return "errors/404";
    }

    @RequestMapping(value = "/list")
    public String links(Model uiModel) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Url> links = urlService.findByUser(userService.findByLogin(auth.getName()));
        com.company.persistence.entity.User user = new com.company.persistence.entity.User();
        uiModel.addAttribute("urls", links);
        uiModel.addAttribute("user", user);
        return "urls/list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam(name = "url", required = false, defaultValue = "") String shortUrl, Model model) {
        if (!shortUrl.isEmpty()) {
            Url link = urlService.getByShortUrl(shortUrl);
            if (link != null) {
                model.addAllAttributes(getLinkAttributes(link));
                return "urls/edit";
            }
        }
        return "errors/404";
    }

    private HashMap<String, Object> getLinkAttributes(Url link) {
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("shortUrl", link.getShortUrl());
        attributes.put("name", link.getName());
        attributes.put("description", link.getDescription());
        StringBuilder tags = new StringBuilder();
        for (Tag tag : link.getTags()) {
            tags.append(tag.getName()).append(" ");
        }
        attributes.put("tags", tags);
        return attributes;
    }

}
