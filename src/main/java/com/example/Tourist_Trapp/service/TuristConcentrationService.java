package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.TuristConcentration;
import com.example.Tourist_Trapp.repository.TuristConcentrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TuristConcentrationService {
    @Autowired
    private TuristConcentrationRepository turistConcentrationRepository;

    public void createTuristConcentration(TuristConcentration concentration) {
        turistConcentrationRepository.save(concentration);
    }

    public List<TuristConcentration> getAllTuristConcentrations() {
        return turistConcentrationRepository.findAll();
    }

    public Optional<TuristConcentration> getTuristConcentrationById(Long id) {
        return turistConcentrationRepository.findById(id);
    }


    public ResponseEntity<List<TuristConcentration>> getAllTuristConcentration() {
        return ResponseEntity.ok(getAllTuristConcentrations());
    }

}
