/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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
public class CartPanel extends JPanel {

    private JTable cartList;
    private JScrollPane cartListJCP = new JScrollPane();
    private DefaultTableModel model = new DefaultTableModel();
    private final JLabel myBucketLabel = new JLabel("MY BUCKET");

    private final JButton plusButton = new JButton("+");
    private final JButton minusButton = new JButton("-");
    private final JButton removeButton = new JButton("Remove Item");

    CartPanel() {
        this.cartList = new JTable(){ 
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }};
        this.setBackground(Color.WHITE);
        this.setBounds(0, 30, 1200, 770);
        this.setLayout(null);
    }

    public void cart(CartList cart) {
        model.setRowCount(0);
        model.setColumnCount(0);
        myBucketLabel.setFont(new Font("", Font.BOLD, 25));
        myBucketLabel.setForeground(Color.BLACK);
        myBucketLabel.setBounds(50, 5, 300, 50);

        plusButton.setFont(new Font("", Font.BOLD, 20));
        plusButton.setBounds(50, 400, 60, 60);

        minusButton.setFont(new Font("", Font.BOLD, 20));
        minusButton.setBounds(120, 400, 60, 60);

        removeButton.setFont(new Font("", Font.BOLD, 20));
        removeButton.setBounds(180, 400, 170, 60);

        cartList.setModel(model);
        cartList.getTableHeader().setReorderingAllowed(false);
        model.addColumn("ItemName");
        model.addColumn("Quantity");
        model.addColumn("Unit Price");
        model.addColumn("Sub-Total");
        Object rowData[] = new Object[4];
        for (int i  = 0;i<cart.getCartSize();i++){
            rowData[0] = cart.getProduct(i).getItemName();
            rowData[1] = cart.getItemQuantity(i);
            rowData[2] = cart.getProduct(i).getItemPrice();
            rowData[3] = cart.getSubTotal(i);
            model.addRow(rowData);
        }
        cartList.getColumnModel().getColumn(1).setMaxWidth(70);
        cartList.getColumnModel().getColumn(2).setMaxWidth(70);
        cartList.getColumnModel().getColumn(3).setMaxWidth(70);
        cartList.setShowGrid(false);
        cartList.setAutoCreateRowSorter(true);
        
        cartList.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        cartList.setForeground(Color.WHITE);
        cartList.setBackground(Color.DARK_GRAY);
        cartList.setSelectionBackground(Color.WHITE);
        cartList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cartListJCP.setViewportView(this.cartList);
        cartListJCP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        cartListJCP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        cartListJCP.setBounds(50, 50, 500, 500);

        this.add(myBucketLabel);
        this.add(plusButton);
        this.add(minusButton);
        this.add(removeButton);
        this.add(cartListJCP);
    }
}
