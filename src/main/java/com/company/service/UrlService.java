package com.company.service;


import com.company.entity.Tag;
import com.company.entity.Url;
import com.company.entity.User;

import java.util.List;
import java.util.Set;

public interface UrlService {

    void save(Url url);

    void delete(Long id);

    void update(Url url);

    Url getByShortUrl(String shortUrl);

    List<Url> findAll();

    Url findById(Long id);

    List<Url> findByUser(User user);

    List<Url> findByTags(Set<Tag> tags);

}
