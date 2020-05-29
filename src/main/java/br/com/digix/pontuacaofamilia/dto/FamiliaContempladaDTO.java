package br.com.digix.pontuacaofamilia.dto;

import java.time.Instant;

public class FamiliaContempladaDTO {
	
	private String id;
	
	private Integer quantidadeCriteriosAtendidos;

	private Integer pontuacao;
	
	private Instant dataContemplacao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuantidadeCriteriosAtendidos() {
		return quantidadeCriteriosAtendidos;
	}

	public void setQuantidadeCriteriosAtendidos(Integer quantidadeCriteriosAtendidos) {
		this.quantidadeCriteriosAtendidos = quantidadeCriteriosAtendidos;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Instant getDataContemplacao() {
		if(dataContemplacao == null)
			return Instant.now();
		return dataContemplacao;
	}
	
	public void setDataContemplacao(Instant dataContemplacao) {
		this.dataContemplacao = dataContemplacao;
	}
}
