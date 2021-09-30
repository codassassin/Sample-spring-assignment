package com.codassassin.tourmanagement.services;


import com.codassassin.tourmanagement.model.Tags;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagsService {
    List<Tags> getAllTags();
    Tags getTag(long id);
    Tags saveTag(Tags tags);
    void deleteTag(long id);
}
