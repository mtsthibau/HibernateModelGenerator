package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_perfil database table.
 * 
 */
@Entity
@Table(name="usuario_perfil")
@NamedQuery(name="UsuarioPerfil.findAll", query="SELECT u FROM UsuarioPerfil u")
public class UsuarioPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPerfilPK id;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="cod_per")
	private Perfil perfil;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cod_usu")
	private Usuario usuario;

	public UsuarioPerfil() {
	}

	public UsuarioPerfilPK getId() {
		return this.id;
	}

	public void setId(UsuarioPerfilPK id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}