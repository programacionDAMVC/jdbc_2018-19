package com.iesvirgendelcarmen.jdbc.teoria.patrones.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iesvirgendelcarmen.jdbc.teoria.patrones.Persona;
import com.iesvirgendelcarmen.jdbc.teoria.patrones.PersonaDAO;

public class PersonaDAOtest {
	PersonaDAO personaDAO;
	@Before
	public void setup() {
		personaDAO = new PersonaDAO();

	}
	@Test
	public void testObtenerTodasLasPersonas() {
		//personaDAO = new PersonaDAO();
		assertTrue(personaDAO.obtenerTodasLasPersonas().size() == 831);
		assertTrue(personaDAO.obtenerTodasLasPersonas().get(830).equals(
				new Persona("luis", "medina")));
	}

	@Test
	public void testObtenerPersonaPorEmail() {
		//personaDAO = new PersonaDAO();
		assertTrue(personaDAO.obtenerPersonaPorEmail("tlaffoleylane0@state.tx.us")
				.equals(new Persona("Tito","Laffoley-Lane")));
		assertFalse(personaDAO.obtenerPersonaPorEmail("msimeons2@addthis.com")
				.equals(new Persona("luis", "medina")));
		assertFalse(personaDAO.obtenerPersonaPorEmail("correoInexistente@ggkk.es")
				.equals(new Persona("Tito","Laffoley-Lane")));
	}
	@Test
	public void testBorrarPersona() {
		//personaDAO = new PersonaDAO();
		assertTrue(personaDAO.obtenerPersonaPorEmail("cclaraer8@nsw.gov.au")
				.equals(new Persona("Collin", "Clarae")));
		assertTrue(personaDAO.borrarPersona("cclaraer8@nsw.gov.au"));
		assertFalse(personaDAO.obtenerPersonaPorEmail("cclaraer8@nsw.gov.au")
				.equals(new Persona("Collin", "Clarae")));
		assertFalse(personaDAO.borrarPersona("correoInexistente@ggkk.es"));
	}
	
	@Test
	public void testActualizarPersona() {
		assertTrue(personaDAO.obtenerPersonaPorEmail("tlaffoleylane0@state.tx.us")
				.equals(new Persona("Tito","Laffoley-Lane")));
		assertTrue(personaDAO.actualizarPersona(1, "correo@correo.es"));
		assertTrue(personaDAO.obtenerPersonaPorEmail("correo@correo.es")
				.equals(new Persona("Tito","Laffoley-Lane")));
		assertFalse(personaDAO.actualizarPersona(100000, "correo@correo.es"));

	}
	@Test
	public void testInsertarPersona() {
		assertTrue(personaDAO.insertarPersona(new Persona(5000, "nombre", "apellidos", "email")));
		assertTrue(personaDAO.obtenerPersonaPorEmail("email").equals(new Persona("nombre", "apellidos")));

	}

}
