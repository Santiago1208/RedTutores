package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ciudades database table.
 * 
 */
@Entity
@Table(name="ciudades")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CIUDADES_IDCIUDAD_GENERATOR", sequenceName="SEQ_CIUDADES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CIUDADES_IDCIUDAD_GENERATOR")
	@Column(name="id_ciudad")
	private long idCiudad;

	@Column(name="nombre_ciudad")
	private String nombreCiudad;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estado")
	private Estado estado;

	public Ciudad() {
	}

	public long getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}