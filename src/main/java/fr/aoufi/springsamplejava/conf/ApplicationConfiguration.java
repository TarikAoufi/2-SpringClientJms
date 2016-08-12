package fr.aoufi.springsamplejava.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.aoufi.springsample.service.PersonneService;
import fr.aoufi.springsample.service.PersonneServiceImpl;

@Configuration
@Import(value = { JMSConfiguration.class })
@ComponentScan(basePackages = { "fr.aoufi.springsample.service" })
@PropertySource(value = "classpath:/config.properties")
public class ApplicationConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public PersonneService personneService(ObjectMapper objectMapper) {
		PersonneServiceImpl personneService = new PersonneServiceImpl(objectMapper);
		return personneService;
	}

}
