package com.example.Tourist_Trapp.repository;

import com.example.Tourist_Trapp.model.culturalPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturalPlaceRepository extends JpaRepository<culturalPlace, Long> {
}