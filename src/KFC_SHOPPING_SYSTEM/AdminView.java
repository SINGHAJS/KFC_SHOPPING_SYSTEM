package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author singh
 */
public class AdminView extends JFrame implements Observer {

    private JPanel background = new JPanel();
    private JPanel backPanel = new JPanel();
    private final JLabel backLabel = new JLabel("Back to LoginPage");
    private final JLabel editorTitle = new JLabel("Manager Tool");
    
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane editorJCP = new JScrollPane();
    private JTable editor;
    public AdminView(){
        editor = new JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                Boolean[] canEdit = new Boolean[]{false,false,false,true};
                return canEdit[colIndex];
            }
            @Override
    public Class getColumnClass(int column){
        switch(column){
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
         this.setSize(1200, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        background.setBackground(Color.WHITE);
        background.setBounds(0, 30, 1200, 770);
        background.setLayout(null);
        
        getBackLabel().setFont(new Font("", Font.BOLD, 20));
        getBackLabel().setForeground(Color.WHITE);
        getBackLabel().setBounds(20, 0, 200, 30);
        
        editorTitle.setFont(new Font("", Font.BOLD, 20));
        editorTitle.setForeground(Color.RED);
        editorTitle.setBounds(550, 0, 200, 30);

        backPanel.setBackground(Color.DARK_GRAY);
        backPanel.setBounds(0, 0, 1200, 30);
        backPanel.setLayout(null);
        
        backPanel.add(editorTitle);
        backPanel.add(backLabel);
        this.add(background);
        this.add(backPanel);
        this.setVisible(true);
    }
    
    public void fillTable(Vector<ProductItems> product) {
        model.setRowCount(0);
        model.setColumnCount(0);
        
        editor.setModel(model);
        editor.getTableHeader().setReorderingAllowed(false);
        editor.getTableHeader().setEnabled(false);
        
        model.addColumn("Category");
        model.addColumn("Item Name");
        model.addColumn("Item Price");
        model.addColumn("Available");
        
        Object rowData[] = new Object[4];
        for (int i = 0; i < product.size(); i++) {
            rowData[0] = product.get(i).getCategory();
            rowData[1] = product.get(i).getItemName();
            rowData[2] = product.get(i).getItemPrice();
            rowData[3] = product.get(i).isAvailable();
             model.addRow(rowData);
        }
       editor.getColumnModel().getColumn(0).setCellEditor(null);
        editor.setAutoCreateRowSorter(true);
        editor.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        editor.setForeground(Color.WHITE);
        editor.setBackground(Color.DARK_GRAY);
        editor.setSelectionBackground(Color.WHITE);
        editor.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        editorJCP.setViewportView(this.editor);
        editorJCP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        editorJCP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        editorJCP.setBounds(50, 5, 1100, 650);
        
        background.add(editorJCP);
        background.setVisible(true);
        this.add(background);
        this.revalidate();
        this.repaint();
        
    }
    public void addListSelectionListener(ListSelectionListener selectionListener){
        editor.getSelectionModel().addListSelectionListener(selectionListener);
        ///editor.getCellEditor().addCellEditorListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        AdminData data = (AdminData) arg;
        if (!data.allItems.isEmpty()) {
            fillTable(data.allItems);
        }
        
    }

    public JLabel getBackLabel() {
        return backLabel;
    }
    public JTable getEditor(){
        return editor;
    }
}
