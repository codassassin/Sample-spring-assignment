package com.codassassin.tourmanagement.services;

import com.codassassin.tourmanagement.model.TourPackage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITourPackageService {
    List<TourPackage> getAllTourPackages();
    TourPackage getTourPackage(long id);
    TourPackage saveTourPackage(TourPackage tourpackage);
    TourPackage updateTourPackage(TourPackage tourpackage, long id);
    void deleteTourPackage(long id);
}
