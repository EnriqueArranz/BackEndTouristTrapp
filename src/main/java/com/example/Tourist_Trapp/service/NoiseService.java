package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.Noise;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface NoiseService {

    List<Noise> getAllNoiseData();

    ResponseEntity<List<Noise>> getAllNoises();
    Noise createNoise(Noise noise);

    Noise updateNoise(Long id, Noise updatedNoise);

    void deleteNoise(Long id);
    Optional<Noise> getNoiseById(Long id);

    void saveAll(List<Noise> noises);
}
