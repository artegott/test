package com.company.controller;


import com.company.entity.Statistics;
import com.company.entity.Url;
import com.company.service.StatisticsService;
import com.company.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/s/{shortUrl}")
public class MainController {
    private final UrlService urlService;
    private final StatisticsService statisticsService;
    private final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    public MainController(UrlService urlService, StatisticsService statisticsService) {
        this.urlService = urlService;
        this.statisticsService = statisticsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(@PathVariable String shortUrl, HttpServletRequest request) {
        Device device = DeviceUtils.getCurrentDevice(request);
        if (!shortUrl.isEmpty()) {
            Url url = urlService.getByShortUrl("s/" + shortUrl);
            log.info(String.format("Device [%s], URL object is %s", device, url));
            if (url != null) {
                Statistics statistics = url.getStatistics();
                if (device != null) {
                    if (device.isNormal()) {
                        statistics.setCountPcClick(statistics.getCountPcClick() + 1);
                    } else if (device.isMobile()) {
                        statistics.setCountMobileClick((statistics.getCountMobileClick() + 1));
                    } else if (device.isTablet()) {
                        statistics.setCountTabletClick(statistics.getCountTabletClick() + 1);
                    }
                } else {
                    statistics.setCountPcClick(statistics.getCountPcClick() + 1);
                }
                statisticsService.save(statistics);
                String longUrl = url.getLongUrl();
                return String.format("redirect:%s", longUrl);
            } else {
                return "errors/404";
            }
        } else {
            return "errors/404";
        }
    }
}
