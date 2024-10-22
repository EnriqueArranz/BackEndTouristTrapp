package com.example.Tourist_Trapp.repository;

import com.example.Tourist_Trapp.model.TouristConcentration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristConcentrationRepository extends JpaRepository<TouristConcentration, Long> {
}
