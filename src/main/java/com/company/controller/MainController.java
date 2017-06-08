package com.company.controller;

import com.company.persistence.dto.UrlDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showMainPage(Model model) {
        UrlDto urlDto = new UrlDto();
        model.addAttribute("url", urlDto);
        return "start-page";
    }
}
