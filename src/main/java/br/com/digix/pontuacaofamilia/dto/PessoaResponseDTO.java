package br.com.digix.pontuacaofamilia.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.digix.pontuacaofamilia.enums.TipoPessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaResponseDTO {
	
	private String id;
	
	private String nome;
	
	private String cpf;
	
	private TipoPessoaEnum tipo;
	
	private Instant dataNascimento;
	
	private BigDecimal valorRenda;
}
