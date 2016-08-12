package fr.aoufi.springsample.runtime;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.aoufi.springsamplejava.conf.ApplicationConfiguration;

public class Runtime {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

	}

}
