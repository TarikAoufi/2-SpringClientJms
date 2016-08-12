package fr.aoufi.springsample.service;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.aoufi.springsample.model.Personne;

public class PersonneServiceImpl implements PersonneService, SessionAwareMessageListener<TextMessage> {

	private ObjectMapper objectMapper;

	public PersonneServiceImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override 
	public void onMessage(TextMessage message, Session session) throws JMSException {
		try {
			System.out.println("ok");
			Personne personne = objectMapper.readValue(message.getText(), Personne.class);
			System.out.println(personne);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

}
