package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tipo_calificacion database table.
 * 
 */
@Entity
@Table(name="tipo_calificacion")
@NamedQuery(name="TipoCalificacion.findAll", query="SELECT t FROM TipoCalificacion t")
public class TipoCalificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_CALIFICACION_IDTIPOCALIF_GENERATOR", sequenceName="SEQ_TIPO_CALIFICACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_CALIFICACION_IDTIPOCALIF_GENERATOR")
	@Column(name="id_tipo_calif")
	private long idTipoCalif;

	@Column(name="nombre_tipo_calif")
	private String nombreTipoCalif;

	private BigDecimal ponderacion;

	//bi-directional many-to-one association to Calificacion
	@OneToMany(mappedBy="tipoCalificacion")
	private List<Calificacion> calificaciones;

	public TipoCalificacion() {
	}

	public long getIdTipoCalif() {
		return this.idTipoCalif;
	}

	public void setIdTipoCalif(long idTipoCalif) {
		this.idTipoCalif = idTipoCalif;
	}

	public String getNombreTipoCalif() {
		return this.nombreTipoCalif;
	}

	public void setNombreTipoCalif(String nombreTipoCalif) {
		this.nombreTipoCalif = nombreTipoCalif;
	}

	public BigDecimal getPonderacion() {
		return this.ponderacion;
	}

	public void setPonderacion(BigDecimal ponderacion) {
		this.ponderacion = ponderacion;
	}

	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calificacion addCalificacione(Calificacion calificacione) {
		getCalificaciones().add(calificacione);
		calificacione.setTipoCalificacion(this);

		return calificacione;
	}

	public Calificacion removeCalificacione(Calificacion calificacione) {
		getCalificaciones().remove(calificacione);
		calificacione.setTipoCalificacion(null);

		return calificacione;
	}

}