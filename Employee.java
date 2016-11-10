
public class Employee {

	 private int employeeID;
	   private String firstName;
	   private String lastName;
	   private String email;
	   private String phoneNumber;

	   // constructor
	   public Employee()
	   {
	   } 

	   // constructor
	   public Employee(int employeeID, String firstName, String lastName, 
	      String email, String phoneNumber)
	   {
	      setEmployeeID(employeeID);
	      setFirstName(firstName);
	      setLastName(lastName);
	      setEmail(email);
	      setPhoneNumber(phoneNumber);
	   } 

	   // sets the employeeID
	   public void setEmployeeID(int employeeID)
	   {
	      this.employeeID = employeeID;
	   }

	   // returns the employeeID 
	   public int getEmployeeID()
	   {
	      return employeeID;
	   }
	   
	   // sets the firstName
	   public void setFirstName(String firstName)
	   {
	      this.firstName = firstName;
	   } 

	   // returns the first name 
	   public String getFirstName()
	   {
	      return firstName;
	   } 
	   
	   // sets the lastName
	   public void setLastName(String lastName)
	   {
	      this.lastName = lastName;
	   } 

	   // returns the last name 
	   public String getLastName()
	   {
	      return lastName;
	   }
	   
	   // sets the email address
	   public void setEmail(String email)
	   {
	      this.email = email;
	   }

	   // returns the email address
	   public String getEmail()
	   {
	      return email;
	   } 
	   
	   // sets the phone number
	   public void setPhoneNumber(String phoneNumber)
	   {
	      this.phoneNumber = phoneNumber;
	   }

	   // returns the phone number
	   public String getPhoneNumber()
	   {
	      return phoneNumber;
	   } 
	} // end class Employee

