package com.codassassin.tourmanagement.controller;


import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.services.ITourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tour-package")
public class TourPackageController {

    @Autowired
    private ITourPackageService tourPackageService;

    // build get all package REST API
    @GetMapping
    @RolesAllowed({"OPERATOR", "REGISTERED_USER"})
    public List<TourPackage> getAllTourPackages() {
        return tourPackageService.getAllTourPackages();
    }

    @GetMapping("/{id}")
    @RolesAllowed({"OPERATOR", "REGISTERED_USER"})
    public ResponseEntity<TourPackage> getTourPackage(@PathVariable("id") long id) {
        return new ResponseEntity<TourPackage>(tourPackageService.getTourPackage(id), HttpStatus.OK);
    }

    // build create tour package REST API
    @PostMapping()
    @RolesAllowed({"OPERATOR"})
    public ResponseEntity<TourPackage> saveTourPackage(@RequestBody TourPackage tourpackage) {
        return new ResponseEntity<TourPackage>(tourPackageService.saveTourPackage(tourpackage), HttpStatus.CREATED);
    }

    // build edit tour package REST API
    @PutMapping("/{id}")
    @RolesAllowed({"OPERATOR"})
    public ResponseEntity<TourPackage> updateTourPackage(@PathVariable("id") long id,
                                                         @RequestBody TourPackage tourpackage) {
        return new ResponseEntity<TourPackage>(tourPackageService.updateTourPackage(tourpackage, id), HttpStatus.OK);
    }

    // build delete tour package REST API
    @DeleteMapping("/{id}")
    @RolesAllowed({"OPERATOR"})
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {

        // delete from DB
        tourPackageService.deleteTourPackage(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
