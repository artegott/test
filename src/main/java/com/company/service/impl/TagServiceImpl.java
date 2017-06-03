package com.company.service.impl;

import com.company.entity.Tag;
import com.company.repository.TagRepository;
import com.company.service.TagService;
import org.slf4j.Logger;
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
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(TagServiceImpl.class);

    @Autowired
    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Tag tag) {
        Tag existingTag = findByName(tag.getName());
        if (existingTag != null) {
            existingTag.getUrls().add(tag.getUrls().iterator().next());
            repository.save(existingTag);
        } else {
            logger.error(String.format("The object %s doesn't exist", tag));
        }
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(Tag tag) {
        Tag existingTag = findByName(tag.getName());
        if (existingTag != null) {
            existingTag.setUrls(tag.getUrls());
            repository.save(existingTag);
        } else {
            logger.error(String.format("The object %s doesn't exist", tag));
        }
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
