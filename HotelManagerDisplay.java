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
    private JButton roomsBookButton;
    private JButton addCustomerButton;
    private JButton addAmenitiesButton;
    private JButton checkoutButton;
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


    public HotelManagerDisplay() {
        super("Hotel Manager");

        HotelQueries hotelQueries = new HotelQueries();


        rooms = new ArrayList<>();

        //Test
        Room room = new Room(001, "Suite", "This room has alot of space", 200.00);
        rooms.add(0, room);

        //ROOM PANEL START

        roomPanel = new JPanel();
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.PAGE_AXIS));


        //Rooms Table
        roomsTable = new JTable(new RoomsTableModel());
        roomsTable.setFillsViewportHeight(true);
        roomsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        roomPanel.add(roomsTable.getTableHeader(), BorderLayout.NORTH);
        roomPanel.add(roomsTable);


        //Rooms TextField
        Dimension roomTextFieldDimension = new Dimension(80, 20);
        roomNumTextField = new JTextField();
        roomNumTextField.setMaximumSize(roomTextFieldDimension);
        roomPanel.add(roomNumTextField);


        //Rooms Book Button
        roomsBookButton = new JButton();
        roomPanel.add(roomsBookButton);
        roomsBookButton.setText("Book");


        //Panel for the Button and textField
        JPanel selection = new JPanel();
        selection.setLayout(new BoxLayout(selection, BoxLayout.LINE_AXIS));
        selection.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        selection.add(roomNumTextField);
        selection.add(Box.createRigidArea(new Dimension(10, 0)));
        selection.add(roomsBookButton);

        roomPanel.add(selection);
        add(roomPanel);

        //ROOM PANEL END


        setLayout(new GridLayout(0, 2));
        setSize(700, 600);
        setResizable(false);

        setVisible(true);
    }

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


    public static void main(String[] args) {
        new HotelManagerDisplay();
    }
}
