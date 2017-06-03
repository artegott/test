package com.company.service;


import com.company.entity.Tag;
import com.company.entity.Url;
import com.company.entity.User;

import java.util.List;
import java.util.Set;

public interface UrlService {

    Url add(Url url);

    void delete(long id);

    Url edit(Url url);

    Url getByShortUrl(String shortUrl);

    List<Url> getAll();

    List<Url> getByUser(User user);

    List<Url> getByTags(Set<Tag> tags);

}
