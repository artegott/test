package com.company.service;


import com.company.persistence.entity.Tag;

import java.util.List;

public interface TagService {

    Tag save(Tag tag);

    void delete(Long id);

    Tag findById(Long id);

    Tag findByName(String name);

    List<Tag> findAll();

}
