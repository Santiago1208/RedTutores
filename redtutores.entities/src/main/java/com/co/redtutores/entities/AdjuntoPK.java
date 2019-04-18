package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the adjuntos database table.
 * 
 */
@Embeddable
public class AdjuntoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_archivo")
	private long idArchivo;

	@Column(name="id_usuario", insertable=false, updatable=false)
	private String idUsuario;

	public AdjuntoPK() {
	}
	public long getIdArchivo() {
		return this.idArchivo;
	}
	public void setIdArchivo(long idArchivo) {
		this.idArchivo = idArchivo;
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
		if (!(other instanceof AdjuntoPK)) {
			return false;
		}
		AdjuntoPK castOther = (AdjuntoPK)other;
		return 
			(this.idArchivo == castOther.idArchivo)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idArchivo ^ (this.idArchivo >>> 32)));
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}