package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.TouristConcentration;

import java.util.List;

public interface TouristConcentrationService {
    void createTouristConcentration(TouristConcentration concentration);
    List<TouristConcentration> getAllTouristConcentrations();
    TouristConcentration getTouristConcentrationById(Long id);

}
