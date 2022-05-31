package cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.repository;


import cat.itacademy.barcelonactiva.barbero.yasmina.s04.t02.n01.S04T02N01BarberoYasmina.model.domain.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitaRepo extends JpaRepository <Fruita, Integer>{

	
	
}
