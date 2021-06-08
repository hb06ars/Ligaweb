package brandaoti.sistema.ligaweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brandaoti.sistema.ligaweb.model.Finais;
import brandaoti.sistema.ligaweb.model.MataMata;
import brandaoti.sistema.ligaweb.model.Oitavas;
import brandaoti.sistema.ligaweb.model.Perfil;
import brandaoti.sistema.ligaweb.model.Quartas;
import brandaoti.sistema.ligaweb.model.SemiFinal;

public interface FinaisDao extends JpaRepository<Finais, Integer> {
	
	@Query(" select p from Finais p where p.ativo = 1 ")
	List<Finais> todos();
	
}
