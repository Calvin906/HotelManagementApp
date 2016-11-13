import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HotelQueries {

	   private static final String URL = "jdbc:mysql://localhost/employee_list?useSSL=false";
	   private static final String USERNAME = "root";
	   private static final String PASSWORD = "norman906";

	   private Connection connection; // manages connection
	   private PreparedStatement selectAllCustomers;
	   private PreparedStatement selectCustomerByLastName;
	   private PreparedStatement insertNewCustomer;

	   // constructor
	   public HotelQueries()
	   {
	      try
	      {
	         connection =
	            DriverManager.getConnection(URL, USERNAME, PASSWORD);

	         // create query that selects all entries in the Customer table
	         selectAllCustomers =
	            connection.prepareStatement("SELECT * FROM customer");

	         // create query that selects entries with a specific last name
	         selectCustomerByLastName = connection.prepareStatement(
	            "SELECT * FROM customer WHERE cName = ?");

	         // create insert that adds a new entry into the database
	         insertNewCustomer = connection.prepareStatement(
	            "INSERT INTO customer " +
	            "(cName, email, phone) " +
	            "VALUES (?, ?, ?)");
	      }
	      catch (SQLException sqlException)
	      {
	         sqlException.printStackTrace();
	         System.exit(1);
	      }
	   } // end HotelQueries constructor

}
