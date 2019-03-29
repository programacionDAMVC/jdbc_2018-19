package com.iesvirgendelcarmen.jdbc.teoria.patrones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

	private static Connection conexion = null;   //este objeto va a ser la instacia única

	private Conexion( ) {}  //constructor privado, no se puede instaciar desde otra clase

	//método para obtener la instancia
	public static Connection getConexion() throws SQLException, FileNotFoundException, IOException {
		if (conexion == null) {
			//cargamos el fichero de propiedades
			Properties propiedades = new Properties();
			propiedades.load(new FileReader("config.properties"));
			String DRIVER = propiedades.getProperty("DRIVER");
			String URL    =	propiedades.getProperty("URL");
					//creamos la conexion
					//String url = "jdbc:sqlite:db/ejemplo.db";
			conexion = DriverManager.getConnection(DRIVER + URL);
		}
		return conexion;
	}

	//método para cerrar la conexión
	public static void cerrarConexion () throws SQLException {
		if (conexion != null)
			conexion.close();
	}

	public static void main(String[] args) {
		try {
			
			Connection connection1 = Conexion.getConexion();
			System.out.println(connection1);
			Connection connection2 = Conexion.getConexion();
			System.out.println(connection2);
			System.out.println(connection1.equals(connection2));
			Conexion.cerrarConexion();
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







}
