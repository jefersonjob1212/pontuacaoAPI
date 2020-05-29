package br.com.digix.pontuacaofamilia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.digix.pontuacaofamilia.dto.FamiliaContempladaDTO;
import br.com.digix.pontuacaofamilia.dto.FamiliaResponseDTO;
import br.com.digix.pontuacaofamilia.service.FamiliaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/classificacao")
public class ClassificacaoController {
	
	private static final String URL_API = "http://localhost:3001/v1/familias";
	
	@Autowired
	private FamiliaService familiaService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@ApiOperation(
			value = "Cadastra uma pessoa.",
			response = String.class,
			notes = "Método que cadastra uma pessoa"
			)
	@ApiResponses(value = {
			@ApiResponse(
					code = 201,
					message = "Família foi encontrada e salva",
					response = String.class
					),
			@ApiResponse(
					code = 500,
					message = "Ocorreu erro na requisição"
					)
	})
	@PostMapping
	public ResponseEntity<?> buscarClassificarFamilias() {
		ResponseEntity<List<FamiliaResponseDTO>> familiasResponse = restTemplate
				.exchange(URL_API, HttpMethod.GET, null, new ParameterizedTypeReference<List<FamiliaResponseDTO>>() {
				});
		List<FamiliaResponseDTO> familias = familiasResponse.getBody();
		familiaService.salvarFamiliasAptas(familias);
		return new ResponseEntity<>("Operação realizada com sucesso", HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "Cadastra uma pessoa.",
			response = FamiliaContempladaDTO.class,
			notes = "Método que cadastra uma pessoa"
			)
	@ApiResponses(value = {
			@ApiResponse(
					code = 200,
					message = "Família foi encontrada e salva",
					response = String.class
					),
			@ApiResponse(
					code = 204,
					message = "Não trouxe nenhum resultado"
					),
			@ApiResponse(
					code = 500,
					message = "Ocorreu erro na requisição"
					)
	})
	@GetMapping
	public ResponseEntity<?> classificarFamilias() {
		return new ResponseEntity<>(familiaService.buscarFamiliasParaContemplar(), HttpStatus.OK);
	}

}
