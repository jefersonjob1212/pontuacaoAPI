package br.com.digix.pontuacaofamilia.enums;

public enum TipoPessoaEnum {
	
	PRETENDENTE("Pretendente"),
	CONJUGE("Cônjuge"),
	DEPENDENTE("Dependente");
	
	private String value;
	
	private TipoPessoaEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
