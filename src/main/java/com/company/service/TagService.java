package com.company.service;


import com.company.entity.Tag;

import java.util.List;

public interface TagService {

    Tag add(Tag tag);

    void delete(long id);

    Tag edit(Tag tag);

    Tag findByName(String name);

    List<Tag> getAll();

}
