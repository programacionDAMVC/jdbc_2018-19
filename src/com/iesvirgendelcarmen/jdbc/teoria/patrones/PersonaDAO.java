package com.iesvirgendelcarmen.jdbc.teoria.patrones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

	private Connection conexion;

	public PersonaDAO () {
		try {
			conexion =  Conexion.getConexion();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Persona> obtenerTodasLasPersonas(){
		List<Persona> lista = new ArrayList<>();
		String sql = "SELECT * FROM persona;";
		try (Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(sql);)
		{
			while (resultado.next())
				lista.add(new Persona(resultado.getInt("id"), resultado.getString("first_name"),
						resultado.getString("last_name"), resultado.getString("email")));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public Persona obtenerPersonaPorEmail(String email) {
		// SELECT * FROM persona WHERE email = 'ksimkinrf@elpais.com';
		Persona persona = new Persona();
		String sql = "SELECT * FROM persona WHERE email = ?;";
		try (PreparedStatement psStatement = conexion.prepareStatement(sql);){
			psStatement.setString(1, email);
			ResultSet rsSet = psStatement.executeQuery();
			while (rsSet.next())
				persona = new  Persona(rsSet.getInt("id"),
						rsSet.getString("first_name"), rsSet.getString("last_name"),
						rsSet.getString("email"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persona;
	}

	public boolean borrarPersona(String email) {
		int rows = 0;
		String sql = "DELETE FROM persona WHERE email = ?;";
		try (PreparedStatement psStatement = conexion.prepareStatement(sql);){
			psStatement.setString(1, email);
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;
	}

	public boolean actualizarPersona(int id, String email) {
		int rows = 0;
		String sql = "UPDATE persona SET email = ? WHERE id = ?;";
		try (PreparedStatement psStatement = conexion.prepareStatement(sql);){
			psStatement.setString(1, email);
			psStatement.setInt(2, id);
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;
	}
	
	public boolean insertarPersona(Persona persona) {
		int rows = 0;
		String sql = "INSERT INTO persona VALUES (?, ?, ?, ?);";
		try (PreparedStatement psStatement = conexion.prepareStatement(sql);){
			psStatement.setInt(1, persona.getId());
			psStatement.setString(2, persona.getFirstName());
			psStatement.setString(3, persona.getLastName());
			psStatement.setString(4, persona.getEmail());
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;
	}

}
