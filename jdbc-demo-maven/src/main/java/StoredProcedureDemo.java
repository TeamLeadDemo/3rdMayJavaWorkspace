import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcedureDemo {

	public static void main(String[] args) {
		try {
			//step 1 - Load the driver class into the memory
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//step 2 - establish connection to the Database server
			// connectionURL has the protocol, ipaddress, port
			String connectionUrl = "jdbc:postgresql://localhost:5432/sample";
			String userName = "postgres";
			String password = "root";
			Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection Established.....");
			
			//step 3 -  create a statement and execute it
			// 3 types of statements
			// 1. Statement - Ordinary
			// 2. PreparedStatement - precompiled 
			// 3. CallableStatement - for calling stored procedure
						
			PreparedStatement pstmt = conn.prepareStatement("CALL transfer_money(?, ?, ?)");
			pstmt.setInt(1, 22222);
			pstmt.setInt(2, 33333);
			pstmt.setInt(3, 75 );
			pstmt.execute();
			
			System.out.println("Money transfered");
			
			//step 4 - handle the exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		


	}

}
