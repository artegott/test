package com.company.controller;


import com.company.entity.Tag;
import com.company.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUrlsByTag(@RequestParam(name = "tag", required = false, defaultValue = "") String tagName, Model model) {
        if (!tagName.isEmpty()) {
            Tag tag = tagService.findByName(tagName);
            if (tag != null) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("tagName", tag.getName());
                attributes.put("tagUrls", tag.getUrls());
                model.addAllAttributes(attributes);
                return "urls/tags";
            }
        }
        return "errors/404";
    }

}
