package br.com.digix.pontuacaofamilia.service;

import java.util.List;

import br.com.digix.pontuacaofamilia.dto.FamiliaContempladaDTO;
import br.com.digix.pontuacaofamilia.dto.FamiliaDTO;
import br.com.digix.pontuacaofamilia.dto.FamiliaResponseDTO;

public interface FamiliaService {
	
	List<FamiliaDTO> buscarTodosAptos();

	void salvarFamiliasAptas(List<FamiliaResponseDTO> familias);
	
	List<FamiliaContempladaDTO> buscarFamiliasParaContemplar();

}
