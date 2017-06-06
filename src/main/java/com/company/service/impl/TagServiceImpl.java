package com.company.service.impl;

import com.company.entity.Tag;
import com.company.repository.sql.TagRepository;
import com.company.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);


    @Autowired
    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tag save(Tag tag) {
        Tag existingTag = findByName(tag.getName());
        if (existingTag != null) {
            existingTag.getUrls().add(tag.getUrls().iterator().next());
            return repository.save(existingTag);
        }
        return repository.save(tag);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Tag findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Tag findByName(String tagName) {
        return repository.findByName(tagName);
    }

    @Override
    public List<Tag> findAll() {
        return repository.findAll();
    }

}
