package com.company.service.impl;

import com.company.entity.Statistics;
import com.company.entity.Tag;
import com.company.entity.Url;
import com.company.entity.User;
import com.company.repository.UrlRepository;
import com.company.service.TagService;
import com.company.service.UrlService;
import com.company.service.UserService;
import com.company.service.generator.ShortUrlGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Service(value = "urlService")
@Transactional
public class UrlServiceImpl implements UrlService {

    private final UrlRepository repository;
    private final UserService userService;
    private final TagService tagService;
    private final ShortUrlGenerator shortUrlGenerator;
    private final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);

    @Autowired
    public UrlServiceImpl(UrlRepository repository, UserService userService, TagService tagService, ShortUrlGenerator shortUrlGenerator) {
        this.repository = repository;
        this.userService = userService;
        this.tagService = tagService;
        this.shortUrlGenerator = shortUrlGenerator;
    }

    @Override
    public void save(Url url) {
        url.setShortUrl(shortUrlGenerator.generate());
        url.setStatistics(new Statistics(url, 0L, 0L, 0L));
        for (Tag tag : url.getTags()) {
            tag.setUrls(Stream.of(url).collect(Collectors.toSet()));
            tagService.save(tag);
        }
        try {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            url.setUser(userService.findByLogin(user.getUsername()));
        } catch (ClassCastException exc) {
            url.setUser(null);
        }
        repository.save(url);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(Url url) {
        Url existingUrl = findById(url.getId());
        if (existingUrl != null) {
            repository.save(existingUrl);
        } else {
            logger.error(String.format("The object %s doesn't exist", url));
        }
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