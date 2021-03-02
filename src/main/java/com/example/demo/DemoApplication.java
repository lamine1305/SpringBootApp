package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Voiture;
import com.example.demo.repository.VoitureRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	VoitureRepository voitureRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		List<Voiture> listVoitures = new ArrayList<>();
		Voiture v1 = new Voiture("mercedes", 2004, 3500);
		listVoitures.add(v1);
		Voiture v2 = new Voiture("renault", 2009, 3000);
		listVoitures.add(v2);
		Voiture v3 = new Voiture("peugeot", 2017, 9500);
		listVoitures.add(v3);
		listVoitures.forEach(v -> voitureRepository.save(v));
	}

}
