package fr.aoufi.springsamplejava.conf;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import fr.aoufi.springsample.service.PersonneService;

@Configuration
public class JMSConfiguration {

	@Bean // dépiler de manière asynchrone
	public DefaultMessageListenerContainer messageListenerContainer(PersonneService personneService) {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setMessageListener(personneService);
		container.setDestinationName("personneQueue");
		return container;
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		return activeMQConnectionFactory;
	}

}
