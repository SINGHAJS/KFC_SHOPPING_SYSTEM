package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 */
public class AdminView extends JFrame implements Observer {

    private JPanel backPanel = new JPanel();
    private JPanel headerPanel = new JPanel();

    private final JLabel backLabel = new JLabel("Back to LoginPage");
    private final JLabel adminTitle = new JLabel("Manager Tool");

    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane editorJCP = new JScrollPane();
    private JTable editor;

    public AdminView() {
        editor = new JTable() { //creates new table with cell editing disabled on first 3 columns to allow user to only edit checkbox
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                Boolean[] canEdit = new Boolean[]{false, false, false, true};
                return canEdit[colIndex];
            }

            @Override
            public Class getColumnClass(int column) { //enables column 4's checkbox and other columns correct data type
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        this.setSize(1200, 800); //frame setup
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        backPanel.setBackground(Color.WHITE);//backpanel setup
        backPanel.setBounds(0, 30, 1200, 770);
        backPanel.setLayout(null);

        getBackLabel().setFont(new Font("", Font.BOLD, 20));//go back label setup
        getBackLabel().setForeground(Color.WHITE);
        getBackLabel().setBounds(20, 0, 200, 30);

        adminTitle.setFont(new Font("", Font.BOLD, 20));//title for admin page setup
        adminTitle.setForeground(Color.RED);
        adminTitle.setBounds(550, 0, 200, 30);

        headerPanel.setBackground(Color.DARK_GRAY);//headerPanel setup
        headerPanel.setBounds(0, 0, 1200, 30);
        headerPanel.setLayout(null);

        headerPanel.add(adminTitle);//putting components in component 
        headerPanel.add(backLabel);
        this.add(backPanel); //putting component in frame
        this.add(headerPanel);
        this.setVisible(true);
    }

    public void fillTable(Vector<ProductItems> product) { //fill table fills the JTable with entities from DB but seperating the input object to its right cells
        model.setRowCount(0); //deletes previous table to allow updated table 
        model.setColumnCount(0);

        editor.setModel(model);
        editor.getTableHeader().setReorderingAllowed(false);
        editor.getTableHeader().setEnabled(false);

        model.addColumn("Category");    //state column headers
        model.addColumn("Item Name");
        model.addColumn("Item Price");
        model.addColumn("Available");

        Object rowData[] = new Object[4];   //filling data into each row
        for (int i = 0; i < product.size(); i++) {
            rowData[0] = product.get(i).getCategory();
            rowData[1] = product.get(i).getItemName();
            rowData[2] = product.get(i).getItemPrice();
            rowData[3] = product.get(i).isAvailable();
            model.addRow(rowData);
        }
        setPropertiesJCP();
        backPanel.add(editorJCP);
        backPanel.setVisible(true);
        this.add(backPanel);
        this.revalidate();
        this.repaint();

    }
    public void setPropertiesJCP(){
        editor.getColumnModel().getColumn(0).setCellEditor(null); //display properties 
        editor.setAutoCreateRowSorter(true);
        editor.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        editor.setForeground(Color.WHITE);
        editor.setBackground(Color.DARK_GRAY);
        editor.setSelectionBackground(Color.WHITE);
        editor.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        editorJCP.setViewportView(this.editor); //Scrollpane to show the table and allow scroll
        editorJCP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        editorJCP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        editorJCP.setBounds(50, 5, 1100, 650);
    }

    public void addListSelectionListener(ListSelectionListener selectionListener) { //adds listener to the table
        editor.getSelectionModel().addListSelectionListener(selectionListener);
    }

    @Override
    public void update(Observable o, Object arg) { //updates table view
        AdminData data = (AdminData) arg;
        if (!data.allItems.isEmpty()) {
            fillTable(data.allItems);
        }

    }

    //getters
    public JLabel getBackLabel() {
        return backLabel;
    }

    public JTable getEditor() {
        return editor;
    }
}
