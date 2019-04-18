package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the temas database table.
 * 
 */
@Entity
@Table(name="temas")
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEMAS_IDTEMA_GENERATOR", sequenceName="SEQ_TEMAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEMAS_IDTEMA_GENERATOR")
	@Column(name="id_tema")
	private long idTema;

	@Column(name="nombre_tema")
	private String nombreTema;

	//bi-directional many-to-many association to ContenidosExtra
	@ManyToMany
	@JoinTable(
		name="extras_tema"
		, joinColumns={
			@JoinColumn(name="id_tema")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_contenido")
			}
		)
	private List<ContenidosExtra> contenidosExtras;

	//bi-directional many-to-many association to Materia
	@ManyToMany
	@JoinTable(
		name="temas_materia"
		, joinColumns={
			@JoinColumn(name="id_tema")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_materia")
			}
		)
	private List<Materia> materias;

	public Tema() {
	}

	public long getIdTema() {
		return this.idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getNombreTema() {
		return this.nombreTema;
	}

	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	public List<ContenidosExtra> getContenidosExtras() {
		return this.contenidosExtras;
	}

	public void setContenidosExtras(List<ContenidosExtra> contenidosExtras) {
		this.contenidosExtras = contenidosExtras;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

}