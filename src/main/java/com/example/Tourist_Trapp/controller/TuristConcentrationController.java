package com.example.Tourist_Trapp.controller;

import com.example.Tourist_Trapp.model.turistConcentration;
import com.example.Tourist_Trapp.repository.TuristConcentrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/turistConcentration")
public class TuristConcentrationController {

    @Autowired
    private TuristConcentrationRepository repository;

    @GetMapping
    public List<turistConcentration> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public turistConcentration getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public turistConcentration create(@RequestBody turistConcentration concentration) {
        return repository.save(concentration);
    }

    @PutMapping("/{id}")
    public turistConcentration update(@PathVariable Long id, @RequestBody turistConcentration concentration) {
        concentration.setId(id);
        return repository.save(concentration);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/import")
    public List<turistConcentration> importFromCSV() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("/turistConcentration.csv"), StandardCharsets.UTF_8))) {
            return reader.lines().skip(1).map(line -> {
                String[] fields = line.split(",");
                return new turistConcentration(null, Double.parseDouble(fields[0]), Double.parseDouble(fields[1]), LocalDate.parse(fields[2]));
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}