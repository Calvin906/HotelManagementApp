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
    private JTable roomsTable;
    private JTable amenitiesTable;
    private JLabel roomsLabel;
    private JLabel amountLabel;
    private JLabel bookRoomLabel;
    private JLabel customerLabel;
    private JLabel customerIDLabel;
    private JLabel roomPriceLabel;
    private JLabel amenityPriceLabel;
    private JLabel totalLabel;
    private JLabel roomPriceTotalLabel;
    private JLabel amenityPriceTotalLabel;
    private JLabel totalPriceLabel;
    private JLabel amenityLabel;
    private JLabel nameLabel;
    private JLabel vipLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel checkoutLabel;
    private JLabel itemLabel;
    private JButton roomsBookButton;
    private JButton addCustomerButton;
    private JButton addAmenitiesButton;
    private JButton payButton;
    private JButton searchButton;
    private JScrollBar roomsScrollBar;
    private JScrollBar amenitiesScrollBar;
    private JTextField roomNumTextField;
    private JTextField customerIDTextField;
    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JTextField itemTextField;
    private JTextField amountTextField;
    private JCheckBox vipCheckbox;


    //Customer var
    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;
    private ArrayList<Amenity> amenities;


    public HotelManagerDisplay() {
        super("Hotel Manager");

        HotelQueries hotelQueries = new HotelQueries();


        rooms = new ArrayList<>();
        amenities = new ArrayList<>();

        //Test

        /***********************************/

        //ROOM PANEL START

        //Room Panel
        roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.PAGE_AXIS));

        //Book Room panel Label
        bookRoomPanel = new JPanel();
        bookRoomPanel.setLayout(new BoxLayout(bookRoomPanel, BoxLayout.LINE_AXIS));

        //Book Room label
        bookRoomLabel = new JLabel("Book a Room");
        bookRoomPanel.add(bookRoomLabel);
        bookRoomPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        roomPanel.add(bookRoomPanel);

        //Rooms Table
        roomsTable = new JTable(new RoomsTableModel());
        roomsTable.setFillsViewportHeight(true);
        roomsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        roomPanel.add(roomsTable.getTableHeader(), BorderLayout.NORTH);
        roomPanel.add(roomsTable);

        //Rooms Label
        roomsLabel = new JLabel("Room #: ");

        //Rooms TextField
        Dimension roomTextFieldDimension = new Dimension(80, 20);
        roomNumTextField = new JTextField();
        roomNumTextField.setMaximumSize(roomTextFieldDimension);
        //roomPanel.add(roomNumTextField);


        //Rooms Book Button
        roomsBookButton = new JButton("Book");
        roomsBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });


        //Panel for the Button and textField and Label
        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.LINE_AXIS));
        bookPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        bookPanel.add(roomsLabel);
        bookPanel.add(roomNumTextField);
        bookPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bookPanel.add(roomsBookButton);

        roomPanel.add(bookPanel);
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
        customerTitlePanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        customerPanel.add(customerTitlePanel);

        //Name Label
        nameLabel = new JLabel("Name: ");

        //Name TextField
        nameTextField = new JTextField();
        nameTextField.setMaximumSize(new Dimension(100,20));

        //Panel for Name and Name TextField
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        namePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        namePanel.add(nameLabel);
        namePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        namePanel.add(nameTextField);
        customerPanel.add(namePanel);

        //Vip Check Label
        vipLabel = new JLabel("VIP:               ");

        //Vip Checkbox
        vipCheckbox = new JCheckBox();

        //Name Panel
        JPanel vipPanel = new JPanel();
        vipPanel.setLayout(new BoxLayout(vipPanel, BoxLayout.LINE_AXIS));
        vipPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        vipPanel.add(vipLabel);
        vipPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        vipPanel.add(vipCheckbox);
        customerPanel.add(vipPanel);

        //Email Label
        emailLabel = new JLabel("Email: ");

        //Email TextField
        emailTextField = new JTextField();
        emailTextField.setMaximumSize(new Dimension(100,20));

        //Email Panel
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.LINE_AXIS));
        emailPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        emailPanel.add(emailLabel);
        emailPanel.add(Box.createRigidArea(new Dimension(10,0)));
        emailPanel.add(emailTextField);
        customerPanel.add(emailPanel);

        //Phone Label
        phoneLabel = new JLabel("Phone: ");

        //Phone TextField
        phoneTextField = new JTextField();
        phoneTextField.setMaximumSize(new Dimension(100,20));

        //Phone Panel
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.LINE_AXIS));
        phonePanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        phonePanel.add(phoneLabel);
        phonePanel.add(Box.createRigidArea(new Dimension(10,0)));
        phonePanel.add(phoneTextField);
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
        checkoutPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        billingPanel.add(checkoutPanel);


        //Customer Fields Panel
        JPanel customerEnterPanels = new JPanel();
        customerEnterPanels.setLayout(new BoxLayout(customerEnterPanels, BoxLayout.LINE_AXIS));


        //Customer ID Label
        customerIDLabel = new JLabel("Enter Customer ID: ");
        customerEnterPanels.add(customerIDLabel);

        //Customer ID textField
        customerIDTextField = new JTextField();
        customerIDTextField.setMaximumSize(new Dimension(50,20));
        customerEnterPanels.add(customerIDTextField);
        billingPanel.add(customerEnterPanels);

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
        itemPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        amenitiesPanel.add(itemPanel);

        //JTable for Amenities
        amenitiesTable = new JTable(new AmenitiesTableModel());
        amenitiesTable.setFillsViewportHeight(true);
        amenitiesTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        amenitiesPanel.add(amenitiesTable.getTableHeader(), BorderLayout.NORTH);
        amenitiesPanel.add(amenitiesTable);


        //Item Label
        itemLabel = new JLabel("Item #: ");

        //Item TextField
        itemTextField = new JTextField();
        itemTextField.setMaximumSize(new Dimension(50,20));

        //Amount Label
        amountLabel = new JLabel("Amount: ");

        //Amount TextField
        amountTextField = new JTextField();
        amountTextField.setMaximumSize(new Dimension(35,20));

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
        itemPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        itemPanel.add(itemLabel);
        itemPanel.add(itemTextField);
        itemPanel.add(amountLabel);
        itemPanel.add(amountTextField);
        itemPanel.add(addAmenitiesButton);

        amenitiesPanel.add(itemPanel);

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
