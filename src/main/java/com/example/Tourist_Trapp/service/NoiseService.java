package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.CulturalPlace;
import com.example.Tourist_Trapp.model.Noise;
import com.example.Tourist_Trapp.repository.CulturalPlaceRepository;
import com.example.Tourist_Trapp.repository.NoiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class NoiseService {

    @Autowired
    private  NoiseRepository noiseRepository;



    public List<Noise> getAllNoiseData() {
        return noiseRepository.findAll();
    }

    public Optional<Noise> getNoiseById(Long id) {
        return noiseRepository.findById(id);
    }

    public Noise createNoise(Noise noise) {
        return noiseRepository.save(noise);
    }

    public Noise updateNoise(Long id, Noise updatedNoise) {
        return noiseRepository.findById(id).map(noise -> {
            noise.setSoundLevel(updatedNoise.getSoundLevel());
            noise.setLat(updatedNoise.getLat());
            noise.setLan(updatedNoise.getLan());
            noise.setDate(updatedNoise.getDate());
            return noiseRepository.save(noise);
        }).orElseThrow(() -> new IllegalArgumentException("Noise not found"));
    }

    public void deleteNoise(Long id) {
        noiseRepository.deleteById(id);
    }
}
