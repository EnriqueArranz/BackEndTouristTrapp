package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.CulturalPlace;
import com.example.Tourist_Trapp.model.TouristConcentration;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CulturalPlaceService {
    List<CulturalPlace> getAllCulturalPlaces();
    Optional<CulturalPlace> getCulturalPlaceById(Long id);
    CulturalPlace createCulturalPlace(CulturalPlace place);
    CulturalPlace updateCulturalPlace(Long id, CulturalPlace place);
    ResponseEntity<List<CulturalPlace>> getAllPlaces();
    void deleteCulturalPlaceById(Long id);
    double getProximityPercentage(double poiLat, double poiLon, double maxDistance);

    void saveAll(List<CulturalPlace> places);
}