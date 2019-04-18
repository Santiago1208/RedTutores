package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paises database table.
 * 
 */
@Entity
@Table(name="paises")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAISES_IDPAIS_GENERATOR", sequenceName="SEQ_PAISES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAISES_IDPAIS_GENERATOR")
	@Column(name="id_pais")
	private long idPais;

	private String nombre;

	//bi-directional many-to-one association to Estado
	@OneToMany(mappedBy="pais")
	private List<Estado> estados;

	//bi-directional many-to-one association to Universidad
	@OneToMany(mappedBy="pais")
	private List<Universidad> universidades;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="pais")
	private List<Usuario> usuarios;

	public Pais() {
	}

	public long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado addEstado(Estado estado) {
		getEstados().add(estado);
		estado.setPais(this);

		return estado;
	}

	public Estado removeEstado(Estado estado) {
		getEstados().remove(estado);
		estado.setPais(null);

		return estado;
	}

	public List<Universidad> getUniversidades() {
		return this.universidades;
	}

	public void setUniversidades(List<Universidad> universidades) {
		this.universidades = universidades;
	}

	public Universidad addUniversidade(Universidad universidade) {
		getUniversidades().add(universidade);
		universidade.setPais(this);

		return universidade;
	}

	public Universidad removeUniversidade(Universidad universidade) {
		getUniversidades().remove(universidade);
		universidade.setPais(null);

		return universidade;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPais(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPais(null);

		return usuario;
	}

}