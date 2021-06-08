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
public class SemiFinal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //Esse número é o ID automático gerado.
	
	@Column
	private String jogador1;
	@Column
	private Integer placarIda1;
	@Column
	private Integer placarVolta1;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String escudo1;
	
	@Column
	private String jogador2;
	@Column
	private Integer placarIda2;
	@Column
	private Integer placarVolta2;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String escudo2;
	
	
	@Column
	private String vencedor;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String escudoVencedor;
	
	@Column
	private String perdedor;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String escudoPerdedor;

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
	public String getJogador1() {
		return jogador1;
	}
	public void setJogador1(String jogador1) {
		this.jogador1 = jogador1;
	}
	public String getEscudo1() {
		return escudo1;
	}
	public void setEscudo1(String escudo1) {
		this.escudo1 = escudo1;
	}
	public String getJogador2() {
		return jogador2;
	}
	public void setJogador2(String jogador2) {
		this.jogador2 = jogador2;
	}
	public String getEscudo2() {
		return escudo2;
	}
	public void setEscudo2(String escudo2) {
		this.escudo2 = escudo2;
	}
	public String getVencedor() {
		return vencedor;
	}
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}
	public String getEscudoVencedor() {
		return escudoVencedor;
	}
	public void setEscudoVencedor(String escudoVencedor) {
		this.escudoVencedor = escudoVencedor;
	}
	public String getPerdedor() {
		return perdedor;
	}
	public void setPerdedor(String perdedor) {
		this.perdedor = perdedor;
	}
	public String getEscudoPerdedor() {
		return escudoPerdedor;
	}
	public void setEscudoPerdedor(String escudoPerdedor) {
		this.escudoPerdedor = escudoPerdedor;
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
	public Integer getPlacarIda1() {
		return placarIda1;
	}
	public void setPlacarIda1(Integer placarIda1) {
		this.placarIda1 = placarIda1;
	}
	public Integer getPlacarVolta1() {
		return placarVolta1;
	}
	public void setPlacarVolta1(Integer placarVolta1) {
		this.placarVolta1 = placarVolta1;
	}
	public Integer getPlacarIda2() {
		return placarIda2;
	}
	public void setPlacarIda2(Integer placarIda2) {
		this.placarIda2 = placarIda2;
	}
	public Integer getPlacarVolta2() {
		return placarVolta2;
	}
	public void setPlacarVolta2(Integer placarVolta2) {
		this.placarVolta2 = placarVolta2;
	}
	
	
	
}
