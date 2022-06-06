package cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.domain.Fruita;
import cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.repository.FruitaRepo;

@Service
public class FruitaServiceImp implements FruitaService{
	
	@Autowired
	private FruitaRepo fruitaRepo;

	@Transactional
	public Fruita add(Fruita fruita) {
		return fruitaRepo.save(fruita);
	}

	@Transactional
	public Fruita update(Fruita fruita) throws Exception {
		try {
			Optional <Fruita> op =fruitaRepo.findById(fruita.getId());
			if (op.isPresent()) {
				Fruita f=op.get();
				f.setId(fruita.getId());
				f.setNom(fruita.getNom());
				f.setQuantitatKg(fruita.getQuantitatKg());
				f= fruitaRepo.save(fruita);
				return f;
			}else {
				throw new Exception();
			}
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Transactional
	public boolean delete(int id) throws Exception {
		try {
			if (fruitaRepo.existsById(id)) {
				fruitaRepo.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Transactional
	public Fruita getOne(int id) {
		Optional<Fruita> op = fruitaRepo.findById(id);
		return op.get();
	}

	@Transactional
	public List<Fruita> getAll() {
		return fruitaRepo.findAll();
	}



}
