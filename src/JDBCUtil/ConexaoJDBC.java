package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
	 public static Connection  getConexao() {

			Connection connection = null;
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String password = "1312";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(url, user, password);
				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
	 }
}
