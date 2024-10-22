package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.exceptions.BadRequestException;
import com.example.Tourist_Trapp.exceptions.ResourceNotFoundException;
import com.example.Tourist_Trapp.model.TouristConcentration;
import com.example.Tourist_Trapp.repository.TouristConcentrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristConcentrationServiceImpl implements TouristConcentrationService {
    @Autowired
    private TouristConcentrationRepository touristConcentrationRepository;

    public void createTouristConcentration(TouristConcentration concentration) {
        touristConcentrationRepository.save(concentration);
    }

    public List<TouristConcentration> getAllTouristConcentrations() {
        return touristConcentrationRepository.findAll();
    }

    public Optional<TouristConcentration> getTouristConcentrationById(Long id) {
        return touristConcentrationRepository.findById(id);
    }


    public ResponseEntity<List<TouristConcentration>> getAllTouristConcentration() {
        return ResponseEntity.ok(getAllTouristConcentrations());
    }


}