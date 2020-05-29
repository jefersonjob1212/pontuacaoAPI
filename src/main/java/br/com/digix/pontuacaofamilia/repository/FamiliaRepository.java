package br.com.digix.pontuacaofamilia.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.digix.pontuacaofamilia.model.Familia;

public interface FamiliaRepository extends MongoRepository<Familia, String> {
	
	List<Familia> findByStatus(Integer status);
	
	Familia findByPessoasCpf(String cpf);
}
