import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Alex Preston on 11/12/16.
 */
public class HotelManagerDisplay extends JFrame {

    //Fields for GUI
    private JTable roomsTable;
    private JTable amenitiesTable;
    private JLabel roomsLabel;
    private JLabel amenitiesLabel;
    private JLabel nameLabel;
    private JLabel vipLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel invoiceLabel;
    private JLabel checkoutLabel;
    private JButton bookButton;
    private JButton addCustomerButton;
    private JButton addAmenitiesButton;
    private JButton checkoutButton;
    private JScrollBar roomsScrollBar;
    private JScrollBar amenitiesScrollBar;
    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JCheckBox vipCheckbox;

    //Room var
    private ArrayList<Room> rooms;

    //Customer var
    private ArrayList<Customer> customers;

    //Columns for Rooms table
    private String[] roomColumnNames = {"Room Number", "Type" , "Description ", "Price"};


    public HotelManagerDisplay() {
        super("Hotel Manager");

        customers = new ArrayList<>();
        rooms = new ArrayList<>();







    }

    public static void main(String[] args) {
        new HotelManagerDisplay();
    }
}
