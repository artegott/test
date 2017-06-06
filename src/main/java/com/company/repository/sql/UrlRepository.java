package com.company.repository.sql;


import com.company.entity.Tag;
import com.company.entity.Url;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByShortUrl(String shortUrl);

    List<Url> findByUser(User user);

    List<Url> findByTags(Set<Tag> tags);
}
