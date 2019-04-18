package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tutorias database table.
 * 
 */
@Entity
@Table(name="tutorias")
@NamedQuery(name="Tutoria.findAll", query="SELECT t FROM Tutoria t")
public class Tutoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TUTORIAS_IDTUTORIA_GENERATOR", sequenceName="SEQ_TUTORIAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TUTORIAS_IDTUTORIA_GENERATOR")
	@Column(name="id_tutoria")
	private long idTutoria;

	@Column(name="costo_tutoria")
	private BigDecimal costoTutoria;

	@Column(name="es_domiciliaria")
	private String esDomiciliaria;

	@Column(name="es_grupal")
	private String esGrupal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_realizacion")
	private Date fechaRealizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;

	@Column(name="id_estado")
	private BigDecimal idEstado;

	@Column(name="numero_participantes")
	private BigDecimal numeroParticipantes;

	@Column(name="puntaje_tutoria")
	private BigDecimal puntajeTutoria;

	//bi-directional many-to-one association to Descuento
	@OneToMany(mappedBy="tutoria")
	private List<Descuento> descuentos;

	//bi-directional many-to-one association to Descuento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_descuento")
	private Descuento descuento;

	//bi-directional many-to-one association to Materia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_materia")
	private Materia materia;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estudiante")
	private Usuario estudiante;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tutor")
	private Usuario tutor;

	public Tutoria() {
	}

	public long getIdTutoria() {
		return this.idTutoria;
	}

	public void setIdTutoria(long idTutoria) {
		this.idTutoria = idTutoria;
	}

	public BigDecimal getCostoTutoria() {
		return this.costoTutoria;
	}

	public void setCostoTutoria(BigDecimal costoTutoria) {
		this.costoTutoria = costoTutoria;
	}

	public String getEsDomiciliaria() {
		return this.esDomiciliaria;
	}

	public void setEsDomiciliaria(String esDomiciliaria) {
		this.esDomiciliaria = esDomiciliaria;
	}

	public String getEsGrupal() {
		return this.esGrupal;
	}

	public void setEsGrupal(String esGrupal) {
		this.esGrupal = esGrupal;
	}

	public Date getFechaRealizacion() {
		return this.fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public BigDecimal getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(BigDecimal idEstado) {
		this.idEstado = idEstado;
	}

	public BigDecimal getNumeroParticipantes() {
		return this.numeroParticipantes;
	}

	public void setNumeroParticipantes(BigDecimal numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

	public BigDecimal getPuntajeTutoria() {
		return this.puntajeTutoria;
	}

	public void setPuntajeTutoria(BigDecimal puntajeTutoria) {
		this.puntajeTutoria = puntajeTutoria;
	}

	public List<Descuento> getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	public Descuento addDescuento(Descuento descuento) {
		getDescuentos().add(descuento);
		descuento.setTutoria(this);

		return descuento;
	}

	public Descuento removeDescuento(Descuento descuento) {
		getDescuentos().remove(descuento);
		descuento.setTutoria(null);

		return descuento;
	}

	public Descuento getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Usuario getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Usuario estudiante) {
		this.estudiante = estudiante;
	}

	public Usuario getTutor() {
		return this.tutor;
	}

	public void setTutor(Usuario tutor) {
		this.tutor = tutor;
	}

}