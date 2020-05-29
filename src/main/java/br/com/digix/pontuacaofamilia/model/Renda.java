package br.com.digix.pontuacaofamilia.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Renda {
	
	private String pessoaId;
	
	private BigDecimal valor;

}
