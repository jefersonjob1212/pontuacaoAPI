package br.com.digix.pontuacaofamilia.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FamiliaResponseDTO {
	
	private String id;
	
	private List<PessoaResponseDTO> pessoas;

}
