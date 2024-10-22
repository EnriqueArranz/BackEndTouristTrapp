package com.example.Tourist_Trapp.repository;

import com.example.Tourist_Trapp.model.Noise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoiseRepository extends JpaRepository<Noise, Long> {

}


