package cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.domain.Fruita;

public interface FruitaService {

	public Fruita add(Fruita fruita);
	public Fruita update(Fruita fruita)throws Exception;
	public boolean delete(int id) throws Exception;
	public Fruita getOne(int id);
	public List<Fruita> getAll();

}
