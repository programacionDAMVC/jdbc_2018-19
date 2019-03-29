package com.iesvirgendelcarmen.jdbc.teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Ejemplo de consultas sobre la base de datos
public class Ejemplo1 {

	public static void main(String[] args) {
		//Crear el objeto Connection, objeto Statement, objeto ResultSet
		String sqlConsulta1 = "SELECT * FROM persona;";
		String email = "eflemingr9@vinaora.com";
		// SELECT last_name, first_name  FROM persona WHERE email = 'eflemingr9@vinaora.com';

		String sqlConsulta2 = "SELECT last_name, first_name FROM persona WHERE email = '" + 
				email + "';";
		String sqlConsulta3 = "SELECT last_name, first_name FROM persona WHERE email =  ?;";
		try (Connection conexion = DriverManager.getConnection(
				"jdbc:sqlite:db/ejemplo.db");
				Statement statement1 = conexion.createStatement () ;
				ResultSet resultSet1 = statement1.executeQuery(sqlConsulta1);
				Statement statement2 = conexion.createStatement () ;
				ResultSet resultSet2 = statement2.executeQuery(sqlConsulta2);
				PreparedStatement psPreparedStatement = conexion.prepareStatement(sqlConsulta3);
				)
		{
			int contador = 0;
			while (resultSet1.next()) {
				contador++;
				System.out.printf("%d.- %S, %S. email: %s%n",
						resultSet1.getInt("id"), resultSet1.getString("last_name"),
						resultSet1.getString("first_name"), resultSet1.getString("email"));
			}
			System.out.println("Nº registros: " + contador);

			while(resultSet2.next())
				System.out.printf("%s, %s%n", resultSet2.getString(1),
						resultSet2.getString(2));

			psPreparedStatement.setString(1, email);
			ResultSet rsSet = psPreparedStatement.executeQuery();
			while(rsSet.next())
				System.out.printf("%s, %s%n", rsSet.getString(1),
						rsSet.getString(2));



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
