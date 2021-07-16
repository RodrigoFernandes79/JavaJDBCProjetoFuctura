import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
	public static void main(String[] args)throws SQLException {
		String url= "jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String password="1312";
		
		try {
			Connection connection = DriverManager.getConnection(url,
					user, password);
			System.out.println("Conexão OK!");
		}catch(SQLException e) {
			System.out.println("NÃo foi possível conectar");
			
		}
	}
}