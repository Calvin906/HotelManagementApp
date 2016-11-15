import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * CS157A Project
 *
 */
public class HotelQueries {

	private static final String URL = "jdbc:mysql://localhost/Hotel?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "norman906";

	private Connection connection; // manages connection

	/**
	 * Below are all the queries our program will use.
	 */
	private PreparedStatement selectAllCustomers;
	private PreparedStatement selectCustomerByName;
	private PreparedStatement insertNewCustomer;
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
					connection.prepareStatement("SELECT * FROM customer");

			// create query that selects entries with a specific last name
			selectCustomerByName = connection.prepareStatement(
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

	// select all of the customers in the database
	public List<Customer> getAllCustomers()
	{
		List<Customer> results = null;
		ResultSet resultSet = null;

		try
		{
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllCustomers.executeQuery();
			results = new ArrayList<Customer>();

			while (resultSet.next())
			{
				results.add(new Customer(
						resultSet.getInt("cID"),
						resultSet.getString("cNAME"),
						resultSet.getString("email"),
						resultSet.getString("phone"),
						resultSet.getInt("num_rooms")));

				// print for debuging <remove later>
				System.out.println(results.get(results.size() -1 ));
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


	// add an entry
	public int addCustomer(
			String cName, String email, String phone, String num_rooms)
	{
		int result = 0;

		// set parameters, then execute insertNewEmployee
		try
		{
			insertNewCustomer.setString(1, cName);
			insertNewCustomer.setString(2, email);
			insertNewCustomer.setString(3, phone);
			//insertNewCustomer.setString(4, num_rooms);

			// insert the new entry; returns # of rows updated
			result = insertNewCustomer.executeUpdate();
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

}