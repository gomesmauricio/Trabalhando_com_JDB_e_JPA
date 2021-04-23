package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao  {
	
	public static Connection getConnection() throws SQLException{
		
		Connection conn = null;
		
		String urlConnection = "jdbc:mysql://localhost/digital_inovation_one";
		
		try {conn = DriverManager.getConnection(urlConnection, "root", "root"); 
		System.out.println("SUCESSO!");
	
			} catch (Exception e) {
					System.out.println("FALHA!");
		}
		return conn;   	
		
	}
	
}
