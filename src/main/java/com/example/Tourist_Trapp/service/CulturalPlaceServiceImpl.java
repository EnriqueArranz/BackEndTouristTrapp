package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.CulturalPlace;
import com.example.Tourist_Trapp.repository.CulturalPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CulturalPlaceServiceImpl implements CulturalPlaceService {

    @Autowired
    private CulturalPlaceRepository culturalPlaceRepository;

    public List<CulturalPlace> getAllCulturalPlaces() {
        return culturalPlaceRepository.findAll();
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in km
    }

    public double calculateProximityPercentage(double distance, double maxDistance) {
        if (distance > maxDistance) {
            return 0;
        }
        return ((maxDistance - distance) / maxDistance) * 100;
    }

    public double getProximityPercentage(double poiLat, double poiLon, double maxDistance) {
        List<CulturalPlace> culturalPlaces = getAllCulturalPlaces();
        double closestDistance = Double.MAX_VALUE;

        for (CulturalPlace place : culturalPlaces) {
            double distance = calculateDistance(poiLat, poiLon, place.getLat(), place.getLon());
            if (distance < closestDistance) {
                closestDistance = distance;
            }
        }

        return calculateProximityPercentage(closestDistance, maxDistance);
    }

    @Override
    public void saveAll(List<CulturalPlace> places) {
        culturalPlaceRepository.saveAll(places);
    }

    public Optional<CulturalPlace> getCulturalPlaceById(Long id) {
        return culturalPlaceRepository.findById(id);
    }

    public CulturalPlace createCulturalPlace(CulturalPlace place) {
        return culturalPlaceRepository.save(place);
    }

    public CulturalPlace updateCulturalPlace(Long id, CulturalPlace place) {
        place.setId(id);
        return culturalPlaceRepository.save(place);
    }

    @Override
    public ResponseEntity<List<CulturalPlace>> getAllPlaces() {
        return ResponseEntity.ok(getAllCulturalPlaces());
    }

    public void deleteCulturalPlaceById(Long id) {
        culturalPlaceRepository.deleteById(id);
    }
}