package brandaoti.sistema.ligaweb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brandaoti.sistema.ligaweb.model.Classificacao;
import brandaoti.sistema.ligaweb.model.Resultado;
import brandaoti.sistema.ligaweb.model.Usuario;

public interface ClassificacaoDao extends JpaRepository<Classificacao, Integer> {
	
	@Query("select r from Classificacao r where r.ativo = true order by r.pontos desc, r.sg desc, r.gp desc, r.gc asc, r.jogador.nome  asc")
	List<Classificacao> todaClassificacao();
	
	@Query("select r from Classificacao r where r.jogador.id like (:id)")
	Classificacao minhaClassificacao(@Param("id") Integer id);

}
