package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the calificaciones database table.
 * 
 */
@Embeddable
public class CalificacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_calif")
	private long idCalif;

	@Column(name="id_usuario", insertable=false, updatable=false)
	private String idUsuario;

	public CalificacionPK() {
	}
	public long getIdCalif() {
		return this.idCalif;
	}
	public void setIdCalif(long idCalif) {
		this.idCalif = idCalif;
	}
	public String getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CalificacionPK)) {
			return false;
		}
		CalificacionPK castOther = (CalificacionPK)other;
		return 
			(this.idCalif == castOther.idCalif)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idCalif ^ (this.idCalif >>> 32)));
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}