package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.Noise;
import com.example.Tourist_Trapp.repository.NoiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class NoiseServiceImpl implements NoiseService {

    @Autowired
    private  NoiseRepository noiseRepository;



    public List<Noise> getAllNoiseData() {
        return noiseRepository.findAll();
    }

    public ResponseEntity<List<Noise>> getAllNoises() {
        return ResponseEntity.ok(getAllNoiseData());
    }


    public Optional<Noise> getNoiseById(Long id) {
        return noiseRepository.findById(id);
    }

    @Override
    public void saveAll(List<Noise> noises) {
        noiseRepository.saveAll(noises);
    }

    public Noise createNoise(Noise noise) {
        return noiseRepository.save(noise);
    }

    public Noise updateNoise(Long id, Noise updatedNoise) {
        return noiseRepository.findById(id).map(noise -> {
            noise.setSound_level_mean(updatedNoise.getSound_level_mean());
            noise.setLat(updatedNoise.getLat());
            noise.setLon(updatedNoise.getLon());
            noise.setDate(updatedNoise.getDate());
            return noiseRepository.save(noise);
        }).orElseThrow(() -> new IllegalArgumentException("Noise not found"));
    }

    public void deleteNoise(Long id) {
        noiseRepository.deleteById(id);
    }
}
