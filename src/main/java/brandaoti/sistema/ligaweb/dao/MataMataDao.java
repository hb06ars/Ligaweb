package brandaoti.sistema.ligaweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brandaoti.sistema.ligaweb.model.MataMata;
import brandaoti.sistema.ligaweb.model.Perfil;

public interface MataMataDao extends JpaRepository<MataMata, Integer> {
	
	@Query(" select p from MataMata p where p.ativo = 1 ")
	List<MataMata> todos();
	
	@Query(" select p from MataMata p where p.jogador like (:jogador) and p.escudo like (:escudo)")
	MataMata pesquisaVencedorPerdedor(@Param("jogador") String jogador, @Param("escudo") String escudo);
	
	@Query(" select p from MataMata p where p.ativo = 1 and p.finalizado = 1")
	List<MataMata> finalizados();
	
	@Query(" select p from MataMata p where p.ativo = 1 and p.preenchido = 1")
	List<MataMata> preenchidos();
	
	@Query(" select p from MataMata p where p.vencedor is null")
	List<MataMata> vencedorNulo();
	
	@Query(" select p from MataMata p where p.vencedor = 0")
	List<MataMata> encontrarEliminados();
	
	@Query(" select p from MataMata p where p.vencedor = 1")
	List<MataMata> vencedores();
	
}
