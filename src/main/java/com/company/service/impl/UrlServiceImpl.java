package com.company.service.impl;

import com.company.entity.Statistics;
import com.company.entity.Tag;
import com.company.entity.Url;
import com.company.entity.User;
import com.company.repository.UrlRepository;
import com.company.service.StatisticsService;
import com.company.service.TagService;
import com.company.service.UrlService;
import com.company.service.UserService;
import com.company.service.generator.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Service(value = "urlService")
@Transactional
public class UrlServiceImpl implements UrlService {

    private final UrlRepository repository;
    private final UserService userService;
    private final StatisticsService statisticsService;
    private final TagService tagService;
    private final ShortUrlGenerator shortUrlGenerator;

    @Autowired
    public UrlServiceImpl(UrlRepository repository, UserService userService, StatisticsService statisticsService, TagService tagService, ShortUrlGenerator shortUrlGenerator) {
        this.repository = repository;
        this.userService = userService;
        this.statisticsService = statisticsService;
        this.tagService = tagService;
        this.shortUrlGenerator = shortUrlGenerator;
    }

    @Override
    public Url add(Url url) {
        url.setShortUrl(shortUrlGenerator.generate());
        Set<Tag> tags = new HashSet<>();
        HashSet<Url> urlList = new HashSet<>();
        urlList.add(url);
        for (Tag tag : url.getTags()) {
            tag.setUrls(urlList);
            tags.add(tagService.add(tag));
        }
        url.setTags(tags);
        Statistics statistics = new Statistics();
        statistics.setUrl(url);
        url.setStatistics(statistics);
        try {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            url.setUser(userService.getByLogin(user.getUsername()));
        } catch (ClassCastException exc) {
            url.setUser(null);
        }
        statisticsService.add(statistics);
        return repository.saveAndFlush(url);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Url edit(Url url) {
        Url link = getByShortUrl(url.getShortUrl());
        link.setName(url.getName());
        link.setDescription(url.getDescription());
        Set<Tag> tags = new HashSet<>();
        HashSet<Url> urlList = new HashSet<>();
        urlList.add(link);
        for (Tag tag : url.getTags()) {
            tag.setUrls(urlList);
            tags.add(tagService.add(tag));
        }
        link.setTags(tags);
        return repository.saveAndFlush(link);
    }

    @Override
    public Url getByShortUrl(String shortUrl) {
        return repository.findByShortUrl(shortUrl);
    }

    @Override
    public List<Url> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Url> getByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public List<Url> getByTags(Set<Tag> tags) {
        return repository.findByTags(tags);
    }

}