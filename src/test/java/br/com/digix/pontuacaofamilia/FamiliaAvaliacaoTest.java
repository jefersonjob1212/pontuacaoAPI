package br.com.digix.pontuacaofamilia;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class FamiliaAvaliacaoTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void buscarESalvarFamilias() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/classificacao"))
			.andExpect(status().isOk());
	}
	
	@Test
	void buscarFamiliasContempladas() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/classificacao"))
			.andExpect(status().isOk());
	}

}
