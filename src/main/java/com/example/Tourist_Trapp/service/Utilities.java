package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.CulturalPlace;
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
    @Autowired
    private CulturalPlaceService culturalPlaceService;
    @PostConstruct
    public void init() {
        importTuristConcentrationFromCSV();
        importCulturalPlacesFromCSV();
    }
    public void importTuristConcentrationFromCSV() {
        if (turistConcentrationService.getAllTuristConcentrations().isEmpty()) {
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
        } else {
            System.out.println("Repository is not empty, skipping import.");
        }
    }
    public void importCulturalPlacesFromCSV() {
        if (culturalPlaceService.getAllCulturalPlaces().isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Utilities.class.getResourceAsStream("/opendatabcn_pics-csv_clean.csv"), StandardCharsets.UTF_8))) {
                reader.lines().skip(1).map(line -> {
                    String[] fields = line.split(",");
                    return new CulturalPlace(null, fields[0], fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]));
                }).forEach(place -> culturalPlaceService.createCulturalPlace(place));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Repository is not empty, skipping import.");
        }
    }
}