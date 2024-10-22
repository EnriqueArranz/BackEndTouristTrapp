package com.example.Tourist_Trapp.controller;

import com.example.Tourist_Trapp.model.Noise;
import com.example.Tourist_Trapp.service.NoiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noise")
public class NoiseController {

    @Autowired
    private NoiseService noiseService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Noise>> getAllNoise() {
        return ResponseEntity.ok(noiseService.getAllNoises().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noise> getNoiseById(@PathVariable Long id) {
        return noiseService.getNoiseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Noise> createNoise(@RequestBody Noise noise) {
        Noise createdNoise = noiseService.createNoise(noise);
        return ResponseEntity.ok(createdNoise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noise> updateNoise(@PathVariable Long id, @RequestBody Noise updatedNoise) {
        Noise updated = noiseService.updateNoise(id, updatedNoise);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoise(@PathVariable Long id) {
        noiseService.deleteNoise(id);
        return ResponseEntity.noContent().build();
    }
}
