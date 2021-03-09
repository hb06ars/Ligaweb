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
public class Classificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //Esse número é o ID automático gerado.
	
	@OneToOne
	private Usuario jogador;
	
	@Column
	private Boolean ativo = true;
	
	@Column
	private Integer jogos = 0;
	
	@Column
	private Integer pontos = 0;
	
	@Column
	private Integer vitorias = 0;
	
	@Column
	private Integer empates = 0;
	
	@Column
	private Integer derrotas = 0;
	
	@Column
	private Integer gp = 0;
	
	@Column
	private Integer gc = 0;
	
	@Column
	private Integer sg = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getJogador() {
		return jogador;
	}

	public void setJogador(Usuario jogador) {
		this.jogador = jogador;
	}

	public Integer getJogos() {
		return jogos;
	}

	public void setJogos(Integer jogos) {
		this.jogos = jogos;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}

	public Integer getEmpates() {
		return empates;
	}

	public void setEmpates(Integer empates) {
		this.empates = empates;
	}

	public Integer getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}

	public Integer getGp() {
		return gp;
	}

	public void setGp(Integer gp) {
		this.gp = gp;
	}

	public Integer getGc() {
		return gc;
	}

	public void setGc(Integer gc) {
		this.gc = gc;
	}

	public Integer getSg() {
		return sg;
	}

	public void setSg(Integer sg) {
		this.sg = sg;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
