package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.TuristConcentration;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Utilities {
    @Autowired
    private TuristConcentrationService turistConcentrationService;
    @PostConstruct
    public void init() {
        importTuristConcentrationFromCSV();
    }
    public void importTuristConcentrationFromCSV() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Utilities.class.getResourceAsStream("/2019_turisme_allotjament_clean.csv"), StandardCharsets.UTF_8))) {
            reader.lines().skip(1).map(line -> {
                String[] fields = line.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return new TuristConcentration(null, Double.parseDouble(fields[0]), Double.parseDouble(fields[1]), LocalDate.parse(fields[2], formatter));
            }).forEach(concentration -> turistConcentrationService.createTuristConcentration(concentration));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}