/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author singh
 */
public class AdminView extends JFrame implements Observer{
    private JPanel background = new JPanel();
    private JPanel backPanel = new JPanel();
    private final JLabel backLabel = new JLabel("Back to LoginPage");
    private final JLabel editorTitle = new JLabel("Manager Tool");
    private JTable editor = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private JScrollPane editorJCP = new JScrollPane();
    public AdminView( ){
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        getBackLabel().setFont(new Font("", Font.BOLD, 20));
        getBackLabel().setForeground(Color.WHITE);
        getBackLabel().setBounds(20, 0, 200, 30);
        
        editorTitle.setFont(new Font("", Font.BOLD, 20));
        editorTitle.setForeground(Color.RED);
        editorTitle.setBounds(550, 0, 200, 30);
                
        backPanel.setBackground(Color.DARK_GRAY);
        backPanel.setBounds(0, 0, 1200, 30);
        backPanel.setLayout(null);
        
        background.setBackground(Color.WHITE);
        background.setBounds(0,30,1200,770);
        background.setLayout(null);
        editor.setModel(model);
        editor.getTableHeader().setReorderingAllowed(false);
        editor.getTableHeader().setEnabled(false);
        model.addColumn("Category");
        model.addColumn("Item Name");
        model.addColumn("Item Price");
        model.addColumn("Available");
        Object rowData[] = new Object[3];
        rowData[1] = "tem";
        model.addRow(rowData);
        editor.setAutoCreateRowSorter(true);
        editor.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        editor.setForeground(Color.WHITE);
        editor.setBackground(Color.DARK_GRAY);
        editor.setSelectionBackground(Color.WHITE);
        editor.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        editorJCP.setViewportView(this.editor);
        editorJCP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        editorJCP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        editorJCP.setBounds(0, 5, 1200, 650);
        
       
        backPanel.add(backLabel);
        backPanel.add(editorTitle);
         background.add(editorJCP);
        this.add(backPanel);
        this.add(background);
        this.setVisible(true);
    }
    @Override
    public void update(Observable o, Object arg) {

    }
    public JLabel getBackLabel(){
        return backLabel;
    }
}
