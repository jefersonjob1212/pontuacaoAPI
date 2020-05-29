package br.com.digix.pontuacaofamilia.model;

import java.time.Instant;

import br.com.digix.pontuacaofamilia.enums.TipoPessoaEnum;
import lombok.Data;

@Data
public class Pessoa {
	
	private String id;
	
	private String cpf;
	
	private String nome;
	
	private TipoPessoaEnum tipo;
	
	private Instant dataNascimento;

}
