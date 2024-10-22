package com.example.Tourist_Trapp.service;

import com.example.Tourist_Trapp.model.CulturalPlace;
import com.example.Tourist_Trapp.model.Noise;
import com.example.Tourist_Trapp.model.TouristConcentration;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class Utilities {
    @Autowired
    private TouristConcentrationService turistConcentrationService;
    @Autowired
    private CulturalPlaceService culturalPlaceService;
    @Autowired
    private NoiseService noiseService;

    @PostConstruct
    public void init() {
        importTuristConcentrationFromCSV();
        importCulturalPlacesFromCSV();
        importNoiseFromCSV();
    }

    public void importTuristConcentrationFromCSV() {
        if (turistConcentrationService.getAllTouristConcentrations().isEmpty()) {
            List<TouristConcentration> concentrations = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Utilities.class.getResourceAsStream("/2019_turisme_allotjament_clean.csv"), StandardCharsets.UTF_8))) {
                reader.lines().skip(1).forEach(line -> {
                    String[] fields = line.split(",");
                    TouristConcentration concentration = new TouristConcentration(
                            null,
                            Double.parseDouble(fields[0]),
                            Double.parseDouble(fields[1]),
                            LocalDate.parse(fields[2], formatter)
                    );
                    concentrations.add(concentration);
                });
                turistConcentrationService.saveAll(concentrations);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Repository is not empty, skipping import.");
        }
    }

    public void importCulturalPlacesFromCSV() {
        if (culturalPlaceService.getAllCulturalPlaces().isEmpty()) {
            List<CulturalPlace> places = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Utilities.class.getResourceAsStream("/opendatabcn_pics-csv_clean.csv"), StandardCharsets.UTF_8))) {
                reader.lines().skip(1).forEach(line -> {
                    String[] fields = line.split(",");
                    CulturalPlace place = new CulturalPlace(null, fields[0], fields[1], fields[2],
                            Double.parseDouble(fields[3]), Double.parseDouble(fields[4]));
                    places.add(place);
                });
                culturalPlaceService.saveAll(places);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Repository is not empty, skipping import.");
        }
    }

    public void importNoiseFromCSV() {
        if (noiseService.getAllNoiseData().isEmpty()) {
            List<Noise> noises = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Utilities.class.getResourceAsStream("/soroll_clean.csv"), StandardCharsets.UTF_8))) {
                reader.lines().skip(1).forEach(line -> {
                    String[] fields = line.split(",");
                    LocalDate date = LocalDate.parse(fields[0]);
                    double soundLevel = Double.parseDouble(fields[1]);
                    double lat = Double.parseDouble(fields[2]);
                    double lon = Double.parseDouble(fields[3]);
                    noises.add(new Noise(null, date, soundLevel, lat, lon));
                });
                // Insertar en la base de datos en lote
                noiseService.saveAll(noises);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Repository is not empty, skipping import.");
        }
    }
}