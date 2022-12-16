package com.netbiis;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class PagamentoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dataInscricao;
	private int pagidCliente;
	private int pagCdcurso;

	public PagamentoId() {
	}

	public PagamentoId(Date dataInscricao, int pagidCliente, int pagCdcurso) {
		this.dataInscricao = dataInscricao;
		this.pagidCliente = pagidCliente;
		this.pagCdcurso = pagCdcurso;
	}

	public PagamentoId(Integer idCliente, Integer cdCurso) {
		this.pagidCliente = idCliente;
		this.pagCdcurso = cdCurso;
	}

	@Column(name = "dataInscricao", nullable = false, length = 10)
	public Date getDataInscricao() {
		return this.dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	@Column(name = "pagidCliente", nullable = false)
	public int getPagidCliente() {
		return this.pagidCliente;
	}

	public void setPagidCliente(int pagidCliente) {
		this.pagidCliente = pagidCliente;
	}

	@Column(name = "pagCdcurso", nullable = false)
	public int getPagCdcurso() {
		return this.pagCdcurso;
	}

	public void setPagCdcurso(int pagCdcurso) {
		this.pagCdcurso = pagCdcurso;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PagamentoId))
			return false;
		PagamentoId castOther = (PagamentoId) other;

		return true;
	}

	public int hashCode() {
		int result = 17;

		return result;
	}

}
