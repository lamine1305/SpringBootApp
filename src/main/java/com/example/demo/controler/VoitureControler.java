package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Voiture;
import com.example.demo.repository.VoitureRepository;

@RestController
@RequestMapping("/voitures")
public class VoitureControler {

	@Autowired
	VoitureRepository voitureRepository;

	@GetMapping("/all")
	public List<Voiture> getListVoiture() {

		return voitureRepository.findAll();
	}

	@GetMapping("/findByMarque")
	public List<Voiture> getVoitureByMarque(@RequestParam("ma") String marque) {
		List<Voiture> v = voitureRepository.findVoitureByMarque(marque);
		return v;
	}

	@DeleteMapping("/deleteByMarque")
	public void deleteVoitureByMarque(@RequestParam String marque) {

		System.out.println("marque " + marque);
		List<Voiture> voitures = voitureRepository.findVoitureByMarque(marque);
		voitures.stream().forEach(voiture -> voitureRepository.delete(voiture));
	}

	@DeleteMapping("/deleteById")
	public void deleteVoitureById(@RequestParam Long idVoiture) {
		voitureRepository.deleteById(idVoiture);
	}

	@PostMapping("/ajout")
	public void addVoiture(@RequestBody Voiture voiture) {
		voitureRepository.save(voiture);
	}
}
