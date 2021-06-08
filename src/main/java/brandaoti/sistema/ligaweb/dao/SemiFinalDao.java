package brandaoti.sistema.ligaweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brandaoti.sistema.ligaweb.model.MataMata;
import brandaoti.sistema.ligaweb.model.Perfil;
import brandaoti.sistema.ligaweb.model.SemiFinal;

public interface SemiFinalDao extends JpaRepository<SemiFinal, Integer> {
	
	@Query(" select p from SemiFinal p where p.ativo = 1 ")
	List<SemiFinal> todos();
	
}
