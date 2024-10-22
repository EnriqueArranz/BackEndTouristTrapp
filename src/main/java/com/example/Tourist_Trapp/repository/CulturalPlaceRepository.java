package com.example.Tourist_Trapp.repository;

import com.example.Tourist_Trapp.model.CulturalPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturalPlaceRepository extends JpaRepository<CulturalPlace, Long> {
}