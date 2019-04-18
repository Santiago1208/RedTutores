package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the disponibilidades database table.
 * 
 */
@Embeddable
public class DisponibilidadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_disp")
	private long idDisp;

	@Column(name="id_usuario", insertable=false, updatable=false)
	private String idUsuario;

	public DisponibilidadPK() {
	}
	public long getIdDisp() {
		return this.idDisp;
	}
	public void setIdDisp(long idDisp) {
		this.idDisp = idDisp;
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
		if (!(other instanceof DisponibilidadPK)) {
			return false;
		}
		DisponibilidadPK castOther = (DisponibilidadPK)other;
		return 
			(this.idDisp == castOther.idDisp)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idDisp ^ (this.idDisp >>> 32)));
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}