package com.co.redtutores.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the adjuntos database table.
 * 
 */
@Entity
@Table(name="adjuntos")
@NamedQuery(name="Adjunto.findAll", query="SELECT a FROM Adjunto a")
public class Adjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AdjuntoPK id;

	@Column(name="archivo_pdf")
	private byte[] archivoPdf;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Adjunto() {
	}

	public AdjuntoPK getId() {
		return this.id;
	}

	public void setId(AdjuntoPK id) {
		this.id = id;
	}

	public byte[] getArchivoPdf() {
		return this.archivoPdf;
	}

	public void setArchivoPdf(byte[] archivoPdf) {
		this.archivoPdf = archivoPdf;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}