package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the universidad database table.
 * 
 */
@Entity
@NamedQuery(name="Universidad.findAll", query="SELECT u FROM Universidad u")
public class Universidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UNIVERSIDAD_IDUNIVERSIDAD_GENERATOR", sequenceName="SEQ_UNIVERSIDAD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIVERSIDAD_IDUNIVERSIDAD_GENERATOR")
	@Column(name="id_universidad")
	private long idUniversidad;

	@Column(name="nombre_universidad")
	private String nombreUniversidad;

	//bi-directional many-to-one association to Pais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pais")
	private Pais pais;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="universidad")
	private List<Usuario> usuarios;

	public Universidad() {
	}

	public long getIdUniversidad() {
		return this.idUniversidad;
	}

	public void setIdUniversidad(long idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getNombreUniversidad() {
		return this.nombreUniversidad;
	}

	public void setNombreUniversidad(String nombreUniversidad) {
		this.nombreUniversidad = nombreUniversidad;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setUniversidad(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setUniversidad(null);

		return usuario;
	}

}