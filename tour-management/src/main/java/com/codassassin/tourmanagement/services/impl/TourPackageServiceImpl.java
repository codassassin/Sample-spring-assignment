package com.codassassin.tourmanagement.services.impl;

import com.codassassin.tourmanagement.exception.ResourceNotFoundException;
import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.repository.TourPackageRepository;
import com.codassassin.tourmanagement.services.ITourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class TourPackageServiceImpl implements ITourPackageService {

    @Autowired
    private TourPackageRepository tourpackagerepository;

    @Override
    public List<TourPackage> getAllTourPackages() {
        return tourpackagerepository.findAll();
    }

    @Override
    public TourPackage getTourPackage(long id) {
        Optional<TourPackage> gettourpackage = tourpackagerepository.findById(id);
        return tourpackagerepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("TourPackage", "id", id));
    }

    public TourPackage saveTourPackage(TourPackage tourpackage) {
        return tourpackagerepository.save(tourpackage);
    }

    @Override
    public TourPackage updateTourPackage(TourPackage tourpackage, long id) {
        TourPackage existingtourpackage = tourpackagerepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("TourPackage", "id", id));

        existingtourpackage.setPackageName(tourpackage.getPackageName());
        existingtourpackage.setDuration(tourpackage.getDuration());
        existingtourpackage.setPrice(tourpackage.getPrice());
        tourpackagerepository.save(existingtourpackage);
        return existingtourpackage;
    }

    @Override
    public void deleteTourPackage(long id) {
        tourpackagerepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TourPackage", "id", id));

        tourpackagerepository.deleteById(id);
    }
}
