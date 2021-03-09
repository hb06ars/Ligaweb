package brandaoti.sistema.ligaweb.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import brandaoti.sistema.ligaweb.model.Resultado;
import brandaoti.sistema.ligaweb.model.Usuario;

public interface ResultadoDao extends JpaRepository<Resultado, Integer> {
	@Query(" select u from Usuario u where upper( u.login ) like upper( :login ) and upper( u.senha ) like upper( :senha ) ")
	Usuario fazerLogin(@Param("login") String login, @Param("senha") String senha);
	
	@Query("select r from Resultado r where r.jogador1.id like (:id) or r.jogador2.id like (:id)  order by r.data desc")
	List<Resultado> meusJogos(@Param("id") Integer id);
	
	@Query("select r from Resultado r where r.finalizado = true order by r.data desc")
	List<Resultado> todosResultados();
	
	@Query("select r from Resultado r where 1=1 and ((r.jogador2.id like (:jogador1) and r.jogador1.id like (:jogador2)) or (r.jogador1.id like (:jogador1) and r.jogador2.id like (:jogador2)) and r.cancelado = false ) ")
	List<Resultado> limiteDeJogos(@Param("jogador1") Integer jogador1, @Param("jogador2") Integer jogador2);

}
