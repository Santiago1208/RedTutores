package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the areas database table.
 * 
 */
@Entity
@Table(name="areas")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREAS_IDAREA_GENERATOR", sequenceName="SEQ_AREAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREAS_IDAREA_GENERATOR")
	@Column(name="id_area")
	private long idArea;

	@Column(name="nombre_area")
	private String nombreArea;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="area")
	private List<Materia> materias;

	public Area() {
	}

	public long getIdArea() {
		return this.idArea;
	}

	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return this.nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setArea(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setArea(null);

		return materia;
	}

}