import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) {
		try {
			//step 1 - Load the driver class into the memory
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			//step 2 - establish connection to the Database server
			// connectionURL has the protocol, ipaddress, port
			String connectionUrl = "jdbc:postgresql://localhost:5432/sample";
			String userName = "postgres";
			String password = "root";
			conn = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection Established.....");
			
			//step 3 -  create a statement and execute it
			
			Statement stmt = conn.createStatement();
			
			String query1 = "UPDATE account_details SET account_balance=account_balance-500 WHERE account_id=11111";
			String query2 = "UPDATE account_details SET account_balance=account_balance+500 WHERE account_id=33333";
			
			conn.setAutoCommit(false); // marks the begining of the transaction
			
			int rowsAffected1 = stmt.executeUpdate(query1);
			// anything could happen here, maybe DB server is down or network is down
			int rowsAffected2 = stmt.executeUpdate(query2);
		
			conn.commit(); // makes the temporary changes permanent, marks the end of a successfull transaction
			
			//step 4 - handle the exception
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // reverts the temporary changes, marks the end of an unsuccessful transaction
			e.printStackTrace();
		}
		
		

	}

	}




