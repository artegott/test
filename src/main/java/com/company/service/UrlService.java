package com.company.service;


import com.company.persistence.entity.Tag;
import com.company.persistence.entity.Url;
import com.company.persistence.entity.User;

import java.util.List;
import java.util.Set;

public interface UrlService {

    Url save(Url url);

    void delete(Long id);

    Url getByShortUrl(String shortUrl);

    List<Url> findAll();

    Url findById(Long id);

    List<Url> findByUser(User user);

    List<Url> findByTags(Set<Tag> tags);

}
