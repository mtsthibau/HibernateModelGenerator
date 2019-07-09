package com.feluma.naa.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the atendimento database table.
 * 
 */
@Entity
@Table(name="atendimento")
@NamedQuery(name="Atendimento.findAll", query="SELECT a FROM Atendimento a")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_ate")
	private Long codigo;

	@Column(name="con_ate")
	private Object conduta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dat_ate")
	private Date dataAtendimento;

	@Column(name="que_pri_ate")
	private Object queixaPrincipal;

	//bi-directional many-to-one association to Estudante
	@ManyToOne
	@JoinColumn(name="cod_est")
	private Estudante estudante;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cod_usu")
	private Usuario usuario;

	public Atendimento() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Object getConduta() {
		return this.conduta;
	}

	public void setConduta(Object conduta) {
		this.conduta = conduta;
	}

	public Date getDataAtendimento() {
		return this.dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Object getQueixaPrincipal() {
		return this.queixaPrincipal;
	}

	public void setQueixaPrincipal(Object queixaPrincipal) {
		this.queixaPrincipal = queixaPrincipal;
	}

	public Estudante getEstudante() {
		return this.estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}