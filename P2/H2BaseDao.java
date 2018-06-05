package kanker.DataProcessing.P2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2BaseDao {
	protected static Connection conn;
	
	protected Connection getConnection() throws SQLException {
		
		if(conn == null) {
				conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		}
		return conn;
	}

	public void closeConnection() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
}
