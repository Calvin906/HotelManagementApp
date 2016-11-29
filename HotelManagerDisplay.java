import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Alex Preston on 11/12/16.
 * This class Holds all of the needed components for the GUI.
 */
public class HotelManagerDisplay extends JFrame {

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
    private JLabel allRBookLabel;
    private JLabel suitBookLabel;
    private JLabel basicBookLabel;
    private JLabel customerNameBookLabel;
    private JLabel customerEmailBookLabel;
    private JLabel customerCustomerBookLabel;
    private JLabel allCBookLabel;
    private JLabel amountLabel;
    private JLabel bookRoomLabel;
    private JLabel customerLabel;
    private JLabel customerIDLabel;
    private JLabel roomIDLabel;
    private JLabel roomPriceLabel;
    private JLabel amenityPriceLabel;
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
    private JButton searchBookButton;
    private JButton addCustomerButton;
    private JButton addAmenitiesButton;
    private JButton payButton;
    private JButton searchButton;
    private JButton createAmenityButton;
    private JButton searchAmenityButton;
    private JButton updateAmenityButton;
    private JButton deleteAmenityButton;
    private JScrollBar roomsScrollBar;
    private JScrollBar amenitiesScrollBar;
    private JTextField nameBookTextField;
    private JTextField emailBookTextField;
    private JTextField roomNumBookTextField;
    private JTextField customerIDCheckoutTextField;
    private JTextField roomIDCheckoutTextField;
    private JTextField nameCustomerTextField;
    private JTextField phoneCustomerTextField;
    private JTextField emailCustomerTextField;
    private JTextField itemAmenityTextField;
    private JTextField amountAmenityTextField;
    private JTextField addPriceAmenityTextField;
    private JTextField addItemAmenityTextField;
    private JCheckBox vipCustomerCheckbox;
    private JCheckBox allRoomBookCheckbox;
    private JCheckBox allCustomerBookCheckbox;
    private JCheckBox suiteBookCheckbox;
    private JCheckBox basicBookCheckbox;


    //Customer var
    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Amenity> amenities;


    public HotelManagerDisplay() {
        super("Hotel Manager");

        HotelQueries hotelQueries = new HotelQueries();

        rooms = new ArrayList<>();
        amenities = new ArrayList<>();

        /***********************************/

        //ROOM PANEL START

        //Room Panel
        roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.PAGE_AXIS));

        //Book Room panel Label
        bookRoomPanel = new JPanel();
        bookRoomPanel.setLayout(new BoxLayout(bookRoomPanel, BoxLayout.LINE_AXIS));

        //Book Room label
        bookRoomLabel = new JLabel("Room/Customer Info");
        bookRoomPanel.add(bookRoomLabel);
        bookRoomPanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        roomPanel.add(bookRoomPanel);

        //Rooms Table
        roomsBookTable = new JTable(new RoomsTableModel());
        roomsBookTable.setFillsViewportHeight(true);
        roomsBookTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        roomPanel.add(roomsBookTable.getTableHeader(), BorderLayout.NORTH);
        roomPanel.add(roomsBookTable);

        //Another Room Label
        roomsBookLabel2 = new JLabel("Room:   ");

        //All Label
        allRBookLabel = new JLabel("All");

        //All Room checkbox
        allRoomBookCheckbox = new JCheckBox();

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
        roomBookPanel.add(allRBookLabel);
        roomBookPanel.add(allRoomBookCheckbox);
        roomBookPanel.add(suitBookLabel);
        roomBookPanel.add(suiteBookCheckbox);
        roomBookPanel.add(basicBookLabel);
        roomBookPanel.add(basicBookCheckbox);
        roomBookPanel.add(roomsBookLabel);
        roomBookPanel.add(roomNumBookTextField);
        roomBookPanel.add(Box.createRigidArea(new Dimension(5, 0)));


        //Customer Label
        customerCustomerBookLabel = new JLabel("Customer: ");

        //All Customer Label
        allCBookLabel = new JLabel("All: ");

        //All Customer Checkbox
        allCustomerBookCheckbox = new JCheckBox();

        //Name Label
        customerNameBookLabel = new JLabel("Name: ");

        //Name Text field
        nameBookTextField = new JTextField();
        nameBookTextField.setMaximumSize(new Dimension(55,20));

        //Email Customer Label
        customerEmailBookLabel = new JLabel("Email: ");

        //Email Text field
        emailBookTextField = new JTextField();
        emailBookTextField.setMaximumSize(new Dimension(55,20));


        JPanel customerBookPanel = new JPanel();
        customerBookPanel.setLayout(new BoxLayout(customerBookPanel, BoxLayout.LINE_AXIS));
        customerBookPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        customerBookPanel.add(customerCustomerBookLabel);
        customerBookPanel.add(allCBookLabel);
        customerBookPanel.add(allCustomerBookCheckbox);
        customerBookPanel.add(customerNameBookLabel);
        customerBookPanel.add(nameBookTextField);
        customerBookPanel.add(customerEmailBookLabel);
        customerBookPanel.add(emailBookTextField);
        customerBookPanel.add(Box.createRigidArea(new Dimension(5, 0)));

        //Rooms Book Button
        roomsBookButton = new JButton("Book");
        roomsBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        //Search Book Button
        searchBookButton = new JButton("Search");
        searchBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        JPanel buttonBookPanel = new JPanel();
        buttonBookPanel.setLayout(new BoxLayout(buttonBookPanel, BoxLayout.LINE_AXIS));
        buttonBookPanel.add(roomsBookButton);
        buttonBookPanel.add(searchBookButton);

        roomPanel.add(roomBookPanel);
        roomPanel.add(customerBookPanel);
        roomPanel.add(buttonBookPanel);
        add(roomPanel);

        //ROOM PANEL END

        /***********************************/

        //CUSTOMER PANEL START

        //Customer Panel
        customerPanel = new JPanel();
        customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.PAGE_AXIS));

        //Customer Label Panel
        JPanel customerTitlePanel = new JPanel();
        customerTitlePanel.setLayout( new BoxLayout(customerTitlePanel, BoxLayout.LINE_AXIS));

        //Customer title label
        customerLabel = new JLabel("Add Customer ");
        customerTitlePanel.add(customerLabel);
        customerTitlePanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        customerPanel.add(customerTitlePanel);

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

        //Panel for the Button to offset Centering issue
        JPanel customerButtonPanel = new JPanel();
        customerButtonPanel.setLayout(new BoxLayout(customerButtonPanel, BoxLayout.LINE_AXIS));

        //Add the button
        addCustomerButton = new JButton("Add");
        customerButtonPanel.add(addCustomerButton);
        customerPanel.add(customerButtonPanel);

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });


        add(customerPanel);

        //CUSTOMER PANEL END

        /***********************************/

        //TAB PANEL START
        billingPanel = new JPanel();
        billingPanel.setLayout(new BoxLayout(billingPanel, BoxLayout.PAGE_AXIS));

        checkoutPanel = new JPanel();
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.LINE_AXIS));

        //CheckoutLabel
        checkoutLabel = new JLabel("Checkout");
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

        /***********************************/

        //AMENITIES PANEL START
        amenitiesPanel = new JPanel();
        amenitiesPanel.setLayout(new BoxLayout(amenitiesPanel, BoxLayout.PAGE_AXIS));

        //Amenity Panel
        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.LINE_AXIS));

        //Amenity title
        amenityLabel = new JLabel("Add Item ");
        itemPanel.add(amenityLabel);
        itemPanel.setBorder(BorderFactory.createEmptyBorder(0,5,5,5));
        amenitiesPanel.add(itemPanel);

        //Item Label
        itemLabel = new JLabel("Item #: ");

        //Item TextField
        itemAmenityTextField = new JTextField();
        itemAmenityTextField.setMaximumSize(new Dimension(50,20));

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
        itemPanel.add(amountLabel);
        itemPanel.add(amountAmenityTextField);
        itemPanel.add(addAmenitiesButton);

        amenitiesPanel.add(itemPanel);

        //JLabel for Amenity Items
        itemAmenityLabel = new JLabel("Amenity Items ");

        //JPanel for Amenity Items table title
        JPanel amenityTablePanel = new JPanel();
        amenityTablePanel.setLayout(new BoxLayout(amenityTablePanel, BoxLayout.LINE_AXIS));
        amenityTablePanel.add(itemAmenityLabel);

        amenitiesPanel.add(amenityTablePanel);

        //JTable for Amenities
        amenitiesAmenityTable = new JTable(new AmenitiesTableModel());
        amenitiesAmenityTable.setFillsViewportHeight(true);
        amenitiesAmenityTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        amenitiesPanel.add(amenitiesAmenityTable.getTableHeader(), BorderLayout.NORTH);
        amenitiesPanel.add(amenitiesAmenityTable);


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

        amenitiesPanel.add(addButtonsAmenityPanel);

        add(amenitiesPanel);

        //AMENITIES PANEL END

        /***********************************/


        setLayout(new GridLayout(0, 2));
        setSize(700, 600);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    /**
     * Class that allows me to implement a Custom Table model instead of the default.
     */
    class AmenitiesTableModel extends AbstractTableModel {
        private String[] amenityColumnName = {"Amenity # ", "Item ", "Price " };
        @Override
        public int getRowCount() {
            return amenities.size();
        }

        @Override
        public int getColumnCount() {
            return amenityColumnName.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return amenityColumnName[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            switch (columnIndex) {
                case (0):
                    value = amenities.get(rowIndex).getaID();
                    break;
                case(1):
                    value = amenities.get(rowIndex).getDescription();
                    break;
                case(2):
                    value = amenities.get(rowIndex).getPrice();
                    break;
            }
            return value;
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    }

    /**
     *
     * Class that allows me to implement my own table model
     */
    class RoomsTableModel extends AbstractTableModel {

        //Room var
        private String[] roomColumnNames = {"Room #", "Type", "Price", "Description"};

        @Override
        public int getRowCount() {
            return rooms.size();
        }

        @Override
        public String getColumnName(int columnIndex) {
            return roomColumnNames[columnIndex];
        }

        @Override
        public int getColumnCount() {
            return roomColumnNames.length;
        }


        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            switch (columnIndex) {

                case (0):
                    value = rooms.get(rowIndex).getRoomID();
                    break;
                case (1):
                    value = rooms.get(rowIndex).getRoomType();
                    break;
                case (2):
                    value = rooms.get(rowIndex).getPrice();
                    break;
                case (3):
                    value = rooms.get(rowIndex).getDescription();
                    break;
            }
            return value;
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    }


    /**
     * Creates the Display
     * @param args
     */
    public static void main(String[] args) {
        new HotelManagerDisplay();
    }
}
