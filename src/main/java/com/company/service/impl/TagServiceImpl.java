package com.company.service.impl;

import com.company.entity.Tag;
import com.company.repository.TagRepository;
import com.company.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Service(value = "tagService")
@Transactional
public class TagServiceImpl implements TagService {

    private final TagRepository repository;

    @Autowired
    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tag add(Tag tag) {
        Tag foundTag = findByName(tag.getName());
        if (foundTag != null) {
            foundTag.getUrls().add(tag.getUrls().iterator().next());
            return repository.saveAndFlush(foundTag);
        } else {
            return repository.saveAndFlush(tag);
        }
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Tag edit(Tag tag) {
        return repository.saveAndFlush(tag);
    }

    @Override
    public Tag findByName(String tagName) {
        return repository.findByName(tagName);
    }

    @Override
    public List<Tag> getAll() {
        return repository.findAll();
    }

}
