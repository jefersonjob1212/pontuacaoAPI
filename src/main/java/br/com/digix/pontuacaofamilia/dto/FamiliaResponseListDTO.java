package br.com.digix.pontuacaofamilia.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamiliaResponseListDTO {
	
	private List<FamiliaResponseDTO> familiaResponseDTO;
	
	public FamiliaResponseListDTO() {
		this.familiaResponseDTO = new ArrayList<>();
	}

}
