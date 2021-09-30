package com.codassassin.tourmanagement.services.impl;


import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.repository.TourPackageRepository;
import com.codassassin.tourmanagement.services.ITourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TourPackageServiceImpl implements ITourPackageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Override
    public List<TourPackage> getAllTourPackages() {
        return tourPackageRepository.findAll();
    }

    @Override
    public TourPackage getTourPackage(long id) {
        return tourPackageRepository.getTourById(id);
    }

    public TourPackage saveTourPackage(TourPackage tourpackage) {
        return tourPackageRepository.save(tourpackage);
    }

    @Override
    public TourPackage updateTourPackage(TourPackage tourpackage, long id) {
        TourPackage existingTourPackage = tourPackageRepository.getTourById(id);

        existingTourPackage.setPackageName(tourpackage.getPackageName());
        existingTourPackage.setDuration(tourpackage.getDuration());
        existingTourPackage.setPrice(tourpackage.getPrice());
        tourPackageRepository.save(existingTourPackage);
        return existingTourPackage;
    }

    @Override
    public void deleteTourPackage(long id) {
        tourPackageRepository.getTourById(id);
        tourPackageRepository.deleteTourById(id);
    }
}
