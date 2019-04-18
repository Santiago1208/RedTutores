package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipos_cuentas database table.
 * 
 */
@Entity
@Table(name="tipos_cuentas")
@NamedQuery(name="TiposCuenta.findAll", query="SELECT t FROM TiposCuenta t")
public class TiposCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOS_CUENTAS_IDTIPOCUENTA_GENERATOR", sequenceName="SEQ_TIPOS_CUENTAS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOS_CUENTAS_IDTIPOCUENTA_GENERATOR")
	@Column(name="id_tipo_cuenta")
	private long idTipoCuenta;

	@Column(name="nombre_tipo_cuenta")
	private String nombreTipoCuenta;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="tiposCuenta")
	private List<Cuenta> cuentas;

	public TiposCuenta() {
	}

	public long getIdTipoCuenta() {
		return this.idTipoCuenta;
	}

	public void setIdTipoCuenta(long idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}

	public String getNombreTipoCuenta() {
		return this.nombreTipoCuenta;
	}

	public void setNombreTipoCuenta(String nombreTipoCuenta) {
		this.nombreTipoCuenta = nombreTipoCuenta;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setTiposCuenta(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setTiposCuenta(null);

		return cuenta;
	}

}