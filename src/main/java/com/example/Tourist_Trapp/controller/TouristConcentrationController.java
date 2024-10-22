package com.example.Tourist_Trapp.controller;

import com.example.Tourist_Trapp.exceptions.ResourceNotFoundException;
import com.example.Tourist_Trapp.model.CulturalPlace;
import com.example.Tourist_Trapp.model.TuristConcentration;
import com.example.Tourist_Trapp.repository.CulturalPlaceRepository;
import com.example.Tourist_Trapp.service.CulturalPlaceService;
import com.example.Tourist_Trapp.service.TuristConcentrationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/touristConcentration")
public class TuristConcentrationController {
    @Autowired
    private CulturalPlaceService culturalPlaceService;
    @Autowired
    private TuristConcentrationService turistConcentrationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<TuristConcentration>> getAllTuristConcentration() {
        return ResponseEntity.ok(turistConcentrationService.getAllTuristConcentration().getBody());
    }
}
