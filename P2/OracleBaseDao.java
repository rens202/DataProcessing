package kanker.DataProcessing.P2;

import java.sql.*;

/**
 * This represents a data source implementation. A data source could be a database 
 * such as an RDBMS, OODBMS, XML repository, flat file system, and so forth. 
 * A data source can also be another system (legacy/mainframe), service (B2B service 
 * or credit card bureau), or some kind of repository (LDAP).
 * 
 * source: https://www.tutorialspoint.com/design_pattern/data_access_object_pattern.htm
 * source: http://www.oracle.com/technetwork/java/dataaccessobject-138824.html
 */
public class OracleBaseDao {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "ovchip";
	private static final String DB_PASS = "ovchip";

	//mag slechts één connection gebruiken, daarom static 
	protected static Connection conn;
	

	protected Connection getConnection() throws SQLException {

		if (conn == null) {
				// create a connection with the library database
				conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);		
		} 
		return conn;
	}
	
	public void closeConnection() throws SQLException  {
		if (conn != null) {
			conn.close();
		}
	}

}
