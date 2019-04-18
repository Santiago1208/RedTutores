package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the descuentos database table.
 * 
 */
@Entity
@Table(name="descuentos")
@NamedQuery(name="Descuento.findAll", query="SELECT d FROM Descuento d")
public class Descuento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DESCUENTOS_IDDESCUENTO_GENERATOR", sequenceName="SEQ_DESCUENTOS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DESCUENTOS_IDDESCUENTO_GENERATOR")
	@Column(name="id_descuento")
	private long idDescuento;

	@Column(name="descripcion_desc")
	private String descripcionDesc;

	@Column(name="id_estado")
	private BigDecimal idEstado;

	@Column(name="nombre_descuento")
	private String nombreDescuento;

	@Column(name="porcentaje_desc")
	private BigDecimal porcentajeDesc;

	//bi-directional many-to-one association to Tutoria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tutoria")
	private Tutoria tutoria;

	//bi-directional many-to-one association to Tutoria
	@OneToMany(mappedBy="descuento")
	private List<Tutoria> tutorias;

	public Descuento() {
	}

	public long getIdDescuento() {
		return this.idDescuento;
	}

	public void setIdDescuento(long idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getDescripcionDesc() {
		return this.descripcionDesc;
	}

	public void setDescripcionDesc(String descripcionDesc) {
		this.descripcionDesc = descripcionDesc;
	}

	public BigDecimal getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(BigDecimal idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreDescuento() {
		return this.nombreDescuento;
	}

	public void setNombreDescuento(String nombreDescuento) {
		this.nombreDescuento = nombreDescuento;
	}

	public BigDecimal getPorcentajeDesc() {
		return this.porcentajeDesc;
	}

	public void setPorcentajeDesc(BigDecimal porcentajeDesc) {
		this.porcentajeDesc = porcentajeDesc;
	}

	public Tutoria getTutoria() {
		return this.tutoria;
	}

	public void setTutoria(Tutoria tutoria) {
		this.tutoria = tutoria;
	}

	public List<Tutoria> getTutorias() {
		return this.tutorias;
	}

	public void setTutorias(List<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}

	public Tutoria addTutoria(Tutoria tutoria) {
		getTutorias().add(tutoria);
		tutoria.setDescuento(this);

		return tutoria;
	}

	public Tutoria removeTutoria(Tutoria tutoria) {
		getTutorias().remove(tutoria);
		tutoria.setDescuento(null);

		return tutoria;
	}

}