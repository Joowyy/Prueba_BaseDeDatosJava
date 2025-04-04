package ConexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_Leer_BDD {

	public static void main(String[] args) {

//		!! URL del Schema 'javaprueba_01' !!
		String url = "jdbc:mysql://localhost:3306/javaprueba_01";
		
		try {
			
//			|||| LEER BASE DE DATOS ||||
//			Pasamos la URL, Usuario y contraseña
			Connection c = DriverManager.getConnection(url, "root", "");
			Statement s = c.createStatement();
			
//			Codigo a ejecutar en el SQL
			ResultSet rs = s.executeQuery("SELECT * FROM alumnos");
			
//			'while' hace falta para imprimir todas las filas y columnas
			while (rs.next()) {

				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				
			}
			
//			|||| INTRODUCIR VALORES A LA TABLA ||||
			//String comando = "INSERT INTO [nombreTabla] VALUES ();";
			String nombreUsuario = "Mario";
			String cursoUsuario = "7ºDAM";
			String filaComando = String.format("INSERT INTO alumnos (id_alumno, nombre, edad, curso) VALUES ('%s', '%s', '%s', '%s');", 5, nombreUsuario, 222, cursoUsuario);
			
//			'executeUpdate' manda una instruccion a la base de datos
			s.executeUpdate(filaComando);
			
//		Checkeo de errores
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		
	}

}
