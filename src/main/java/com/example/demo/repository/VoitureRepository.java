package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
	public List<Voiture> findVoitureByMarque(String marque);

}
