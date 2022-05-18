package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// singleton design pattern
	static Connection conn;
		
	static {
		try {
			//step 1
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Connection makeConnection() throws SQLException {
		//step 2
		
		// try keeping the connection details in a properties file and read them from the properties and bring it into java program
		
		// connection details to connect to local postgres
		String connectionUrl = "jdbc:postgresql://localhost:5432/sms";
		String userName = "postgres";
		String password = "root";

		
		// connection details to connect to AWS RDS postgres
//		String connectionUrl = "jdbc:postgresql://my-postgres-db-instance.cw4qvkziiwtm.us-east-1.rds.amazonaws.com:5432/sms";
//		String userName = "postgres";
//		String password = "rootroot";
		
		
		if(conn == null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);	
		}
		return conn;
	}
	

}
