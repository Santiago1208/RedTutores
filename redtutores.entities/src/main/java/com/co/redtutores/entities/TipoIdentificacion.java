package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="tipo_identificacion")
@NamedQuery(name="TipoIdentificacion.findAll", query="SELECT t FROM TipoIdentificacion t")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_IDENTIFICACION_IDTIPOIDENTIFICACION_GENERATOR", sequenceName="SEQ_TIPO_IDENTIFICACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_IDENTIFICACION_IDTIPOIDENTIFICACION_GENERATOR")
	@Column(name="id_tipo_identificacion")
	private long idTipoIdentificacion;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoIdentificacion")
	private List<Usuario> usuarios;

	public TipoIdentificacion() {
	}

	public long getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(long idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipoIdentificacion(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipoIdentificacion(null);

		return usuario;
	}

}