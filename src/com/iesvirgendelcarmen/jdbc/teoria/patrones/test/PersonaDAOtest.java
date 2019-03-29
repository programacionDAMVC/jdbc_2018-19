package com.iesvirgendelcarmen.jdbc.teoria.patrones.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iesvirgendelcarmen.jdbc.teoria.patrones.Persona;
import com.iesvirgendelcarmen.jdbc.teoria.patrones.PersonaDAO;

public class PersonaDAOtest {

	@Test
	public void testObtenerTodasLasPersonas() {
		PersonaDAO personaDAO = new PersonaDAO();
		assertTrue(personaDAO.obtenerTodasLasPersonas().size() == 831);
		assertTrue(personaDAO.obtenerTodasLasPersonas().get(830).equals(
				new Persona("luis", "medina")));
	}

	@Test
	public void testObtenerPersonaPorEmail() {
		PersonaDAO personaDAO = new PersonaDAO();
		assertTrue(personaDAO.obtenerPersonaPorEmail("tlaffoleylane0@state.tx.us")
				.equals(new Persona("Tito","Laffoley-Lane")));
		assertFalse(personaDAO.obtenerPersonaPorEmail("msimeons2@addthis.com")
				.equals(new Persona("luis", "medina")));
		assertFalse(personaDAO.obtenerPersonaPorEmail("correoInexistente@ggkk.es")
				.equals(new Persona("Tito","Laffoley-Lane")));
	}
	@Test
	public void testBorrarPersona() {
		PersonaDAO personaDAO = new PersonaDAO();
		assertTrue(personaDAO.obtenerPersonaPorEmail("cclaraer8@nsw.gov.au")
				.equals(new Persona("Collin", "Clarae")));
		assertTrue(personaDAO.borrarPersona("cclaraer8@nsw.gov.au"));
		assertFalse(personaDAO.obtenerPersonaPorEmail("cclaraer8@nsw.gov.au")
				.equals(new Persona("Collin", "Clarae")));
		assertFalse(personaDAO.borrarPersona("correoInexistente@ggkk.es"));
	}

}
