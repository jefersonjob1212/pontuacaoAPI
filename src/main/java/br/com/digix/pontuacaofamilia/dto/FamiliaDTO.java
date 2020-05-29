package br.com.digix.pontuacaofamilia.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamiliaDTO {
	
	private String id;
	
	private List<PessoaDTO> pessoas;
	
	private BigDecimal rendas;
	
	private Integer status;
	
	private Integer pontuacao;
	
	private Integer quantidadeCriteriosAtendidos;
}
