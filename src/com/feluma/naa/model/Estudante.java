package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estudante database table.
 * 
 */
@Entity
@Table(name="estudante")
@NamedQuery(name="Estudante.findAll", query="SELECT e FROM Estudante e")
public class Estudante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_est")
	private Long codigo;

	@Column(name="mae_est")
	private String mae;

	@Column(name="mat_est")
	private String matricula;

	@Column(name="nom_est")
	private String nome;

	@Column(name="num_pla_sau_est")
	private String numeroPlanoSaude;

	@Column(name="pai_est")
	private String pai;

	@Column(name="pla_sau_est")
	private String planoSaude;

	@Column(name="tel_mae_est")
	private String telefoneMae;

	@Column(name="tel_pai_est")
	private String telefonePai;

	@Column(name="tel_pla_sau_est")
	private String telefonePlanoSaude;

	@Column(name="tip_san_est")
	private String tipoSanguineo;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="estudante")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="cod_cur")
	private Curso curso;

	//bi-directional many-to-one association to EstudanteContato
	@OneToMany(mappedBy="estudante")
	private List<EstudanteContato> estudanteContatos;

	//bi-directional many-to-one association to EstudanteInformacao
	@OneToMany(mappedBy="estudante")
	private List<EstudanteInformacao> estudanteInformacoes;

	//bi-directional many-to-one association to VacinaEstudante
	@OneToMany(mappedBy="estudante")
	private List<VacinaEstudante> vacinaEstudantes;

	public Estudante() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMae() {
		return this.mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroPlanoSaude() {
		return this.numeroPlanoSaude;
	}

	public void setNumeroPlanoSaude(String numeroPlanoSaude) {
		this.numeroPlanoSaude = numeroPlanoSaude;
	}

	public String getPai() {
		return this.pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getPlanoSaude() {
		return this.planoSaude;
	}

	public void setPlanoSaude(String planoSaude) {
		this.planoSaude = planoSaude;
	}

	public String getTelefoneMae() {
		return this.telefoneMae;
	}

	public void setTelefoneMae(String telefoneMae) {
		this.telefoneMae = telefoneMae;
	}

	public String getTelefonePai() {
		return this.telefonePai;
	}

	public void setTelefonePai(String telefonePai) {
		this.telefonePai = telefonePai;
	}

	public String getTelefonePlanoSaude() {
		return this.telefonePlanoSaude;
	}

	public void setTelefonePlanoSaude(String telefonePlanoSaude) {
		this.telefonePlanoSaude = telefonePlanoSaude;
	}

	public String getTipoSanguineo() {
		return this.tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setEstudante(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setEstudante(null);

		return atendimento;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<EstudanteContato> getEstudanteContatos() {
		return this.estudanteContatos;
	}

	public void setEstudanteContatos(List<EstudanteContato> estudanteContatos) {
		this.estudanteContatos = estudanteContatos;
	}

	public EstudanteContato addEstudanteContato(EstudanteContato estudanteContato) {
		getEstudanteContatos().add(estudanteContato);
		estudanteContato.setEstudante(this);

		return estudanteContato;
	}

	public EstudanteContato removeEstudanteContato(EstudanteContato estudanteContato) {
		getEstudanteContatos().remove(estudanteContato);
		estudanteContato.setEstudante(null);

		return estudanteContato;
	}

	public List<EstudanteInformacao> getEstudanteInformacoes() {
		return this.estudanteInformacoes;
	}

	public void setEstudanteInformacoes(List<EstudanteInformacao> estudanteInformacoes) {
		this.estudanteInformacoes = estudanteInformacoes;
	}

	public EstudanteInformacao addEstudanteInformacoe(EstudanteInformacao estudanteInformacoe) {
		getEstudanteInformacoes().add(estudanteInformacoe);
		estudanteInformacoe.setEstudante(this);

		return estudanteInformacoe;
	}

	public EstudanteInformacao removeEstudanteInformacoe(EstudanteInformacao estudanteInformacoe) {
		getEstudanteInformacoes().remove(estudanteInformacoe);
		estudanteInformacoe.setEstudante(null);

		return estudanteInformacoe;
	}

	public List<VacinaEstudante> getVacinaEstudantes() {
		return this.vacinaEstudantes;
	}

	public void setVacinaEstudantes(List<VacinaEstudante> vacinaEstudantes) {
		this.vacinaEstudantes = vacinaEstudantes;
	}

	public VacinaEstudante addVacinaEstudante(VacinaEstudante vacinaEstudante) {
		getVacinaEstudantes().add(vacinaEstudante);
		vacinaEstudante.setEstudante(this);

		return vacinaEstudante;
	}

	public VacinaEstudante removeVacinaEstudante(VacinaEstudante vacinaEstudante) {
		getVacinaEstudantes().remove(vacinaEstudante);
		vacinaEstudante.setEstudante(null);

		return vacinaEstudante;
	}

}