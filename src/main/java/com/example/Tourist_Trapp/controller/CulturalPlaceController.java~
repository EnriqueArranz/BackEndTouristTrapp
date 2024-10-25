package com.example.Tourist_Trapp.controller;

import com.example.Tourist_Trapp.exceptions.ResourceNotFoundException;
import com.example.Tourist_Trapp.model.CulturalPlace;
import com.example.Tourist_Trapp.repository.CulturalPlaceRepository;
import com.example.Tourist_Trapp.service.CulturalPlaceService;
import com.example.Tourist_Trapp.service.TouristConcentrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/culturalPlace")
public class CulturalPlaceController {
    @Autowired
    private CulturalPlaceService culturalPlaceService;

    @Autowired
    private CulturalPlaceRepository repository;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<CulturalPlace>> getAll() {
        return ResponseEntity.ok(culturalPlaceService.getAllPlaces().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CulturalPlace> getById(@PathVariable Long id) {
        CulturalPlace place = culturalPlaceService.getCulturalPlaceById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cultural place not found with id " + id)
        );
        return ResponseEntity.ok(place);
    }

    @PostMapping
    public ResponseEntity<CulturalPlace> create(@RequestBody CulturalPlace place) {
        CulturalPlace savedPlace = culturalPlaceService.createCulturalPlace(place);
        return ResponseEntity.status(201).body(savedPlace);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CulturalPlace> update(@PathVariable Long id, @RequestBody CulturalPlace place) {
        CulturalPlace updatedPlace = culturalPlaceService.updateCulturalPlace(id, place);
        return ResponseEntity.ok(updatedPlace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        culturalPlaceService.deleteCulturalPlaceById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/import")
    public ResponseEntity<List<CulturalPlace>> importFromCSV() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/culturalPlace.csv"), StandardCharsets.UTF_8))) {
            List<CulturalPlace> list = reader.lines().skip(1).map(line -> {
                String[] fields = line.split(",");
                return new CulturalPlace(null, fields[0], fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]));
            }).collect(Collectors.toList());
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            throw new RuntimeException("Error importing CSV", e);
        }
    }
}