package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//
public class Conexao {
	static Connection conn;
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost/bdVet?autoReconnect=true&useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conectar ao banco
    public Connection abrir(){
        try {
        	Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conectado!");
			return conn;
		}catch(SQLException ex) {
			System.out.println("ERRO: "+ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return conn;
    }
    
    public Connection fechar(){
    	try {
        	conn.close();
		}catch(SQLException ex) {
			System.out.println("ERRO: "+ex);
		}
        return conn;
    }

}