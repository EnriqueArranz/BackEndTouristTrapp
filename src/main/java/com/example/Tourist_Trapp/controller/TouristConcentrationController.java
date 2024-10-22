package com.example.Tourist_Trapp.controller;

import com.example.Tourist_Trapp.exceptions.ResourceNotFoundException;
import com.example.Tourist_Trapp.model.CulturalPlace;
import com.example.Tourist_Trapp.model.TouristConcentration;
import com.example.Tourist_Trapp.repository.CulturalPlaceRepository;
import com.example.Tourist_Trapp.service.CulturalPlaceService;
import com.example.Tourist_Trapp.service.TouristConcentrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/touristConcentration")
public class TouristConcentrationController {
    @Autowired
    private CulturalPlaceService culturalPlaceService;
    @Autowired
    private TouristConcentrationService touristConcentrationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<TouristConcentration>> getAllTouristConcentration() {
        return ResponseEntity.ok(touristConcentrationService.getAllTouristConcentration().getBody());
    }
}
