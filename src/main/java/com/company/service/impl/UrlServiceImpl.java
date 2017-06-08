package com.company.service.impl;

import com.company.persistence.entity.Statistics;
import com.company.persistence.entity.Tag;
import com.company.persistence.entity.Url;
import com.company.persistence.entity.User;
import com.company.persistence.repository.UrlRepository;
import com.company.service.TagService;
import com.company.service.UrlService;
import com.company.service.UserService;
import com.company.service.generator.ShortUrlGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Service(value = "urlService")
@Transactional
public class UrlServiceImpl implements UrlService {

    private final UrlRepository repository;
    private final UserService userService;
    private final TagService tagService;
    private final ShortUrlGenerator shortUrlGenerator;
    private final Logger log = LoggerFactory.getLogger(UrlServiceImpl.class);


    @Autowired
    public UrlServiceImpl(UrlRepository repository, UserService userService, TagService tagService, ShortUrlGenerator shortUrlGenerator) {
        this.repository = repository;
        this.userService = userService;
        this.tagService = tagService;
        this.shortUrlGenerator = shortUrlGenerator;
    }

    @Override
    public Url save(Url url) {
        if (url.getShortUrl() != null) {
            return update(url);
        } else {
            url.setShortUrl(shortUrlGenerator.generate());
            url.setStatistics(new Statistics(url, 0L, 0L, 0L));
            Set<Url> urls = new HashSet<>();
            Set<Tag> tags = new HashSet<>();
            urls.add(url);
            for (Tag tag : url.getTags()) {
                tag.setUrls(urls);
                tags.add(tagService.save(tag));
            }
            url.setTags(tags);
            if (url.getUser() == null) {
                try {
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    if (userService.exists(authentication.getName())) {
                        url.setUser(userService.findByLogin(authentication.getName()));
                    }
                } catch (ClassCastException exc) {
                    url.setUser(null);
                }
            }
            return repository.save(url);
        }
    }

    private Url update(Url url) {
        Url link = getByShortUrl(url.getShortUrl());
        link.setName(url.getName());
        link.setDescription(url.getDescription());
        Set<Tag> tags = new HashSet<>();
        HashSet<Url> urlList = new HashSet<>();
        urlList.add(link);
        for (Tag tag : url.getTags()) {
            tag.setUrls(urlList);
            tags.add(tagService.save(tag));
        }
        link.setTags(tags);
        return repository.saveAndFlush(link);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Url getByShortUrl(String shortUrl) {
        return repository.findByShortUrl(shortUrl);
    }

    @Override
    public List<Url> findAll() {
        return repository.findAll();
    }

    @Override
    public Url findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Url> findByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public List<Url> findByTags(Set<Tag> tags) {
        return repository.findByTags(tags);
    }

}