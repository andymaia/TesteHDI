package com.teste.testehdi.controller.dto;

import java.util.Objects;

public class CorretorDto {
	
	private String nome;
	private String documento;
	private Integer codigo;
	private String dataCriação;
	private Double taxaComissao;
	private boolean active;
	
	public CorretorDto() {
	}

	public CorretorDto(String nome, String documento, Integer codigo, String dataCriação, Double taxaComissao,
			boolean status, boolean active) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.codigo = codigo;
		this.dataCriação = dataCriação;
		this.taxaComissao = taxaComissao;
		this.active = active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, codigo, dataCriação, documento, nome, taxaComissao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CorretorDto other = (CorretorDto) obj;
		return active == other.active && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataCriação, other.dataCriação) && Objects.equals(documento, other.documento)
				&& Objects.equals(taxaComissao, other.taxaComissao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDataCriação() {
		return dataCriação;
	}

	public void setDataCriação(String dataCriação) {
		this.dataCriação = dataCriação;
	}

	public Double getTaxaComissao() {
		return taxaComissao;
	}

	public void setTaxaComissao(Double taxaComissao) {
		this.taxaComissao = taxaComissao;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
