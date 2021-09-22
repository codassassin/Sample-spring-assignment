package com.codassassin.tourmanagement.controller;


import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.services.ITourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tour-package")
public class TourPackageController {

    @Autowired
    private ITourPackageService tourpackageservice;

    // build get all package REST API
    @GetMapping
    public List<TourPackage> getAllTourPackages() {
        return tourpackageservice.getAllTourPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourPackage> getTourPackage(@PathVariable("id") long id) {
        return new ResponseEntity<TourPackage>(tourpackageservice.getTourPackage(id), HttpStatus.OK);
    }

    // build create tour package REST API
    @PostMapping()
    public ResponseEntity<TourPackage> saveTourPackage(@RequestBody TourPackage tourpackage) {
        return new ResponseEntity<TourPackage>(tourpackageservice.saveTourPackage(tourpackage), HttpStatus.CREATED);
    }

    // build edit tour package REST API
    @PutMapping("/{id}")
    public ResponseEntity<TourPackage> updateTourPackage(@PathVariable("id") long id,
                                                         @RequestBody TourPackage tourpackage) {
        return new ResponseEntity<TourPackage>(tourpackageservice.updateTourPackage(tourpackage, id), HttpStatus.OK);
    }

    // build delete tour package REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {

        // delete from DB
        tourpackageservice.deleteTourPackage(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
