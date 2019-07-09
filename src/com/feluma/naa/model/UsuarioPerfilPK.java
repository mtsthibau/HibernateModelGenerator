package com.feluma.naa.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuario_perfil database table.
 * 
 */
@Embeddable
public class UsuarioPerfilPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_usu_per")
	private int codigo;

	@Column(name="cod_per", insertable=false, updatable=false)
	private int codPer;

	public UsuarioPerfilPK() {
	}
	public int getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodPer() {
		return this.codPer;
	}
	public void setCodPer(int codPer) {
		this.codPer = codPer;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPerfilPK)) {
			return false;
		}
		UsuarioPerfilPK castOther = (UsuarioPerfilPK)other;
		return 
			(this.codigo == castOther.codigo)
			&& (this.codPer == castOther.codPer);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codigo;
		hash = hash * prime + this.codPer;
		
		return hash;
	}
}