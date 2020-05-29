package br.com.digix.pontuacaofamilia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class PontuacaoFamiliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontuacaoFamiliaApplication.class, args);
	}

}
