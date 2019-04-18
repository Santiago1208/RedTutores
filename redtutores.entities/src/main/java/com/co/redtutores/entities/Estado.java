package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name="estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADOS_IDESTADO_GENERATOR", sequenceName="SEQ_ESTADOS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOS_IDESTADO_GENERATOR")
	@Column(name="id_estado")
	private long idEstado;

	@Column(name="nombre_estado")
	private String nombreEstado;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="estado")
	private List<Ciudad> ciudades;

	//bi-directional many-to-one association to Pais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pais")
	private Pais pais;

	public Estado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Ciudad addCiudade(Ciudad ciudade) {
		getCiudades().add(ciudade);
		ciudade.setEstado(this);

		return ciudade;
	}

	public Ciudad removeCiudade(Ciudad ciudade) {
		getCiudades().remove(ciudade);
		ciudade.setEstado(null);

		return ciudade;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}