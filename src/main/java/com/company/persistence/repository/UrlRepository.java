package com.company.persistence.repository;


import com.company.persistence.entity.Url;
import com.company.persistence.entity.Tag;
import com.company.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByShortUrl(String shortUrl);

    List<Url> findByUser(User user);

    List<Url> findByTags(Set<Tag> tags);
}
