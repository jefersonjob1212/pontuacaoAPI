package br.com.digix.pontuacaofamilia.dto;

import java.time.Instant;

import br.com.digix.pontuacaofamilia.enums.TipoPessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
	
	private String nome;
	
	private TipoPessoaEnum tipo;
	
	private Instant dataNascimento;

}
