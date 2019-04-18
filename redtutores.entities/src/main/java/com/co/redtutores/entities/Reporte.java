package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reportes database table.
 * 
 */
@Entity
@Table(name="reportes")
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTES_IDREPORTE_GENERATOR", sequenceName="SEQ_REPORTES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTES_IDREPORTE_GENERATOR")
	@Column(name="id_reporte")
	private long idReporte;

	@Column(name="archivo_rep")
	private byte[] archivoRep;

	public Reporte() {
	}

	public long getIdReporte() {
		return this.idReporte;
	}

	public void setIdReporte(long idReporte) {
		this.idReporte = idReporte;
	}

	public byte[] getArchivoRep() {
		return this.archivoRep;
	}

	public void setArchivoRep(byte[] archivoRep) {
		this.archivoRep = archivoRep;
	}

}