package com.company.controller;


import com.company.entity.Tag;
import com.company.entity.Url;
import com.company.service.UrlService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Url> add(@RequestBody Url url) {
        return new ResponseEntity<>(urlService.add(url), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResponseEntity<Url> edit(@RequestBody Url url) {
        return new ResponseEntity<>(urlService.edit(url), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Url>> get() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Url> links = urlService.getByUser(userService.getByLogin(user.getUsername()));
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

    @RequestMapping(value = "/links")
    public String links(Model uiModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Url> links = urlService.getByUser(userService.getByLogin(user.getUsername()));
        uiModel.addAttribute("urls", links);
        return "urls/links";
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
