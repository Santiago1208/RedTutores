package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the parametros_sis database table.
 * 
 */
@Embeddable
public class ParametrosSisPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_param")
	private long idParam;

	@Column(name="nombre_param")
	private String nombreParam;

	public ParametrosSisPK() {
	}
	public long getIdParam() {
		return this.idParam;
	}
	public void setIdParam(long idParam) {
		this.idParam = idParam;
	}
	public String getNombreParam() {
		return this.nombreParam;
	}
	public void setNombreParam(String nombreParam) {
		this.nombreParam = nombreParam;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ParametrosSisPK)) {
			return false;
		}
		ParametrosSisPK castOther = (ParametrosSisPK)other;
		return 
			(this.idParam == castOther.idParam)
			&& this.nombreParam.equals(castOther.nombreParam);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idParam ^ (this.idParam >>> 32)));
		hash = hash * prime + this.nombreParam.hashCode();
		
		return hash;
	}
}