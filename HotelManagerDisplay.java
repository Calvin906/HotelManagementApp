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

    //Fields for GUI
    private JTable roomsTable;
    private JTable amenitiesTable;
    private JLabel roomsLabel;
    private JLabel amenitiesLabel;
    private JLabel nameLabel;
    private JLabel vipLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel checkoutLabel;
    private JButton roomsBookButton;
    private JButton addCustomerButton;
    private JButton addAmenitiesButton;
    private JButton payButton;
    private JScrollBar roomsScrollBar;
    private JScrollBar amenitiesScrollBar;
    private JTextField roomNumTextField;
    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
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
        Room room = new Room(001, "Suite", "This room has alot of space", 200.00);
        rooms.add(0, room);

        /***********************************/

        //ROOM PANEL START

        roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.PAGE_AXIS));


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

        customerPanel = new JPanel();
        customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.PAGE_AXIS));

        //Name Label
        nameLabel = new JLabel("Name: ");

        //Name TextField
        nameTextField = new JTextField();
        nameTextField.setMaximumSize(new Dimension(10,20));

        //Panel for Name and Name TextField
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        namePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        namePanel.add(nameLabel);
        namePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        namePanel.add(nameTextField);
        customerPanel.add(namePanel);

        //Vip Check Label
        vipLabel = new JLabel("VIP: ");

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
        emailTextField.setMaximumSize(new Dimension(10,20));

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
        emailTextField.setMaximumSize(new Dimension(10,20));

        //Phone Panel
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.LINE_AXIS));
        phonePanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        phonePanel.add(phoneLabel);
        phonePanel.add(Box.createRigidArea(new Dimension(10,0)));
        phonePanel.add(phoneTextField);
        customerPanel.add(phonePanel);

        //Add the button
        addCustomerButton = new JButton("Add");
        customerPanel.add(addCustomerButton);

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

        //Pay Button
        payButton = new JButton("Pay");
        billingPanel.add(payButton);


        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //TODO
            }
        });

        //TODO Not sure how we want to do the payment option

        //Payment TextField

        add(billingPanel);

        //TAB PANEL END

        /***********************************/

        //AMENITIES PANEL START
        amenitiesPanel = new JPanel();

        //JTable for Amenities
        amenitiesTable = new JTable(new AmenitiesTableModel());
        amenitiesTable.setFillsViewportHeight(true);
        amenitiesTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        amenitiesPanel.add(amenitiesTable.getTableHeader(), BorderLayout.NORTH);
        amenitiesPanel.add(amenitiesTable);

        
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
        private String[] amenityColumnName = {"Amenity #", };
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
                    value = rooms.get(rowIndex).getrID();
                    break;
                case (1):
                    value = rooms.get(rowIndex).getType();
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
