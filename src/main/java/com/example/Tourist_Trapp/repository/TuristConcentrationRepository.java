package com.example.Tourist_Trapp.repository;

import com.example.Tourist_Trapp.model.turistConcentration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristConcentrationRepository extends JpaRepository<turistConcentration, Long> {
}
