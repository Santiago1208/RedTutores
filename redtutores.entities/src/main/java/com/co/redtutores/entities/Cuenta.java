package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuentas database table.
 * 
 */
@Entity
@Table(name="cuentas")
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nombre_usuario")
	private String nombreUsuario;

	@Column(name="clave_cuenta")
	private String claveCuenta;

	@Column(name="id_estado")
	private java.math.BigDecimal idEstado;

	//bi-directional many-to-one association to TiposCuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_cuenta")
	private TiposCuenta tiposCuenta;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cuenta")
	private List<Usuario> usuarios;

	public Cuenta() {
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClaveCuenta() {
		return this.claveCuenta;
	}

	public void setClaveCuenta(String claveCuenta) {
		this.claveCuenta = claveCuenta;
	}

	public java.math.BigDecimal getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(java.math.BigDecimal idEstado) {
		this.idEstado = idEstado;
	}

	public TiposCuenta getTiposCuenta() {
		return this.tiposCuenta;
	}

	public void setTiposCuenta(TiposCuenta tiposCuenta) {
		this.tiposCuenta = tiposCuenta;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCuenta(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCuenta(null);

		return usuario;
	}

}