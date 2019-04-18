package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the disponibilidades database table.
 * 
 */
@Entity
@Table(name="disponibilidades")
@NamedQuery(name="Disponibilidad.findAll", query="SELECT d FROM Disponibilidad d")
public class Disponibilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DisponibilidadPK id;

	@Column(name="dia_disp")
	private String diaDisp;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_fin_disp")
	private Date horaFinDisp;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_inicio_disp")
	private Date horaInicioDisp;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Disponibilidad() {
	}

	public DisponibilidadPK getId() {
		return this.id;
	}

	public void setId(DisponibilidadPK id) {
		this.id = id;
	}

	public String getDiaDisp() {
		return this.diaDisp;
	}

	public void setDiaDisp(String diaDisp) {
		this.diaDisp = diaDisp;
	}

	public Date getHoraFinDisp() {
		return this.horaFinDisp;
	}

	public void setHoraFinDisp(Date horaFinDisp) {
		this.horaFinDisp = horaFinDisp;
	}

	public Date getHoraInicioDisp() {
		return this.horaInicioDisp;
	}

	public void setHoraInicioDisp(Date horaInicioDisp) {
		this.horaInicioDisp = horaInicioDisp;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}