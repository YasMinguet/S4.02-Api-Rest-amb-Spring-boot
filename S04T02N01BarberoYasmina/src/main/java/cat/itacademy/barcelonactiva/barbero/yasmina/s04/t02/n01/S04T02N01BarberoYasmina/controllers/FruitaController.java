package cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.domain.Fruita;
import cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.services.FruitaService;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

	@Autowired
	FruitaService fruitaService;

	@RequestMapping(value = "/getAll")
	public ResponseEntity<List<Fruita>> getAll(@RequestParam(required = false) String nom) {
		try {
			List<Fruita> fruites = new ArrayList<Fruita>();
			if (nom == null)
				fruitaService.getAll().forEach(fruites::add);
			if (fruites.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(fruites, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getOne/{id}")
	public ResponseEntity<Fruita> getOne(@PathVariable("id") int id) {

		try {
			Fruita fruita = fruitaService.getOne(id);
			if (fruita != null) {
				return new ResponseEntity<>(fruita, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<String> addFruita(@RequestBody Fruita fruita) {
		try {
			fruitaService.add(new Fruita(fruita.getNom(), fruita.getId(), fruita.getQuantitatKg()));
			return new ResponseEntity<>("La fruita s'ha afegit correctament.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Fruita fruita) {
		try {
			Fruita f = fruitaService.update(fruita);
			if (f == null) {
				return new ResponseEntity<>("No es troba la fruita amb id: " + id, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("La fruita s'ha actualitzat correctament.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("No s'ha pogut actualitzar la fruita amb id: " + id,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		try {
			boolean result = fruitaService.delete(id);
			if (result == false) {
				return new ResponseEntity<>("\"No es troba la fruita amb id: " + id, HttpStatus.OK);
			}
			return new ResponseEntity<>("La fruita s'ha esborrat correctament.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("No s'ha pogut esborrar la fruita amb id", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
