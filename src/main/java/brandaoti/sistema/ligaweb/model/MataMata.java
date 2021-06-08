package brandaoti.sistema.ligaweb.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import brandaoti.sistema.ligaweb.controller.LigawebController;

@Entity
public class MataMata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //Esse número é o ID automático gerado.
	
	@Column
	private Integer ordem = 0;
	
	@Column
	private Boolean vencedor = null;
	
	@Column
	private String jogador;
	
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String escudo;
	
	@Column
	private Boolean preenchido = false;
	@Column
	private Boolean finalizado = false;
	@Column
	private Boolean ativo = true;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Boolean getPreenchido() {
		return preenchido;
	}
	public void setPreenchido(Boolean preenchido) {
		this.preenchido = preenchido;
	}
	public Boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public String getEscudo() {
		return escudo;
	}
	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public Boolean getVencedor() {
		return vencedor;
	}
	public void setVencedor(Boolean vencedor) {
		this.vencedor = vencedor;
	}
	
	
	
	
}
