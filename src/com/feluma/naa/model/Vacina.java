package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the vacina database table.
 * 
 */
@Entity
@Table(name="vacina")
@NamedQuery(name="Vacina.findAll", query="SELECT v FROM Vacina v")
public class Vacina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_vac")
	private Long codigo;

	@Column(name="car_vac")
	private Timestamp carencia;

	@Column(name="des_vac")
	private String descricao;

	@Column(name="nom_vac")
	private String nome;

	//bi-directional many-to-one association to VacinaEstudante
	@OneToMany(mappedBy="vacina")
	private List<VacinaEstudante> vacinaEstudantes;

	public Vacina() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Timestamp getCarencia() {
		return this.carencia;
	}

	public void setCarencia(Timestamp carencia) {
		this.carencia = carencia;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VacinaEstudante> getVacinaEstudantes() {
		return this.vacinaEstudantes;
	}

	public void setVacinaEstudantes(List<VacinaEstudante> vacinaEstudantes) {
		this.vacinaEstudantes = vacinaEstudantes;
	}

	public VacinaEstudante addVacinaEstudante(VacinaEstudante vacinaEstudante) {
		getVacinaEstudantes().add(vacinaEstudante);
		vacinaEstudante.setVacina(this);

		return vacinaEstudante;
	}

	public VacinaEstudante removeVacinaEstudante(VacinaEstudante vacinaEstudante) {
		getVacinaEstudantes().remove(vacinaEstudante);
		vacinaEstudante.setVacina(null);

		return vacinaEstudante;
	}

}