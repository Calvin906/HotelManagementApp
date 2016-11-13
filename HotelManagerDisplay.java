import javax.swing.*;
import javax.swing.table.AbstractTableModel;
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


    //Customer var
    private ArrayList<Customer> customers;

    //Columns for Rooms table
    private String[] roomColumnNames = {"Room Number", "Type" , "Description ", "Price"};


    public HotelManagerDisplay() {
        super("Hotel Manager");

        customers = new ArrayList<>();







    }

    class RoomsTableModel extends AbstractTableModel {

        //Room var
        private ArrayList<Room> rooms = new ArrayList<>();
        private String[] roomColumnNames = {"Room Number", "Type", "Description", "Price"};

        @Override
        public int getRowCount() {
            return rooms.size();
        }

        @Override
        public int getColumnCount() {
            return roomColumnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return rooms.get(rowIndex);
        }
    }

    public static void main(String[] args) {
        new HotelManagerDisplay();
    }
}
