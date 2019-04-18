package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contenidos_extra database table.
 * 
 */
@Entity
@Table(name="contenidos_extra")
@NamedQuery(name="ContenidosExtra.findAll", query="SELECT c FROM ContenidosExtra c")
public class ContenidosExtra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTENIDOS_EXTRA_IDCONTENIDO_GENERATOR", sequenceName="SEQ_CONTENIDOS_EXTRA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTENIDOS_EXTRA_IDCONTENIDO_GENERATOR")
	@Column(name="id_contenido")
	private long idContenido;

	@Column(name="archivo_contenido")
	private byte[] archivoContenido;

	@Column(name="titulo_contenido")
	private String tituloContenido;

	//bi-directional many-to-many association to Tema
	@ManyToMany(mappedBy="contenidosExtras")
	private List<Tema> temas;

	public ContenidosExtra() {
	}

	public long getIdContenido() {
		return this.idContenido;
	}

	public void setIdContenido(long idContenido) {
		this.idContenido = idContenido;
	}

	public byte[] getArchivoContenido() {
		return this.archivoContenido;
	}

	public void setArchivoContenido(byte[] archivoContenido) {
		this.archivoContenido = archivoContenido;
	}

	public String getTituloContenido() {
		return this.tituloContenido;
	}

	public void setTituloContenido(String tituloContenido) {
		this.tituloContenido = tituloContenido;
	}

	public List<Tema> getTemas() {
		return this.temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

}