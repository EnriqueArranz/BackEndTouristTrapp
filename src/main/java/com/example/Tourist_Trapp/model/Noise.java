package com.example.Tourist_Trapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double soundLevel;

    @Column(nullable = false)
    private double lat;
    @Column(nullable = false)
    private double lan;

    @Column(nullable = false)
    private LocalDate date;
}

