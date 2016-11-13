import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex Preston on 11/12/16.
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
    private ArrayList<Room> rooms;


    public HotelManagerDisplay() {
        super("Hotel Manager");

        HotelQueries hotelQueries = new HotelQueries();

        roomPanel = new JPanel();

        rooms = new ArrayList<>();

        Room room = new Room(001,"Suite", "Big room", 200);
        rooms.add(0,room);


        //Rooms Table
        roomsTable = new JTable(new RoomsTableModel());
        roomsTable.setFillsViewportHeight(true);


        roomPanel.add(roomsTable.getTableHeader(), BorderLayout.NORTH);
        roomPanel.add(roomsTable);


        add(roomPanel);
        setLayout(new GridLayout(0,2));
        setSize(700, 600);
        setResizable(false);

        setVisible(true);
    }

    class RoomsTableModel extends AbstractTableModel {

        //Room var
        private String[] roomColumnNames = {"Room #", "Type", "Description", "Price"};

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

                case(0):
                    value = rooms.get(rowIndex).getrID();
                    break;
                case(1):
                    value = rooms.get(rowIndex).getType();
                    break;
                case(2):
                    value = rooms.get(rowIndex).getDescription();
                    break;
                case(3):
                    value = rooms.get(rowIndex).getPrice();
                    break;
            }
            return value;
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    }



    public static void main(String[] args) {
        new HotelManagerDisplay();
    }
}
