package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estudante_informacao database table.
 * 
 */
@Entity
@Table(name="estudante_informacao")
@NamedQuery(name="EstudanteInformacao.findAll", query="SELECT e FROM EstudanteInformacao e")
public class EstudanteInformacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_est_inf")
	private Long codigo;

	@Column(name="res_que_est_inf")
	private boolean respostaQuestao;

	@Column(name="res_que_txt_est_inf")
	private String respostaAbertaQuestao;

	//bi-directional many-to-one association to Estudante
	@ManyToOne
	@JoinColumn(name="cod_est")
	private Estudante estudante;

	//bi-directional many-to-one association to Questao
	@ManyToOne
	@JoinColumn(name="cod_que")
	private Questao questao;

	public EstudanteInformacao() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public boolean getRespostaQuestao() {
		return this.respostaQuestao;
	}

	public void setRespostaQuestao(boolean respostaQuestao) {
		this.respostaQuestao = respostaQuestao;
	}

	public String getRespostaAbertaQuestao() {
		return this.respostaAbertaQuestao;
	}

	public void setRespostaAbertaQuestao(String respostaAbertaQuestao) {
		this.respostaAbertaQuestao = respostaAbertaQuestao;
	}

	public Estudante getEstudante() {
		return this.estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

}