package com.company.controller;


import com.company.entity.Statistics;
import com.company.entity.Url;
import com.company.service.StatisticsService;
import com.company.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/s/{shortUrl}")
public class MainController {
    private final UrlService urlService;
    private final StatisticsService statisticsService;

    @Autowired
    public MainController(UrlService urlService, StatisticsService statisticsService) {
        this.urlService = urlService;
        this.statisticsService = statisticsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void redirect(@PathVariable String shortUrl, HttpServletResponse response, HttpServletRequest request) {
        Device device = DeviceUtils.getCurrentDevice(request);
        try {
            if (!shortUrl.isEmpty()) {
                Url url = urlService.getByShortUrl("s/" + shortUrl);
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
                    statisticsService.edit(statistics);
                    urlService.edit(url);
                    String longUrl = url.getLongUrl();
                    response.sendRedirect(longUrl);
                } else {
                    response.sendRedirect("/404");
                }
            } else {
                response.sendRedirect("/404");
            }
        } catch (IOException ignored) {
        }
    }
}
