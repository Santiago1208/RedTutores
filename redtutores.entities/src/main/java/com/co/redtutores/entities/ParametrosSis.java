package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the parametros_sis database table.
 * 
 */
@Entity
@Table(name="parametros_sis")
@NamedQuery(name="ParametrosSis.findAll", query="SELECT p FROM ParametrosSis p")
public class ParametrosSis implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParametrosSisPK id;

	@Column(name="valor_numerico")
	private BigDecimal valorNumerico;

	@Column(name="valor_textual")
	private String valorTextual;

	public ParametrosSis() {
	}

	public ParametrosSisPK getId() {
		return this.id;
	}

	public void setId(ParametrosSisPK id) {
		this.id = id;
	}

	public BigDecimal getValorNumerico() {
		return this.valorNumerico;
	}

	public void setValorNumerico(BigDecimal valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getValorTextual() {
		return this.valorTextual;
	}

	public void setValorTextual(String valorTextual) {
		this.valorTextual = valorTextual;
	}

}