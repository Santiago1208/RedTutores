package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private String idUsuario;

	private String apellidos;

	private String carrera;

	@Column(name="corte_registro")
	private String corteRegistro;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="hace_simultaneidad")
	private String haceSimultaneidad;

	@Column(name="id_estado")
	private java.math.BigDecimal idEstado;

	private String nombre;

	//bi-directional many-to-one association to Adjunto
	@OneToMany(mappedBy="usuario")
	private List<Adjunto> adjuntos;

	//bi-directional many-to-one association to Calificacion
	@OneToMany(mappedBy="usuario")
	private List<Calificacion> calificaciones;

	//bi-directional many-to-one association to Disponibilidad
	@OneToMany(mappedBy="usuario")
	private List<Disponibilidad> disponibilidades;

	//bi-directional many-to-many association to Materia
	@ManyToMany
	@JoinTable(
		name="materias_tutor"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_materia")
			}
		)
	private List<Materia> materias;

	//bi-directional many-to-one association to RolUsuario
	@OneToMany(mappedBy="usuario")
	private List<RolUsuario> rolUsuarios;

	//bi-directional many-to-one association to Tutoria
	@OneToMany(mappedBy="estudiante")
	private List<Tutoria> tutoriasAsistidas;

	//bi-directional many-to-one association to Tutoria
	@OneToMany(mappedBy="tutor")
	private List<Tutoria> tutoriasDictadas;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nombre_usuario")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Pais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pais")
	private Pais pais;

	//bi-directional many-to-one association to TipoIdentificacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_identificacion")
	private TipoIdentificacion tipoIdentificacion;

	//bi-directional many-to-one association to Universidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_universidad")
	private Universidad universidad;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCorteRegistro() {
		return this.corteRegistro;
	}

	public void setCorteRegistro(String corteRegistro) {
		this.corteRegistro = corteRegistro;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getHaceSimultaneidad() {
		return this.haceSimultaneidad;
	}

	public void setHaceSimultaneidad(String haceSimultaneidad) {
		this.haceSimultaneidad = haceSimultaneidad;
	}

	public java.math.BigDecimal getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(java.math.BigDecimal idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Adjunto> getAdjuntos() {
		return this.adjuntos;
	}

	public void setAdjuntos(List<Adjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}

	public Adjunto addAdjunto(Adjunto adjunto) {
		getAdjuntos().add(adjunto);
		adjunto.setUsuario(this);

		return adjunto;
	}

	public Adjunto removeAdjunto(Adjunto adjunto) {
		getAdjuntos().remove(adjunto);
		adjunto.setUsuario(null);

		return adjunto;
	}

	public List<Calificacion> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calificacion addCalificacione(Calificacion calificacione) {
		getCalificaciones().add(calificacione);
		calificacione.setUsuario(this);

		return calificacione;
	}

	public Calificacion removeCalificacione(Calificacion calificacione) {
		getCalificaciones().remove(calificacione);
		calificacione.setUsuario(null);

		return calificacione;
	}

	public List<Disponibilidad> getDisponibilidades() {
		return this.disponibilidades;
	}

	public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

	public Disponibilidad addDisponibilidade(Disponibilidad disponibilidade) {
		getDisponibilidades().add(disponibilidade);
		disponibilidade.setUsuario(this);

		return disponibilidade;
	}

	public Disponibilidad removeDisponibilidade(Disponibilidad disponibilidade) {
		getDisponibilidades().remove(disponibilidade);
		disponibilidade.setUsuario(null);

		return disponibilidade;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<RolUsuario> getRolUsuarios() {
		return this.rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	public RolUsuario addRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().add(rolUsuario);
		rolUsuario.setUsuario(this);

		return rolUsuario;
	}

	public RolUsuario removeRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().remove(rolUsuario);
		rolUsuario.setUsuario(null);

		return rolUsuario;
	}

	public List<Tutoria> getTutoriasAsistidas() {
		return this.tutoriasAsistidas;
	}

	public void setTutoriasAsistidas(List<Tutoria> tutoriasAsistidas) {
		this.tutoriasAsistidas = tutoriasAsistidas;
	}

	public Tutoria addTutoriasAsistida(Tutoria tutoriasAsistida) {
		getTutoriasAsistidas().add(tutoriasAsistida);
		tutoriasAsistida.setEstudiante(this);

		return tutoriasAsistida;
	}

	public Tutoria removeTutoriasAsistida(Tutoria tutoriasAsistida) {
		getTutoriasAsistidas().remove(tutoriasAsistida);
		tutoriasAsistida.setEstudiante(null);

		return tutoriasAsistida;
	}

	public List<Tutoria> getTutoriasDictadas() {
		return this.tutoriasDictadas;
	}

	public void setTutoriasDictadas(List<Tutoria> tutoriasDictadas) {
		this.tutoriasDictadas = tutoriasDictadas;
	}

	public Tutoria addTutoriasDictada(Tutoria tutoriasDictada) {
		getTutoriasDictadas().add(tutoriasDictada);
		tutoriasDictada.setTutor(this);

		return tutoriasDictada;
	}

	public Tutoria removeTutoriasDictada(Tutoria tutoriasDictada) {
		getTutoriasDictadas().remove(tutoriasDictada);
		tutoriasDictada.setTutor(null);

		return tutoriasDictada;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Universidad getUniversidad() {
		return this.universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

}