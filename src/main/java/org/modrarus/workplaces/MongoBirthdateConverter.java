package org.modrarus.workplaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

/**
 * Конвертеры даты в строковое представление с возможностью сравнения.
 * Используется ввиду хранения в Mongo только даты со сременем.
 */
@Configuration
public class MongoBirthdateConverter {
	@Bean
	public MongoCustomConversions mongoCustomConversions() {
		final DateTimeFormatter dateComparableStringFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		final List<Converter<?,?>> converters = new LinkedList<Converter<?,?>>();
		converters.add(new Converter<LocalDate, String>() {
			@Override
			public String convert(final LocalDate _src) {
				return _src.format(dateComparableStringFormatter);
			}
		});
		converters.add(new Converter<String, LocalDate>() {
			@Override
			public LocalDate convert(final String _src) {
				return LocalDate.parse(_src, dateComparableStringFormatter);
			}
		});
		return new MongoCustomConversions(converters);
	}
}
