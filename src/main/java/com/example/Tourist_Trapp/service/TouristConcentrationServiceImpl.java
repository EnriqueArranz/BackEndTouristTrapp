package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.exceptions.BadRequestException;
import com.example.Tourist_Trapp.exceptions.ResourceNotFoundException;
import com.example.Tourist_Trapp.model.TouristConcentration;
import com.example.Tourist_Trapp.repository.TouristConcentrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristConcentrationServiceImpl implements TouristConcentrationService {
    @Autowired
    private TouristConcentrationRepository touristConcentrationRepository;

    public void createTouristConcentration(TouristConcentration concentration) {
        if (concentration == null) {
            throw new BadRequestException("TouristConcentration cannot be null");
        }
        touristConcentrationRepository.save(concentration);
    }

    public List<TouristConcentration> getAllTouristConcentrations() {
        return touristConcentrationRepository.findAll();
    }

    public TouristConcentration getTouristConcentrationById(Long id) {
        return touristConcentrationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TouristConcentration not found with id " + id));
    }

    public ResponseEntity<List<TouristConcentration>> getAllTouristConcentration() {
        return ResponseEntity.ok(getAllTouristConcentrations());
    }
}