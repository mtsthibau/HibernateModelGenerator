package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
@Table(name="questao")
@NamedQuery(name="Questao.findAll", query="SELECT q FROM Questao q")
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_que")
	private Long codigo;

	private String descricao;

	@Column(name="flg_txt_que")
	private boolean flagTexto;

	@Column(name="flg_vis_sn_que")
	private boolean flagAlternativa;

	//bi-directional many-to-one association to EstudanteInformacao
	@OneToMany(mappedBy="questao")
	private List<EstudanteInformacao> estudanteInformacoes;

	public Questao() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getFlagTexto() {
		return this.flagTexto;
	}

	public void setFlagTexto(boolean flagTexto) {
		this.flagTexto = flagTexto;
	}

	public boolean getFlagAlternativa() {
		return this.flagAlternativa;
	}

	public void setFlagAlternativa(boolean flagAlternativa) {
		this.flagAlternativa = flagAlternativa;
	}

	public List<EstudanteInformacao> getEstudanteInformacoes() {
		return this.estudanteInformacoes;
	}

	public void setEstudanteInformacoes(List<EstudanteInformacao> estudanteInformacoes) {
		this.estudanteInformacoes = estudanteInformacoes;
	}

	public EstudanteInformacao addEstudanteInformacoe(EstudanteInformacao estudanteInformacoe) {
		getEstudanteInformacoes().add(estudanteInformacoe);
		estudanteInformacoe.setQuestao(this);

		return estudanteInformacoe;
	}

	public EstudanteInformacao removeEstudanteInformacoe(EstudanteInformacao estudanteInformacoe) {
		getEstudanteInformacoes().remove(estudanteInformacoe);
		estudanteInformacoe.setQuestao(null);

		return estudanteInformacoe;
	}

}