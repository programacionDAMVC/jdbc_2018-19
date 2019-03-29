package com.iesvirgendelcarmen.jdbc.teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//operaciones insert, update, delete
public class Ejemplo2 {

	public static void main(String[] args) {
		// primero establecer la conexion
		// necesistamos un objeto Connection
		String url = "jdbc:sqlite:db/ejemplo.db";
		//INSERT INTO persona VALUES (1001, 'juan', 'garcía', 'email@correo.es');
		String sqlInsert = "INSERT INTO persona VALUES (?, ?, ?, ?);";
		//UPDATE persona SET email = 'email@email.es' WHERE id = 1002;
		String sqlUpdate = "UPDATE persona SET email = ? WHERE id = ?;";
		//DELETE FROM persona WHERE email like 'a%';
		String sqlDelete = "DELETE FROM persona WHERE email like ?;";
		try (Connection conexion = DriverManager.getConnection(url);)
		{
//			PreparedStatement psStatement1 = conexion.prepareStatement(sqlInsert);
//			psStatement1.setInt(1, 1002);
//			psStatement1.setString(2, "luis");
//			psStatement1.setString(3, "medina");
//			psStatement1.setString(4, "correo@correos.com");
//			int rows = psStatement1.executeUpdate();
//			System.out.println("Nº actualizaciones: " + rows);
			
			PreparedStatement psStatement2 = conexion.prepareStatement(sqlUpdate);
			psStatement2.setString(1, "newemail@newemail.es");
			psStatement2.setInt(2, 1002);
			int rowsUpate = psStatement2.executeUpdate();
			System.out.println("Nº registros actualizados: " + rowsUpate);
			
			PreparedStatement psStatement3 = conexion.prepareStatement(sqlDelete);
			psStatement3.setString(1, "a%");
			int rowsDelete = psStatement3.executeUpdate();
			System.out.println("Nº registros borrados: " + rowsDelete);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
