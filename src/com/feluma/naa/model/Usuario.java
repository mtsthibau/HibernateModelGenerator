package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usu")
	private Long codigo;

	@Column(name="ema_usu")
	private String emaiç;

	@Column(name="nom_usu")
	private String nome;

	@Column(name="sen_usu")
	private String senha;

	@Column(name="sta_usu")
	private String status;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="usuario")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to UsuarioPerfil
	@OneToMany(mappedBy="usuario")
	private List<UsuarioPerfil> usuarioPerfis;

	public Usuario() {
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getEmaiç() {
		return this.emaiç;
	}

	public void setEmaiç(String emaiç) {
		this.emaiç = emaiç;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setUsuario(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setUsuario(null);

		return atendimento;
	}

	public List<UsuarioPerfil> getUsuarioPerfis() {
		return this.usuarioPerfis;
	}

	public void setUsuarioPerfis(List<UsuarioPerfil> usuarioPerfis) {
		this.usuarioPerfis = usuarioPerfis;
	}

	public UsuarioPerfil addUsuarioPerfi(UsuarioPerfil usuarioPerfi) {
		getUsuarioPerfis().add(usuarioPerfi);
		usuarioPerfi.setUsuario(this);

		return usuarioPerfi;
	}

	public UsuarioPerfil removeUsuarioPerfi(UsuarioPerfil usuarioPerfi) {
		getUsuarioPerfis().remove(usuarioPerfi);
		usuarioPerfi.setUsuario(null);

		return usuarioPerfi;
	}

}