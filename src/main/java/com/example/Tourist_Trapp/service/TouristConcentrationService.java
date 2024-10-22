package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.TouristConcentration;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TouristConcentrationService {
    List<TouristConcentration> getAllTouristConcentrations();
    Optional<TouristConcentration> getTouristConcentrationById(Long id);
    ResponseEntity<List<TouristConcentration>> getAllTouristConcentration();
    void createTouristConcentration(TouristConcentration concentration);

    void saveAll(List<TouristConcentration> concentrations);
}
