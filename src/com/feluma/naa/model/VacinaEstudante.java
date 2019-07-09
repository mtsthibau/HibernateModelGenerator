package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vacina_estudante database table.
 * 
 */
@Entity
@Table(name="vacina_estudante")
@NamedQuery(name="VacinaEstudante.findAll", query="SELECT v FROM VacinaEstudante v")
public class VacinaEstudante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_vac_est")
	private Long codigo;

	@Column(name="dat_dos_vac_est")
	private Timestamp dataDose;

	@Column(name="dat_val_vac_est")
	private Timestamp dataValidade;

	@Column(name="exa_sor_con_vac_est")
	private boolean exameSoroConvercao;

	@Column(name="obs_vac_est")
	private String observacao;

	@Column(name="res_exa_sor_con_vac_est")
	private String resultadoSoroConvercao;

	//bi-directional many-to-one association to Estudante
	@ManyToOne
	@JoinColumn(name="cod_est")
	private Estudante estudante;

	//bi-directional many-to-one association to Vacina
	@ManyToOne
	@JoinColumn(name="cod_vac")
	private Vacina vacina;

	public VacinaEstudante() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Timestamp getDataDose() {
		return this.dataDose;
	}

	public void setDataDose(Timestamp dataDose) {
		this.dataDose = dataDose;
	}

	public Timestamp getDataValidade() {
		return this.dataValidade;
	}

	public void setDataValidade(Timestamp dataValidade) {
		this.dataValidade = dataValidade;
	}

	public boolean getExameSoroConvercao() {
		return this.exameSoroConvercao;
	}

	public void setExameSoroConvercao(boolean exameSoroConvercao) {
		this.exameSoroConvercao = exameSoroConvercao;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getResultadoSoroConvercao() {
		return this.resultadoSoroConvercao;
	}

	public void setResultadoSoroConvercao(String resultadoSoroConvercao) {
		this.resultadoSoroConvercao = resultadoSoroConvercao;
	}

	public Estudante getEstudante() {
		return this.estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Vacina getVacina() {
		return this.vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

}