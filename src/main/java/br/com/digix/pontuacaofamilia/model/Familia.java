package br.com.digix.pontuacaofamilia.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "familia")
public class Familia {

	@Id
	private String id;
	
	private List<Pessoa> pessoas;
	
	private List<Renda> rendas;
	
	private Integer status;
	
	private Integer pontuacao;
	
	private Integer quantidadeCriteriosAtendidos;
}
