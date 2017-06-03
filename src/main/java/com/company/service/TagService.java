package com.company.service;


import com.company.entity.Tag;

import java.util.List;

public interface TagService {

    void save(Tag tag);

    void delete(Long id);

    void update(Tag tag);

    Tag findById(Long id);

    Tag findByName(String name);

    List<Tag> findAll();

}
