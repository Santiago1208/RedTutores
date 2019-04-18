package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materias database table.
 * 
 */
@Entity
@Table(name="materias")
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MATERIAS_IDMATERIA_GENERATOR", sequenceName="SEQ_MATERIAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATERIAS_IDMATERIA_GENERATOR")
	@Column(name="id_materia")
	private long idMateria;

	@Column(name="nombre_materia")
	private String nombreMateria;

	//bi-directional many-to-one association to Area
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_area")
	private Area area;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="materias")
	private List<Usuario> usuarios;

	//bi-directional many-to-many association to Tema
	@ManyToMany(mappedBy="materias")
	private List<Tema> temas;

	//bi-directional many-to-one association to Tutoria
	@OneToMany(mappedBy="materia")
	private List<Tutoria> tutorias;

	public Materia() {
	}

	public long getIdMateria() {
		return this.idMateria;
	}

	public void setIdMateria(long idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombreMateria() {
		return this.nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Tema> getTemas() {
		return this.temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public List<Tutoria> getTutorias() {
		return this.tutorias;
	}

	public void setTutorias(List<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}

	public Tutoria addTutoria(Tutoria tutoria) {
		getTutorias().add(tutoria);
		tutoria.setMateria(this);

		return tutoria;
	}

	public Tutoria removeTutoria(Tutoria tutoria) {
		getTutorias().remove(tutoria);
		tutoria.setMateria(null);

		return tutoria;
	}

}