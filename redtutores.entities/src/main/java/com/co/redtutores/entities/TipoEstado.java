package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_estado database table.
 * 
 */
@Entity
@Table(name="tipo_estado")
@NamedQuery(name="TipoEstado.findAll", query="SELECT t FROM TipoEstado t")
public class TipoEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_ESTADO_IDTIPOESTADO_GENERATOR", sequenceName="SEQ_TIPO_ESTADO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_ESTADO_IDTIPOESTADO_GENERATOR")
	@Column(name="id_tipo_estado")
	private long idTipoEstado;

	@Column(name="nombre_tipo_estado")
	private String nombreTipoEstado;

	public TipoEstado() {
	}

	public long getIdTipoEstado() {
		return this.idTipoEstado;
	}

	public void setIdTipoEstado(long idTipoEstado) {
		this.idTipoEstado = idTipoEstado;
	}

	public String getNombreTipoEstado() {
		return this.nombreTipoEstado;
	}

	public void setNombreTipoEstado(String nombreTipoEstado) {
		this.nombreTipoEstado = nombreTipoEstado;
	}

}