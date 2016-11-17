import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class EmployeeQueries {

	   private static final String URL = "jdbc:mysql://localhost/employee_list?useSSL=false";
	   private static final String USERNAME = "root";
	   private static final String PASSWORD = "norman906";

	   private Connection connection; // manages connection
	   private PreparedStatement selectAllEmployees; 
	   private PreparedStatement selectEmployeeByLastName; 
	   private PreparedStatement insertNewEmployee; 
	    
	   // constructor
	   public EmployeeQueries()
	   {
	      try 
	      {
			  Class.forName("com.mysql.jdbc.Driver");
	         connection = 
	            DriverManager.getConnection(URL, USERNAME, PASSWORD);

	         // create query that selects all entries in the Employee List
	         selectAllEmployees = 
	            connection.prepareStatement("SELECT * FROM employee");
	         
	         // create query that selects entries with a specific last name
	         selectEmployeeByLastName = connection.prepareStatement(
	            "SELECT * FROM employee WHERE LastName = ?");
	         
	         // create insert that adds a new entry into the database
	         insertNewEmployee = connection.prepareStatement(
	            "INSERT INTO employee " + 
	            "(FirstName, LastName, Email, PhoneNumber) " + 
	            "VALUES (?, ?, ?, ?)");
	      }
	      catch (SQLException sqlException)
	      {
	         sqlException.printStackTrace();
	         System.exit(1);
	      } catch (ClassNotFoundException e) {
			  e.printStackTrace();
		  }
	   } // end EmployeeQueries constructor
	   
	   // select all of the employees in the database
	   public List< Employee> getAllEmployees()
	   {
	      List< Employee > results = null;
	      ResultSet resultSet = null;
	      
	      try 
	      {
	         // executeQuery returns ResultSet containing matching entries
	         resultSet = selectAllEmployees.executeQuery(); 
	         results = new ArrayList< Employee >();
	         
	         while (resultSet.next())
	         {
	        	   results.add(new Employee(
	               resultSet.getInt("employeeID"),
	               resultSet.getString("firstName"),
	               resultSet.getString("lastName"),
	               resultSet.getString("email"),
	               resultSet.getString("phoneNumber")));
	         } 
	      } 
	      catch (SQLException sqlException)
	      {
	         sqlException.printStackTrace();         
	      } 
	      finally
	      {
	         try 
	         {
	            resultSet.close();
	         } 
	         catch (SQLException sqlException)
	         {
	            sqlException.printStackTrace();         
	            close();
	         }
	      }
	      
	      return results;
	   } 

	   // select employee by last name   
	   public List< Employee > getEmployeeByLastName(String name)
	   {
	      List< Employee > results = null;
	      ResultSet resultSet = null;

	      try 
	      {
	         selectEmployeeByLastName.setString(1, name); // specify last name

	         // executeQuery returns ResultSet containing matching entries
	         resultSet = selectEmployeeByLastName.executeQuery(); 

	         results = new ArrayList< Employee >();

	         while (resultSet.next())
	         {
	               results.add(new Employee(resultSet.getInt("employeeID"),
	               resultSet.getString("firstName"),
	               resultSet.getString("lastName"),
	               resultSet.getString("email"),
	               resultSet.getString("phoneNumber")));
	         } 
	      } 
	      catch (SQLException sqlException)
	      {
	         sqlException.printStackTrace();
	      } 
	      finally
	      {
	         try 
	         {
	            resultSet.close();
	         }
	         catch (SQLException sqlException)
	         {
	            sqlException.printStackTrace();         
	            close();
	         }
	      } 
	      
	      return results;
	   } 
	   
	   // add an entry
	   public int addEmployee(
	      String fname, String lname, String email, String num)
	   {
	      int result = 0;
	      
	      // set parameters, then execute insertNewEmployee
	      try 
	      {
	         insertNewEmployee.setString(1, fname);
	         insertNewEmployee.setString(2, lname);
	         insertNewEmployee.setString(3, email);
	         insertNewEmployee.setString(4, num);

	         // insert the new entry; returns # of rows updated
	         result = insertNewEmployee.executeUpdate(); 
	      }
	      catch (SQLException sqlException)
	      {
	         sqlException.printStackTrace();
	         close();
	      } 
	      
	      return result;
	   } 
	   
	   // close the database connection
	   public void close()
	   {
	      try 
	      {
	         connection.close();
	      } 
	      catch (SQLException sqlException)
	      {
	         sqlException.printStackTrace();
	      } 
	   } 
	} // end class EmployeeQueries

