package com.company.controller;


import com.company.entity.Statistics;
import com.company.entity.Url;
import com.company.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController {

    private final UrlService urlService;

    @Autowired
    public StatisticsController(UrlService urlService) {
        this.urlService = urlService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showStatistics(@RequestParam(name = "url", required = false, defaultValue = "") String shortUrl, Model model) {
        if (!shortUrl.isEmpty()) {
            Url url = urlService.getByShortUrl(shortUrl);
            if (url != null) {
                Statistics statistics = url.getStatistics();
                HashMap<String, String> attributes = new HashMap<>();
                attributes.put("URL", shortUrl);
                attributes.put("PcClick", String.valueOf(statistics.getCountPcClick()));
                attributes.put("MobileClick", String.valueOf(statistics.getCountMobileClick()));
                attributes.put("TabletClick", String.valueOf(statistics.getCountTabletClick()));
                Long totalClick = statistics.getCountPcClick() + statistics.getCountMobileClick() + statistics.getCountTabletClick();
                attributes.put("TotalClick", String.valueOf(totalClick));
                model.addAllAttributes(attributes);
                return "urls/statistics";
            }
        }
        return "errors/404";
    }

}
