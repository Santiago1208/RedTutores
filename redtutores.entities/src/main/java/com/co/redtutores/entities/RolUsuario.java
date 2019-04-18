package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol_usuarios database table.
 * 
 */
@Entity
@Table(name="rol_usuarios")
@NamedQuery(name="RolUsuario.findAll", query="SELECT r FROM RolUsuario r")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROL_USUARIOS_IDROLUSUARIO_GENERATOR", sequenceName="SEQ_ROL_USUARIOS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROL_USUARIOS_IDROLUSUARIO_GENERATOR")
	@Column(name="id_rol_usuario")
	private long idRolUsuario;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public RolUsuario() {
	}

	public long getIdRolUsuario() {
		return this.idRolUsuario;
	}

	public void setIdRolUsuario(long idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}