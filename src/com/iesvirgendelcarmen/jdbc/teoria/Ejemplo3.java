package com.iesvirgendelcarmen.jdbc.teoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejemplo3 {

	public static void main(String[] args) {
		String url = "jdbc:sqlite:db/ejemplo.db";
		String sqlInsert = "INSERT INTO persona VALUES (?, ?, ?, ?);";
		Connection conexion = null;
		PreparedStatement psStatement1 = null;
		try {
			conexion = DriverManager.getConnection(url);
			conexion.setAutoCommit(false); //permito transacciones
			psStatement1 = conexion.prepareStatement(sqlInsert);
			psStatement1.setInt(1, 10006);
			psStatement1.setString(2, "luis");
			psStatement1.setString(3, "medina");
			psStatement1.setString(4, "aaa@aaa.com");
			int rows1 = psStatement1.executeUpdate();
			System.out.println("Nº actualizaciones: " + rows1);
			psStatement1.setInt(1, 10003);
			psStatement1.setString(2, "luis");
			psStatement1.setString(3, "medina");
			psStatement1.setString(4, "b@b.com");
			int rows12 = psStatement1.executeUpdate();
			System.out.println("Nº actualizaciones: " + rows12);
			conexion.commit(); //ejecuta todas las operaciones sobre la BD 
		} catch (SQLException e) {
			try {
				conexion.rollback();  //vuelve al punto incial
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (conexion != null)
				try {
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (psStatement1 != null)
				try {
					psStatement1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
