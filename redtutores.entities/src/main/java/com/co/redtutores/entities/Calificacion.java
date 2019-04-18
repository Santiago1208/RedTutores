package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the calificaciones database table.
 * 
 */
@Entity
@Table(name="calificaciones")
@NamedQuery(name="Calificacion.findAll", query="SELECT c FROM Calificacion c")
public class Calificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalificacionPK id;

	@Column(name="valor_calif")
	private BigDecimal valorCalif;

	//bi-directional many-to-one association to TipoCalificacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_calif")
	private TipoCalificacion tipoCalificacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Calificacion() {
	}

	public CalificacionPK getId() {
		return this.id;
	}

	public void setId(CalificacionPK id) {
		this.id = id;
	}

	public BigDecimal getValorCalif() {
		return this.valorCalif;
	}

	public void setValorCalif(BigDecimal valorCalif) {
		this.valorCalif = valorCalif;
	}

	public TipoCalificacion getTipoCalificacion() {
		return this.tipoCalificacion;
	}

	public void setTipoCalificacion(TipoCalificacion tipoCalificacion) {
		this.tipoCalificacion = tipoCalificacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}