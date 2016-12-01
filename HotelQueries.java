import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * CS157A Project
 * Alex Preston, Frank Mock, Joshua Urrea
 *
 */
public class HotelQueries {

	private static final String URL = "jdbc:mysql://localhost/Hotel?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";

	private Connection connection; // manages connection

	/**
	 * Below are all the queries our program will use.
	 */
	private PreparedStatement selectAllCustomers;
	private PreparedStatement selectAllAmenities;
	private PreparedStatement selectCustomerByName;
	private PreparedStatement insertNewCustomer;
	private PreparedStatement deleteCustomer;
	private PreparedStatement updateNameEmailPhone;
	private PreparedStatement updateNameEmail;
	private PreparedStatement updateNamePhone;
	private PreparedStatement updateEmailPhone;
	private PreparedStatement updateCustomerName;
	private PreparedStatement updateEmail;
	private PreparedStatement updatePhone;
	private PreparedStatement selectAllRooms;
	//< TO DO > add more queries

	// constructor
	public HotelQueries()
	{
		try
		{
			connection =
					DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// create query that selects all entries in the Customer table
			selectAllCustomers =
					connection.prepareStatement("SELECT cID, cNAME, email, phone, num_rooms FROM customer");

			// create query that selects entries with a specific last name
			selectCustomerByName = connection.prepareStatement(
					"SELECT * FROM customer WHERE cName = ?");

			// create insert that adds a new entry into the database
			insertNewCustomer = connection.prepareStatement(
					"INSERT INTO customer " +
							"(cName, email, phone) " +
							"VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
	         // create query that selects all entries Rooms table
	         selectAllRooms = 
	            connection.prepareStatement("SELECT * FROM room");
	         
	         // delete customer using cID
	         deleteCustomer =
	        		 connection.prepareStatement("DELETE FROM customer WHERE cID = ?");
	         
	         // Update a customer's name, email, and phone
	         updateNameEmailPhone = 
	        		 connection.prepareStatement("Update customer SET cNAME= ?, "
	        		 		+ "email= ?, phone= ? WHERE cID = ?");
	         
	         // Update a customer's name and email
	         updateNameEmail = 
	        		 connection.prepareStatement("Update customer SET cNAME= ?, "
	        		 		+ "email= ? WHERE cID = ?");
	         
	         // Update a customer's name and phone
	         updateNamePhone = 
	        		 connection.prepareStatement("Update customer SET cNAME= ?, "
	        		 		+ "phone= ? WHERE cID = ?");
	         
	         // Update a customer's email and phone
	         updateEmailPhone = 
	        		 connection.prepareStatement("Update customer SET email= ?, "
	        		 		+ "phone= ? WHERE cID = ?");
	         
	         // Update a customer's name
	         updateCustomerName = 
	        		 connection.prepareStatement("Update customer SET cNAME= ? "
	        		 		+ "WHERE cID = ?");
	         
	         // Update a customer's email
	         updateEmail = 
	        		 connection.prepareStatement("Update customer SET email= ? "
	        		 		+ "WHERE cID = ?");
	         
	         // Update a customer's phone
	         updatePhone = 
	        		 connection.prepareStatement("Update customer SET phone= ? "
	        		 		+ "WHERE cID = ?");
	         // Select all amenities
	         selectAllAmenities = 
	        		 connection.prepareStatement("SELECT * FROM ammenities");
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
			System.exit(1);
		}
	} // end HotelQueries constructor

	// select Customer by name
	public List< Customer > getCustomerByName(String name)
	{
		List< Customer > results = null;
		ResultSet resultSet = null;

		try
		{
			selectCustomerByName.setString(1, name); // specify name

			// executeQuery returns ResultSet containing matching entries
			resultSet = selectCustomerByName.executeQuery();

			results = new ArrayList< Customer >();

			while (resultSet.next())
			{
				results.add(new Customer(
						resultSet.getInt("cID"),
						resultSet.getString("cNAME"),
						resultSet.getString("email"),
						resultSet.getString("phone"),
						resultSet.getInt("num_rooms")));
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


	/*
	 * Adds a new Customer to the database and
	 * returns the customer ID, cID.
	 */
	public int addCustomer(
			String cName, String email, String phone)
	{
		int result = 0;

		// set parameters, then execute insertNewEmployee
		try
		{
			insertNewCustomer.setString(1, cName);
			insertNewCustomer.setString(2, email);
			insertNewCustomer.setString(3, phone);
			//insertNewCustomer.setString(4, num_rooms);

			// insert the new entry (returns # of rows updated)
			insertNewCustomer.executeUpdate();
		
			// Get the ID of the newly inserted Customer
			ResultSet rs = insertNewCustomer.getGeneratedKeys();
			if(rs.next())
			{
				result = rs.getInt(1);
			}
			
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
			close();
		}
		System.out.println("The ID of newly inserted customer is: "  + result);
		// Return the ID of the customer
		return result;
	}
	
	/*
	 * Calls the selecAllRooms query and
	 * returns the result set
	*/
	public ResultSet getAllRoomsResultSet()
	{
	   ResultSet resultSet = null;
	      
	   try 
	   {
	      // executeQuery
	      resultSet = selectAllRooms.executeQuery(); 
	         
	   } 
	   catch (SQLException sqlException)
	   {
	      sqlException.printStackTrace();         
	   } 
	      
	   return resultSet;
	}
	
	/*
	 * Calls the selecAllAmenities query and
	 * returns the result set
	*/
	public ResultSet getAllAmenitiesResultSet()
	{
	   ResultSet resultSet = null;
	      
	   try 
	   {
	      // executeQuery
	      resultSet = selectAllAmenities.executeQuery(); 
	         
	   } 
	   catch (SQLException sqlException)
	   {
	      sqlException.printStackTrace();         
	   } 
	      
	   return resultSet;
	}
	   
	/*
	 * Calls the selectAllCustomers query and
	 * returns a result set
	 */
	public ResultSet getAllCustomersResultSet()
	{
	      ResultSet resultSet = null;
	      
	      try 
	      {
	         // executeQuery returns ResultSet containing matching entries
	         resultSet = selectAllCustomers.executeQuery(); 
	         
	      } 
	      catch (SQLException sqlException)
	      {
	         sqlException.printStackTrace();         
	      } 
	      
	      return resultSet;
	 }
	   
	   
	 /*
	  * Delete a customer given a customer ID
	  */
	public void deleteCustomerUsingID(String cID)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   // set the cID in the query
			   deleteCustomer.setString(1, cID);
		    	  
		       // executeQuery
		       deleteCustomer.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
	}
	
	 /*
	  * Update a customer's name, email, phone
	  */
	public void updateCustomerNameEmailPhone(
					String cID, String name, String email, String phone)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   updateNameEmailPhone.setString(1, name);
			   updateNameEmailPhone.setString(2, email);
			   updateNameEmailPhone.setString(3, phone);
			   // set the cID in the query
			   updateNameEmailPhone.setString(4, cID);
		    	  
		       // executeQuery
			   updateNameEmailPhone.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
	}
	
	 /*
	  * Update a customer's name and email
	  */
	public void updateCustomerNameEmail(
					String cID, String name, String email)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   updateNameEmail.setString(1, name);
			   updateNameEmail.setString(2, email);
			  
			   // set the cID in the query
			   updateNameEmail.setString(3, cID);
		    	  
		       // executeQuery
			   updateNameEmail.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
	}
	
	 /*
	  * Update a customer's name and phone
	  */
	public void updateCustomerNamePhone(
					String cID, String name, String phone)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   updateNamePhone.setString(1, name);
			   updateNamePhone.setString(2, phone);
			  
			   // set the cID in the query
			   updateNamePhone.setString(3, cID);
		    	  
		       // executeQuery
			   updateNamePhone.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
	}
	
	 /*
	  * Update a customer's email and phone
	  */
	public void updateCustomerEmailPhone(
					String cID, String email, String phone)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   updateEmailPhone.setString(1, email);
			   updateEmailPhone.setString(2, phone);
			  
			   // set the cID in the query
			   updateEmailPhone.setString(3, cID);
		    	  
		       // executeQuery
			   updateEmailPhone.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
	}
	
	 /*
	  * Update a customer's name
	  */
	public void updateCustomerName(String cID, String name)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   updateCustomerName.setString(1, name);
			  
			   // set the cID in the query
			   updateCustomerName.setString(2, cID);
		    	  
		       // executeQuery
			   updateCustomerName.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
	}
	
	 /*
	  * Update a customer's email
	  */
	public void updateCustomerEmail(String cID, String email)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   updateEmail.setString(1, email);
			  
			   // set the cID in the query
			   updateEmail.setString(2, cID);
		    	  
		       // executeQuery
			   updateEmail.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
	}
	
	 /*
	  * Update a customer's phone
	  */
	public void updateCustomerPhone(String cID, String phone)
	{
		   ResultSet resultSet = null;
		      
		   try 
		   {
			   updatePhone.setString(1, phone);
			  
			   // set the cID in the query
			   updatePhone.setString(2, cID);
		    	  
		       // executeQuery
			   updatePhone.executeUpdate(); 
		         
		    } 
		    catch (SQLException sqlException)
		    {
		         sqlException.printStackTrace();         
		    } 
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

}