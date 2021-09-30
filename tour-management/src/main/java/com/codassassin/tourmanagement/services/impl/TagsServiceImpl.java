package com.codassassin.tourmanagement.services.impl;


import com.codassassin.tourmanagement.model.Tags;
import com.codassassin.tourmanagement.repository.TagsRepository;
import com.codassassin.tourmanagement.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }

    @Override
    public Tags getTag(long id) {
        return tagsRepository.getTagsById(id);
    }

    @Override
    public Tags saveTag(Tags tags) {
        return tagsRepository.save(tags);
    }

    @Override
    public void deleteTag(long id) {
        tagsRepository.getTagsById(id);
        tagsRepository.deleteTagById(id);
    }
}
