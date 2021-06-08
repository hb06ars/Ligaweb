package brandaoti.sistema.ligaweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brandaoti.sistema.ligaweb.model.MataMata;
import brandaoti.sistema.ligaweb.model.Oitavas;
import brandaoti.sistema.ligaweb.model.Perfil;
import brandaoti.sistema.ligaweb.model.Quartas;
import brandaoti.sistema.ligaweb.model.SemiFinal;

public interface QuartasDao extends JpaRepository<Quartas, Integer> {
	
	@Query(" select p from Quartas p where p.ativo = 1 ")
	List<Quartas> todos();
	
}
