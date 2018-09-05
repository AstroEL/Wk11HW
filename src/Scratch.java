import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Scratch {

	public static void main(String[] args) {
			// jdbc:mysql://hostname:port/databasename //
		String connectionString = "jdbc:mysql://localhost:3306/employees";	// localhost = alias to 127.0.0.1 = your computer
		
		try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "Neener12!");
			System.out.println("Success");
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
		
		
	}

}
