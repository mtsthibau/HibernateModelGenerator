package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_per")
	private Long codigo;

	@Column(name="des_per")
	private String descricao;

	@Column(name="nom_per")
	private String nome;

	//bi-directional many-to-one association to UsuarioPerfil
	@OneToMany(mappedBy="perfil")
	private List<UsuarioPerfil> usuarioPerfis;

	public Perfil() {
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<UsuarioPerfil> getUsuarioPerfis() {
		return this.usuarioPerfis;
	}

	public void setUsuarioPerfis(List<UsuarioPerfil> usuarioPerfis) {
		this.usuarioPerfis = usuarioPerfis;
	}

	public UsuarioPerfil addUsuarioPerfi(UsuarioPerfil usuarioPerfi) {
		getUsuarioPerfis().add(usuarioPerfi);
		usuarioPerfi.setPerfil(this);

		return usuarioPerfi;
	}

	public UsuarioPerfil removeUsuarioPerfi(UsuarioPerfil usuarioPerfi) {
		getUsuarioPerfis().remove(usuarioPerfi);
		usuarioPerfi.setPerfil(null);

		return usuarioPerfi;
	}

}