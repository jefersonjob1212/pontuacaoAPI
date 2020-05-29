package br.com.digix.pontuacaofamilia.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;

public class UtilsFunctions {
	
	public static Integer calculaIdade(Instant born) {
		LocalDate ldToday = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).toLocalDate();
		LocalDate ldBorn = LocalDateTime.ofInstant(born, ZoneOffset.UTC).toLocalDate();
		Period period = Period.between(ldBorn, ldToday);
		return period.getYears();
	}

}
