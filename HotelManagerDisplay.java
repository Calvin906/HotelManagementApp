import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * CS157A Group Project Fall 2016
 * Hotel Guest Management System
 * Alex Preston, Frank Mock, Joshua Urrea
 * This class Holds all of the needed components for the GUI.
 */
public class HotelManagerDisplay extends JFrame {
	
	// Table models used to populate JTables
	//private ResultSetTableModel tableModel;
	private RoomCustomerTableModel tableModel;
	private AmenityTableModel ammenityTableModel;

    //Panels for GUI
    private JPanel roomPanel;
    private JPanel customerPanel;
    private JPanel amenitiesPanel;
    private JPanel billingPanel;
    private JPanel checkoutPanel;
    private JPanel bookRoomPanel;
    private JPanel itemPanel;

    //Fields for GUI
    private JTable roomsBookTable;
    private JTable amenitiesAmenityTable;
    private JLabel itemAmenityLabel;
    private JLabel itemNameAmenityLabel;
    private JLabel itemPriceAmenityLabel;
    private JLabel roomsBookLabel;
    private JLabel roomsBookLabel2;
    private JLabel suitBookLabel;
    private JLabel basicBookLabel;
    private JLabel customerNameBookLabel;
    private JLabel customerMessageLabel;
    private JLabel cIDNameBookLabel;
    private JLabel customerEmailBookLabel;
    private JLabel customerCustomerBookLabel;
    private JLabel amountLabel;
    private JLabel bookRoomLabel;
    private JLabel customerLabel;
    private JLabel customerIDLabel;
    private JLabel cIDLabel;
    private JLabel roomIDLabel;
    private JLabel roomPriceLabel;
    private JLabel amenityPriceLabel;
    private JLabel ammenCIDLabel;
    private JLabel totalLabel;
    private JLabel roomPriceTotalLabel;
    private JLabel amenityPriceTotalLabel;
    private JLabel totalPriceLabel;
    private JLabel amenityLabel;
    private JLabel nameCustomerLabel;
    private JLabel vipCustomerLabel;
    private JLabel phoneCustomerLabel;
    private JLabel emailCustomerLabel;
    private JLabel checkoutLabel;
    private JLabel itemLabel;
    private JButton roomsBookButton;
    private JButton searchRoomButton;
    private JButton searchCustomerButton;
    private JButton addCustomerButton;
    private JButton updateCustomerButton;
    private JButton deleteCustomerButton;
    private JButton addAmenitiesButton;
    private JButton payButton;
    private JButton searchButton;
    private JButton createAmenityButton;
    private JButton searchAmenityButton;
    private JButton updateAmenityButton;
    private JButton deleteAmenityButton;
    private JButton occupiedButton;
    private JScrollBar roomsScrollBar;
    private JScrollBar amenitiesScrollBar;
    private JTextField nameBookTextField;
    private JTextField cIDNameBookTextField;
    private JTextField emailBookTextField;
    private JTextField roomNumBookTextField;
    private JTextField customerIDCheckoutTextField;
    private JTextField customerIDTextField;
    private JTextField roomIDCheckoutTextField;
    private JTextField nameCustomerTextField;
    private JTextField phoneCustomerTextField;
    private JTextField emailCustomerTextField;
    private JTextField itemAmenityTextField;
    private JTextField ammenCustomerIDTextField;
    private JTextField amountAmenityTextField;
    private JTextField addPriceAmenityTextField;
    private JTextField addItemAmenityTextField;
    private JCheckBox vipCustomerCheckbox;
    private JCheckBox suiteBookCheckbox;
    private JCheckBox basicBookCheckbox;


    //Customer var
    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Amenity> amenities;


    public HotelManagerDisplay() throws SQLException {
        super("Hotel Manager");

        // hotel queries holds all DB queries
        HotelQueries hotelQueries = new HotelQueries();
        
        // models for the DB connected JTables
        tableModel = new RoomCustomerTableModel();
        ammenityTableModel = new AmenityTableModel();

        rooms = new ArrayList<>();
        amenities = new ArrayList<>();

        /************************************************************************************/

        //ROOM PANEL START - (room and customer info table area)

        //Room Panel
        roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.PAGE_AXIS));

        //Book Room panel Label
        bookRoomPanel = new JPanel();
        bookRoomPanel.setLayout(new BoxLayout(bookRoomPanel, BoxLayout.LINE_AXIS));

        //Book Room label
        bookRoomLabel = new JLabel("Room/Customer Info");
        bookRoomLabel.setFont(new Font("Serif", Font.BOLD, 18));
        bookRoomPanel.add(bookRoomLabel);
        bookRoomPanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        roomPanel.add(bookRoomPanel);

        //Rooms Table
        roomsBookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomsBookTable);
        roomsBookTable.setFillsViewportHeight(true);
        roomsBookTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        roomPanel.add(roomsBookTable.getTableHeader(), BorderLayout.NORTH);
        roomPanel.add(scrollPane);
        

        //Another Room Label
        roomsBookLabel2 = new JLabel("Room:   ");
        roomsBookLabel2.setFont(new Font("Serif", Font.BOLD, 16));

        //Suite Label
        suitBookLabel = new JLabel("Suite: ");

        //Suite Checkbox
        suiteBookCheckbox = new JCheckBox();

        //Basic Label
        basicBookLabel = new JLabel("Basic: ");

        //Basic Checkbox
        basicBookCheckbox = new JCheckBox();

        //Rooms Label
        roomsBookLabel = new JLabel("Room #: ");

        //Rooms TextField
        roomNumBookTextField = new JTextField();
        roomNumBookTextField.setMaximumSize(new Dimension(55, 20));

        //Panel for the Button and textField and Label
        JPanel roomBookPanel = new JPanel();
        roomBookPanel.setLayout(new BoxLayout(roomBookPanel, BoxLayout.LINE_AXIS));
        roomBookPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        roomBookPanel.add(roomsBookLabel2);
        roomBookPanel.add(suitBookLabel);
        roomBookPanel.add(suiteBookCheckbox);
        roomBookPanel.add(basicBookLabel);
        roomBookPanel.add(basicBookCheckbox);
        roomBookPanel.add(roomsBookLabel);
        roomBookPanel.add(roomNumBookTextField);
        roomBookPanel.add(Box.createRigidArea(new Dimension(5, 0)));


        //Customer Label
        customerCustomerBookLabel = new JLabel("Customer: ");
        customerCustomerBookLabel.setFont(new Font("Serif", Font.BOLD, 16));

        //Name Label
        customerNameBookLabel = new JLabel("Name: ");

        //Name Text field
        nameBookTextField = new JTextField(20);
        nameBookTextField.setMaximumSize(new Dimension(55,20));
        
        //ID Label
        cIDNameBookLabel = new JLabel("cID: ");

        //ID Text field
        cIDNameBookTextField = new JTextField(8);
        cIDNameBookTextField.setMaximumSize(new Dimension(55,20));

        //Email Customer Label
        customerEmailBookLabel = new JLabel("Email: ");

        //Email Text field
        emailBookTextField = new JTextField(25);
        emailBookTextField.setMaximumSize(new Dimension(55,20));


        JPanel customerBookPanel = new JPanel();
        customerBookPanel.setLayout(new BoxLayout(customerBookPanel, BoxLayout.LINE_AXIS));
        customerBookPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        customerBookPanel.add(customerCustomerBookLabel);
        
        customerBookPanel.add(cIDNameBookLabel);
        customerBookPanel.add(cIDNameBookTextField);
        customerBookPanel.add(new JLabel("   ")); //spacer label
        customerBookPanel.add(customerNameBookLabel);
        customerBookPanel.add(nameBookTextField);
        customerBookPanel.add(new JLabel("   ")); //spacer label
        customerBookPanel.add(customerEmailBookLabel);
        customerBookPanel.add(emailBookTextField);
        
        customerBookPanel.add(Box.createRigidArea(new Dimension(5, 0)));

        //Rooms Book Button
        roomsBookButton = new JButton("Book");
        roomsBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Check that a room# and customer# were entered
            	String roomNum = roomNumBookTextField.getText();
            	String custNum = cIDNameBookTextField.getText();
            	
            	// If user entered room# and cust#
            	if(!roomNum.isEmpty() && !custNum.isEmpty())
            	{
            		try
            		{
            			// Check that they entered numbers
            			Integer.parseInt(roomNum);
            			Integer.parseInt(custNum);
            			
            			// Call method to execute the query
            			tableModel.setQueryBookRoom(custNum, roomNum);
            			
                    	/*
                    	 * Update the room/customer table in the GUI to
                    	 * reflect the model change
                    	 */
                    	
                    	try {
                    		tableModel.setQueryGetOccupiedRoomInfo(roomNum);
        				} catch (IllegalStateException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				} catch (SQLException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
            		}
            		catch(NumberFormatException e1)
            		{
            			customerMessageLabel.setText("ROOM# & cID MUST BE INTEGER");
            			customerMessageLabel.setForeground(Color.RED);
            		} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else
            	{
            		// cId or room# textfield is blank. Print error message
        			customerMessageLabel.setText("ROOM# OR cID CAN NOT BE BLANK");
        			customerMessageLabel.setForeground(Color.RED);
            	}
            }
        });

        //Search for Room Button
        searchRoomButton = new JButton("Room");
        searchRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String roomNum = roomNumBookTextField.getText();
            	
            	if(roomNum.isEmpty())
            	{
            		// Clear user message label
            		customerMessageLabel.setText("          ");
            	
	            	try {
	            		tableModel.setQueryGetAllRooms();
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else
            	{
            		try
            		{
            			// Check that user entered a number
            			Integer.parseInt(roomNum);
            			
            			// Call method that will execute query
            			tableModel.setQueryGetRoomByNumber(roomNum);
            		}
            		catch(NumberFormatException e1){
            			customerMessageLabel.setText("ROOM # MUST BE AN INTEGER");
            			customerMessageLabel.setForeground(Color.RED);
            			
            		} catch (IllegalStateException e1) {
            			customerMessageLabel.setText("Database Error");
            			customerMessageLabel.setForeground(Color.RED);
						e1.printStackTrace();
					} catch (SQLException e1) {
            			customerMessageLabel.setText("Database Error");
            			customerMessageLabel.setForeground(Color.RED);
						e1.printStackTrace();
					}
            	}
            }
        });
        
        occupiedButton = new JButton("Occupied");
        occupiedButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
            	String roomNum = roomNumBookTextField.getText();
            	
            	if(roomNum.isEmpty())
            	{
            		// Clear user message label
            		customerMessageLabel.setText("          ");
            	
	            	try {
	            		tableModel.setQueryGetAllOccupied();
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else
            	{
            		try
            		{
            			// Check that user entered a number
            			Integer.parseInt(roomNum);
            			
            			// Call method that will execute query
            			tableModel.setQueryGetOccupiedRoomInfo(roomNum);
            		}
            		catch(NumberFormatException e1){
            			customerMessageLabel.setText("ROOM # MUST BE AN INTEGER");
            			customerMessageLabel.setForeground(Color.RED);
            			
            		} catch (IllegalStateException e1) {
            			customerMessageLabel.setText("Database Error");
            			customerMessageLabel.setForeground(Color.RED);
						e1.printStackTrace();
					} catch (SQLException e1) {
            			customerMessageLabel.setText("Database Error");
            			customerMessageLabel.setForeground(Color.RED);
						e1.printStackTrace();
					}
            	}
				
			}});

        
        
        //Search for Customer Button
        searchCustomerButton = new JButton("Customer");
        searchCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		tableModel.setQueryGetAllCustomers();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        JPanel buttonBookPanel = new JPanel();
        buttonBookPanel.setLayout(new BoxLayout(buttonBookPanel, BoxLayout.LINE_AXIS));
        buttonBookPanel.add(roomsBookButton);
        buttonBookPanel.add(new JLabel("   ")); //spacer label
        buttonBookPanel.add(searchRoomButton);
        buttonBookPanel.add(new JLabel("   ")); //spacer label
        buttonBookPanel.add(occupiedButton);
        buttonBookPanel.add(new JLabel("   ")); //spacer label
        buttonBookPanel.add(searchCustomerButton);

        roomPanel.add(new JLabel("   ")); //Spacer - spaces panels away from JTable
        roomPanel.add(roomBookPanel);
        roomPanel.add(customerBookPanel);
        roomPanel.add(buttonBookPanel);
        add(roomPanel);

        //ROOM PANEL END

        /******************************************************************************/

        //CUSTOMER PANEL START

        //Customer Panel
        customerPanel = new JPanel();
        customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.PAGE_AXIS));

        //Customer Label Panel
        JPanel customerTitlePanel = new JPanel();
        customerTitlePanel.setLayout( new BoxLayout(customerTitlePanel, BoxLayout.LINE_AXIS));

        //Customer title label
        customerLabel = new JLabel("Customer ");
        customerLabel.setFont(new Font("Serif", Font.BOLD, 18));
        customerTitlePanel.add(customerLabel);
        customerTitlePanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        customerPanel.add(customerTitlePanel);

        //cID Label
        cIDLabel = new JLabel("cID: ");

        //cID TextField
        customerIDTextField = new JTextField();
        customerIDTextField.setMaximumSize(new Dimension(100,20));
        
        //Panel for cID and cID TextField
        JPanel cIDPanel = new JPanel();
        cIDPanel.setLayout(new BoxLayout(cIDPanel, BoxLayout.LINE_AXIS));
        cIDPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        cIDPanel.add(cIDLabel);
        cIDPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        cIDPanel.add(customerIDTextField);
        customerPanel.add(cIDPanel);
        
        //Name Label
        nameCustomerLabel = new JLabel("Name: ");

        //Name TextField
        nameCustomerTextField = new JTextField();
        nameCustomerTextField.setMaximumSize(new Dimension(100,20));
        

        //Panel for Name and Name TextField
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        namePanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        namePanel.add(nameCustomerLabel);
        namePanel.add(Box.createRigidArea(new Dimension(5, 0)));
        namePanel.add(nameCustomerTextField);
        customerPanel.add(namePanel);

        //Email Label
        emailCustomerLabel = new JLabel("Email: ");

        //Email TextField
        emailCustomerTextField = new JTextField();
        emailCustomerTextField.setMaximumSize(new Dimension(100,20));

        //Email Panel
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.LINE_AXIS));
        emailPanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        emailPanel.add(emailCustomerLabel);
        emailPanel.add(Box.createRigidArea(new Dimension(5,0)));
        emailPanel.add(emailCustomerTextField);
        customerPanel.add(emailPanel);

        //Phone Label
        phoneCustomerLabel = new JLabel("Phone: ");

        //Phone TextField
        phoneCustomerTextField = new JTextField();
        phoneCustomerTextField.setMaximumSize(new Dimension(100,20));

        //Phone Panel
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.LINE_AXIS));
        phonePanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        phonePanel.add(phoneCustomerLabel);
        phonePanel.add(Box.createRigidArea(new Dimension(5,0)));
        phonePanel.add(phoneCustomerTextField);
        customerPanel.add(phonePanel);
        
        
        //Vip Check Label
        vipCustomerLabel = new JLabel("VIP:               ");

        //Vip Checkbox
        vipCustomerCheckbox = new JCheckBox();

        //Name Panel
        JPanel vipPanel = new JPanel();
        vipPanel.setLayout(new BoxLayout(vipPanel, BoxLayout.LINE_AXIS));
        vipPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        vipPanel.add(vipCustomerLabel);
        vipPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        vipPanel.add(vipCustomerCheckbox);
        customerPanel.add(vipPanel);
        
        

        //Panel for the Button to offset Centering issue
        JPanel customerButtonPanel = new JPanel();
        customerButtonPanel.setLayout(new BoxLayout(customerButtonPanel, BoxLayout.LINE_AXIS));

        //Add the button
        addCustomerButton = new JButton("Add");
        customerButtonPanel.add(addCustomerButton);
        customerPanel.add(customerButtonPanel);
        customerButtonPanel.add(new JLabel("   ")); //spacer label

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String name = nameCustomerTextField.getText();
            	String email = emailCustomerTextField.getText();
            	String phone = phoneCustomerTextField.getText();
            	
            	// Add customer to DB
            	Integer id = hotelQueries.addCustomer(name, email, phone);
            	
            	cIDNameBookTextField.setText(id.toString());
            	
            	customerMessageLabel.setText("SUCCESS. cID# " + id.toString());
            	
            	// Clear text fields on form
            	nameCustomerTextField.setText("");
            	emailCustomerTextField.setText("");
            	phoneCustomerTextField.setText("");
            	
            	/*
            	 * Update the room/customer table in the GUI to
            	 * reflect the model change
            	 */
            	
            	try {
            		tableModel.setQueryGetAllCustomers();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        
        
        //Update customer button
        updateCustomerButton = new JButton("Update");
        customerButtonPanel.add(updateCustomerButton);
        customerButtonPanel.add(new JLabel("   ")); //spacer label
        customerPanel.add(customerButtonPanel);

        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Get textfield strings
            	String cID = customerIDTextField.getText();
            	String name = nameCustomerTextField.getText();
            	String email = emailCustomerTextField.getText();
            	String phone = phoneCustomerTextField.getText();
            	
            	// If cId field is empty, stop update and inform user
            	if(cID.isEmpty())
            	{
            		System.err.println("Customer ID can not be empty");
            		return;
            	}
            	
            	//Update name, email and phone if all three are not empty
            	if(!name.isEmpty() && !email.isEmpty() && !phone.isEmpty())
            	{
                	try {
                		tableModel.setQueryUpdateCustNameEmailPhone(cID, name, email, phone);

    				} catch (IllegalStateException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                 // if name and email are not empty and phone is
            	}else if(!name.isEmpty() && !email.isEmpty() && phone.isEmpty())
            	{
                	try {
                		tableModel.setQueryUpdateCustNameEmail(cID, name, email);

    				} catch (IllegalStateException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                 //if name and phone are not empty and email is
            	}else if(!name.isEmpty() && email.isEmpty() && !phone.isEmpty())
            	{
                	try {
                		tableModel.setQueryUpdateCustNamePhone(cID, name, phone);

    				} catch (IllegalStateException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                 // Update if email and phone are not empty but name is
            	}else if(name.isEmpty() && !email.isEmpty() && !phone.isEmpty())
            	{
                	try {
                		tableModel.setQueryUpdateCustEmailPhone(cID, email, phone);

    				} catch (IllegalStateException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                 // Update name only
            	}else if(!name.isEmpty() && email.isEmpty() && phone.isEmpty())
            	{
                	try {
                		tableModel.setQueryUpdateCustName(cID, name);

    				} catch (IllegalStateException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                 // Update email only
            	}else if(name.isEmpty() && !email.isEmpty() && phone.isEmpty())
            	{
                	try {
                		tableModel.setQueryUpdateCustEmail(cID, email);

    				} catch (IllegalStateException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                 // Update only the phone
            	}else if(name.isEmpty() && email.isEmpty() && !phone.isEmpty())
            	{
                	try {
                		tableModel.setQueryUpdateCustPhone(cID, phone);

    				} catch (IllegalStateException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            	}
            	
            	
            	/*
            	 * Update the room/customer table in the GUI to
            	 * reflect the model update
            	 */
            	
            	try {
            		tableModel.setQueryGetAllCustomers();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            	// Update the user message
            	customerMessageLabel.setText("UPDATE SUCCESSFUL");
            	
            	// Clear text fields on form
            	customerIDTextField.setText("");
            	nameCustomerTextField.setText("");
            	emailCustomerTextField.setText("");
            	phoneCustomerTextField.setText("");
            }
        });
        
        //Delete customer button
        deleteCustomerButton = new JButton("Delete");
        customerButtonPanel.add(deleteCustomerButton);
        customerPanel.add(customerButtonPanel);

        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String cID = customerIDTextField.getText();
            	if(cID.isEmpty())
            	{
            		System.err.println("cID can not be empty");
            		return;
            	}
            	
            	try {
            		tableModel.setQueryDeleteCustomer(cID);
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	customerMessageLabel.setText("SUCCESSFUL DELETION");
            	// Clear text fields on form
            	nameCustomerTextField.setText("");
            	emailCustomerTextField.setText("");
            	phoneCustomerTextField.setText("");
            	
            	/*
            	 * Update the room/customer table in the GUI to
            	 * reflect the model change
            	 */
            	
            	try {
            		tableModel.setQueryGetAllCustomers();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        customerMessageLabel = new JLabel("GUEST MANAGEMENT SYSTEM");
        customerMessageLabel.setFont(new Font("Serif", Font.BOLD, 12));
        JLabel spacer = new JLabel("    ");
        customerPanel.add(spacer);
        customerPanel.add(customerMessageLabel);
        
        add(customerPanel);

        //CUSTOMER PANEL END

        /********************************************************************/

        //TAB/INVOICE PANEL START
        billingPanel = new JPanel();
        billingPanel.setLayout(new BoxLayout(billingPanel, BoxLayout.PAGE_AXIS));

        checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.LINE_AXIS));

        //CheckoutLabel
        checkoutLabel = new JLabel("Checkout");
        checkoutLabel.setFont(new Font("Serif", Font.BOLD, 18));
        checkoutPanel.add(checkoutLabel);
        checkoutPanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        billingPanel.add(checkoutPanel);


        //Customer Fields Panel
        JPanel customerEnterPanels = new JPanel();
        customerEnterPanels.setLayout(new BoxLayout(customerEnterPanels, BoxLayout.LINE_AXIS));

        //Customer ID Label
        customerIDLabel = new JLabel("Enter Customer ID: ");
        customerEnterPanels.add(customerIDLabel);

        //Customer ID textField
        customerIDCheckoutTextField = new JTextField();
        customerIDCheckoutTextField.setMaximumSize(new Dimension(50,20));
        customerEnterPanels.add(customerIDCheckoutTextField);
        billingPanel.add(customerEnterPanels);

        //Room Fields Panel
        JPanel roomEnterPanels = new JPanel();
        roomEnterPanels.setLayout(new BoxLayout(roomEnterPanels, BoxLayout.LINE_AXIS));

        //RoomId Label
        roomIDLabel = new JLabel("Enter Room ID: ");
        roomEnterPanels.add(roomIDLabel);

        //Room ID textField
        roomIDCheckoutTextField = new JTextField();
        roomIDCheckoutTextField.setMaximumSize(new Dimension(50,20));
        roomEnterPanels.add(roomIDCheckoutTextField);
        billingPanel.add(roomEnterPanels);

        //SearchButton Panel
        JPanel searchButtonPanel = new JPanel();
        searchButtonPanel.setLayout(new BoxLayout(searchButtonPanel, BoxLayout.LINE_AXIS));

        //Search Button
        searchButton = new JButton("Search");
        searchButtonPanel.add(searchButton);
        billingPanel.add(searchButtonPanel);

        //Room Price Panel
        JPanel roomPricePanel = new JPanel();
        roomPricePanel.setLayout(new BoxLayout(roomPricePanel, BoxLayout.LINE_AXIS));

        //Room Price Label
        roomPriceLabel = new JLabel("Room Price: ");
        roomPricePanel.add(roomPriceLabel);

        //Room total Price Label
        roomPriceTotalLabel = new JLabel("$0.00");
        roomPricePanel.add(roomPriceTotalLabel);
        billingPanel.add(roomPricePanel);

        //Amenity Panel
        JPanel amenityPricePanel = new JPanel();
        amenityPricePanel.setLayout(new BoxLayout(amenityPricePanel, BoxLayout.LINE_AXIS));

        //Amenity Price Label
        amenityPriceLabel = new JLabel("Amenity Price: ");
        amenityPricePanel.add(amenityPriceLabel);

        //Amenity total price Label
        amenityPriceTotalLabel = new JLabel("$0.00");
        amenityPricePanel.add(amenityPriceTotalLabel);
        billingPanel.add(amenityPricePanel);

        //Total Price Panel
        JPanel totalPricePanel = new JPanel();
        totalPricePanel.setLayout(new BoxLayout(totalPricePanel, BoxLayout.LINE_AXIS));

        //Total Label
        totalLabel = new JLabel("Total: ");
        totalPricePanel.add(totalLabel);

        //Total price Label
        totalPriceLabel = new JLabel("$0.00");
        totalPricePanel.add(totalPriceLabel);
        billingPanel.add(totalPricePanel);

        //Pay Button Panel
        JPanel payButtonPanel = new JPanel();
        payButtonPanel.setLayout(new BoxLayout(payButtonPanel, BoxLayout.LINE_AXIS));

        //Pay Button
        payButton = new JButton("Pay");
        payButtonPanel.add(payButton);
        billingPanel.add(payButtonPanel);

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //TODO
            }
        });


        add(billingPanel);

        //TAB PANEL END

        /**************************************************************************/

        //AMENITIES PANEL START
        amenitiesPanel = new JPanel();
        amenitiesPanel.setLayout(new BoxLayout(amenitiesPanel, BoxLayout.PAGE_AXIS));

        //Amenity Panel
        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.LINE_AXIS));

        //Amenity title
        amenityLabel = new JLabel("Charge Item to Customer ");
        amenityLabel.setFont(new Font("Serif", Font.BOLD, 18));
        itemPanel.add(amenityLabel);
        itemPanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        amenitiesPanel.add(itemPanel);

        //Item Label
        itemLabel = new JLabel("Item #: ");

        //Item TextField
        itemAmenityTextField = new JTextField();
        itemAmenityTextField.setMaximumSize(new Dimension(50,20));
        
        //Ammenity cID Label
        ammenCIDLabel = new JLabel("cID #: ");

        //Ammenity cID TextField
        ammenCustomerIDTextField = new JTextField();
        ammenCustomerIDTextField.setMaximumSize(new Dimension(50,20));

        //Amount Label
        amountLabel = new JLabel("Amount: ");

        //Amount TextField
        amountAmenityTextField = new JTextField();
        amountAmenityTextField.setMaximumSize(new Dimension(35,20));

        //Amenity add Button
        addAmenitiesButton = new JButton("Add");
        addAmenitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        //Panel for all of actions on Amenity Panel
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.LINE_AXIS));
        itemPanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        itemPanel.add(itemLabel);
        itemPanel.add(itemAmenityTextField);
        itemPanel.add(ammenCIDLabel);
        itemPanel.add(ammenCustomerIDTextField);
        itemPanel.add(amountLabel);
        itemPanel.add(amountAmenityTextField);
        itemPanel.add(addAmenitiesButton);

        amenitiesPanel.add(itemPanel);

        //JLabel for Amenity Items
        itemAmenityLabel = new JLabel("Amenity Items ");
        itemAmenityLabel.setFont(new Font("Serif", Font.BOLD, 18));

        //JPanel for Amenity Items table title
        JPanel amenityTablePanel = new JPanel();
        amenityTablePanel.setLayout(new BoxLayout(amenityTablePanel, BoxLayout.LINE_AXIS));
        amenityTablePanel.add(itemAmenityLabel);

        amenitiesPanel.add(amenityTablePanel);

        //JTable for Amenities
        amenitiesAmenityTable = new JTable(ammenityTableModel);
        JScrollPane scrollPaneAmmen = new JScrollPane(amenitiesAmenityTable);
        amenitiesAmenityTable.setFillsViewportHeight(true);
        amenitiesAmenityTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        amenitiesPanel.add(amenitiesAmenityTable.getTableHeader(), BorderLayout.NORTH);
        amenitiesPanel.add(scrollPaneAmmen);


        //Item Name Label for add
        itemNameAmenityLabel = new JLabel("Item Name: ");

        //Item TextField Name for add
        addItemAmenityTextField = new JTextField();
        addItemAmenityTextField.setMaximumSize(new Dimension(70,20));

        //Item Price Label for add
        itemPriceAmenityLabel = new JLabel("Price: ");

        //Item TextField for price
        addPriceAmenityTextField = new JTextField();
        addPriceAmenityTextField.setMaximumSize(new Dimension(55,20));

        //add Items panel
        JPanel addItemsPanel = new JPanel();
        addItemsPanel.setLayout(new BoxLayout(addItemsPanel, BoxLayout.LINE_AXIS));
        addItemsPanel.add(itemNameAmenityLabel);
        addItemsPanel.add(addItemAmenityTextField);
        addItemsPanel.add(itemPriceAmenityLabel);
        addItemsPanel.add(addPriceAmenityTextField);

        amenitiesPanel.add(addItemsPanel);

        //Search Button
        searchAmenityButton = new JButton("Search");
        searchAmenityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        //Add Button
        createAmenityButton = new JButton("Create");
        createAmenityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        //Update Button
        updateAmenityButton = new JButton("Update");
        updateAmenityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        //Delete Button
        deleteAmenityButton = new JButton("Delete");
        deleteAmenityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        //Button Panel for adding
        JPanel addButtonsAmenityPanel = new JPanel();
        addButtonsAmenityPanel.setLayout(new BoxLayout(addButtonsAmenityPanel, BoxLayout.LINE_AXIS));
        addButtonsAmenityPanel.add(searchAmenityButton);
        addButtonsAmenityPanel.add(createAmenityButton);
        addButtonsAmenityPanel.add(updateAmenityButton);
        addButtonsAmenityPanel.add(deleteAmenityButton);
        amenitiesPanel.add(new JLabel(""));
        amenitiesPanel.add(addButtonsAmenityPanel);

        add(amenitiesPanel);

        //AMENITIES PANEL END

        /***********************************/


        setLayout(new GridLayout(0, 2));
        setSize(900, 800);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }


    /**
     * Creates the Display
     * @param args
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
        new HotelManagerDisplay();
    }
}
