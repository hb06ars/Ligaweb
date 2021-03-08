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
public class Resultado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //Esse número é o ID automático gerado.
	
	@Column
	private Boolean finalizado = false;
	
	@Column
	private Boolean cancelado = false;
	
	@Column
	//Você pode gerar o tamanho que desejar e se for obrigatório.
	private String motivoCancelamento;
	
	@Column
	//Você pode gerar o tamanho que desejar e se for obrigatório.
	private LocalDateTime data = LocalDateTime.now();
	
	@OneToOne
	private Usuario jogador1;
	
	@Column
	private Integer jogador1_placar = 0;
	
	@OneToOne
	private Usuario jogador2;
	
	@Column
	private Integer jogador2_placar = 0;
	
	@Column
	private Boolean confirmado_jogador1 = false;
	
	@Column
	private Boolean confirmado_jogador2 = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Boolean getCancelado() {
		return cancelado;
	}

	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public String getDataAjustada() {
		LocalDateTime myDateObj = data;
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;
	}
	
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Usuario getJogador1() {
		return jogador1;
	}

	public void setJogador1(Usuario jogador1) {
		this.jogador1 = jogador1;
	}

	public Integer getJogador1_placar() {
		return jogador1_placar;
	}

	public void setJogador1_placar(Integer jogador1_placar) {
		this.jogador1_placar = jogador1_placar;
	}

	public Usuario getJogador2() {
		return jogador2;
	}

	public void setJogador2(Usuario jogador2) {
		this.jogador2 = jogador2;
	}

	public Integer getJogador2_placar() {
		return jogador2_placar;
	}

	public void setJogador2_placar(Integer jogador2_placar) {
		this.jogador2_placar = jogador2_placar;
	}

	public Boolean getConfirmado_jogador1() {
		return confirmado_jogador1;
	}

	public void setConfirmado_jogador1(Boolean confirmado_jogador1) {
		this.confirmado_jogador1 = confirmado_jogador1;
	}

	public Boolean getConfirmado_jogador2() {
		return confirmado_jogador2;
	}

	public void setConfirmado_jogador2(Boolean confirmado_jogador2) {
		this.confirmado_jogador2 = confirmado_jogador2;
	}
	
	
	
	
}
