package com.codassassin.tourmanagement.controller;


import com.codassassin.tourmanagement.model.Tags;
import com.codassassin.tourmanagement.services.TagsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagsController {

    private TagsService tagsService;

    // build get all package REST API
    @GetMapping
    @RolesAllowed({"OPERATOR"})
    public List<Tags> getAllTags() {
        return tagsService.getAllTags();
    }

    @GetMapping("/{id}")
    @RolesAllowed({"OPERATOR"})
    public ResponseEntity<Tags> getTag(@PathVariable("id") long id) {
        return new ResponseEntity<Tags>(tagsService.getTag(id), HttpStatus.OK);
    }

    // build create tour package REST API
    @PostMapping()
    @RolesAllowed({"OPERATOR"})
    public ResponseEntity<Tags> saveTag(@RequestBody Tags tag) {
        return new ResponseEntity<Tags>(tagsService.saveTag(tag), HttpStatus.CREATED);
    }

    // build delete tour package REST API
    @DeleteMapping("/{id}")
    @RolesAllowed({"OPERATOR"})
    public ResponseEntity<String> deleteTag(@PathVariable("id") long id) {

        // delete from DB
        tagsService.deleteTag(id);
        return new ResponseEntity<String>("Tag deleted successfully", HttpStatus.OK);
    }
}
