package br.com.digix.pontuacaofamilia.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.AtomicDouble;

import br.com.digix.pontuacaofamilia.dto.FamiliaContempladaDTO;
import br.com.digix.pontuacaofamilia.dto.FamiliaDTO;
import br.com.digix.pontuacaofamilia.dto.FamiliaResponseDTO;
import br.com.digix.pontuacaofamilia.dto.PessoaDTO;
import br.com.digix.pontuacaofamilia.dto.PessoaResponseDTO;
import br.com.digix.pontuacaofamilia.enums.TipoPessoaEnum;
import br.com.digix.pontuacaofamilia.model.Familia;
import br.com.digix.pontuacaofamilia.repository.FamiliaRepository;
import br.com.digix.pontuacaofamilia.service.FamiliaService;
import br.com.digix.pontuacaofamilia.utils.UtilsFunctions;

@Service
public class FamiliaServiceImpl implements FamiliaService {

	@Autowired
	private FamiliaRepository familiaRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<FamiliaDTO> buscarTodosAptos() {
		// TODO Auto-generated method stub
		return familiaRepository.findAll()
				.stream()
				.map(famlily -> mapper.map(familiaRepository, FamiliaDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void salvarFamiliasAptas(List<FamiliaResponseDTO> familias) {
		AtomicLong contPessoas = new AtomicLong(0);
		AtomicInteger pontuacao = new AtomicInteger(0);
		AtomicInteger quantiadeCriterio = new AtomicInteger(1);
		AtomicInteger status = new AtomicInteger(0);
		AtomicDouble rendaTotal = new AtomicDouble();
		List<FamiliaDTO> familiasSalvar = new ArrayList<>();
		List<PessoaDTO> pessoasSalvar = new ArrayList<>();

		familias.stream()
		.forEach(familia -> {
			//Tratando familia
			contPessoas.addAndGet(familia.getPessoas()
					.stream()
					.filter(p -> p.getTipo() != TipoPessoaEnum.PRETENDENTE 
					&& UtilsFunctions.calculaIdade(p.getDataNascimento()) <= 18)
					.count());
				
			status.getAndSet(
					!existePretendenteFamilia(familia.getPessoas()) ? 3 : 0);
			
			if(contPessoas.longValue() > 0) {
				quantiadeCriterio.getAndAdd(1);
				if(contPessoas.longValue() >= 3) {
					pontuacao.addAndGet(3);
				} else if(contPessoas.longValue() < 3 || contPessoas.longValue() >= 1) {
					pontuacao.addAndGet(2);
				}
			}
			familia.getPessoas()
			.stream()
			.forEach(pessoa -> {
				//Tratando pessoa
				final BigDecimal valorPessoa = pessoa.getValorRenda();
				final Integer idade = UtilsFunctions.calculaIdade(pessoa.getDataNascimento());
				
				if(idade >= 45)
					pontuacao.addAndGet(3);
				else if(idade >= 30 && idade <= 44) 
					pontuacao.addAndGet(2);
				else
					pontuacao.addAndGet(1);
				rendaTotal.getAndAdd(valorPessoa.doubleValue());
				if(pessoa.getTipo() == TipoPessoaEnum.PRETENDENTE)
					status.getAndSet(verStatusFamiliaPorPretendente(pessoa));
				pessoasSalvar.add(new PessoaDTO(pessoa.getNome(), pessoa.getTipo(), pessoa.getDataNascimento()));
			});
			
			if(rendaTotal.doubleValue() < 2000) {
				quantiadeCriterio.getAndAdd(1);
				if(rendaTotal.doubleValue() <= 900)
					pontuacao.addAndGet(5);
				else if(rendaTotal.doubleValue() >= 901
						&& rendaTotal.doubleValue()  <= 1500)
					pontuacao.addAndGet(3);
				else if(rendaTotal.doubleValue() <= 1501
						&& rendaTotal.doubleValue() <= 2000)
					pontuacao.addAndGet(3);
			}
			
			familiasSalvar.add(
					new FamiliaDTO(
							"", 
							pessoasSalvar, 
							new BigDecimal(rendaTotal.doubleValue()), 
							status.get(), 
							pontuacao.get(), 
							quantiadeCriterio.get()));
		});
		
		familiasSalvar.stream()
		.forEach(family -> {
			familiaRepository.save(mapper.map(family, Familia.class));
		});
	}
	
	private boolean existePretendenteFamilia(List<PessoaResponseDTO> pessoas) {
		return pessoas.stream()
				.filter(p -> p.getTipo() == TipoPessoaEnum.PRETENDENTE)
				.count() == 0;
	}
	
	private Integer verStatusFamiliaPorPretendente(PessoaResponseDTO pessoa) {
		Familia familia = familiaRepository.findByPessoasCpf(pessoa.getCpf());		
		if(familia == null) {
			return pessoa.getTipo() == TipoPessoaEnum.PRETENDENTE ? 0 : 3;
		}
		return familia.getStatus() == 0 ? 1 : 2;
	}

	@Override
	public List<FamiliaContempladaDTO> buscarFamiliasParaContemplar() {
		// TODO Auto-generated method stub
		return familiaRepository.findByStatus(0)
				.stream()
				.map(famlila -> mapper.map(famlila, FamiliaContempladaDTO.class))
				.collect(Collectors.toList());
	}
}
