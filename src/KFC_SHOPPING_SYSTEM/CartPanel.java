package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class CartPanel extends JPanel {

    private JTable cartList;
    private JScrollPane cartListJCP = new JScrollPane();
    private DefaultTableModel model = new DefaultTableModel();
    private final JLabel myBucketLabel = new JLabel("MY BUCKET");
    private final JLabel selectItem = new JLabel("Select Item to Edit");
    private JLabel grandTotal = new JLabel();
    private final JButton plusButton = new JButton("+");
    private final JButton minusButton = new JButton("-");
    private final JButton removeButton = new JButton("Remove Item");
    private final JButton checkoutButton = new JButton();

    CartPanel() { //intialise Table and restrict user from access cells
        this.cartList = new JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.setBackground(Color.WHITE);
        this.setBounds(0, 30, 1200, 770);
        this.setLayout(null);
    }

    public void cart(CartList cart) { //updates cart list view with new data and allows user to edit that data
        model.setRowCount(0);
        model.setColumnCount(0);

        setProperties();
        grandTotal.setText("TOTAL                     " + cart.getUnitTotal());
        checkoutButton.setText("Checkout              " + cart.getUnitTotal());

        setPropertiesJCP();
        Object rowData[] = new Object[4];
        for (int i = 0; i < cart.getCartSize(); i++) {
            rowData[0] = cart.getProduct(i).getItemName();
            rowData[1] = cart.getItemQuantity(i);
            rowData[2] = cart.getProduct(i).getItemPrice();
            rowData[3] = cart.getSubTotal(i);
            model.addRow(rowData);
        }

        this.add(checkoutButton);
        this.add(grandTotal);
        this.add(selectItem);
        this.add(myBucketLabel);
        this.add(plusButton);
        this.add(minusButton);
        this.add(removeButton);
        this.add(cartListJCP);
    }

    public void setProperties() {//sets properties for components used in cartpanel
        myBucketLabel.setFont(new Font("", Font.BOLD, 25));
        myBucketLabel.setForeground(Color.BLACK);
        myBucketLabel.setBounds(50, 5, 300, 50);

        selectItem.setFont(new Font("", Font.BOLD, 20));
        selectItem.setForeground(Color.BLACK);
        selectItem.setBounds(50, 540, 300, 50);

        grandTotal.setForeground(Color.BLACK);
        grandTotal.setBounds(830, 160, 300, 300);

        checkoutButton.setBackground(Color.DARK_GRAY);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBounds(740, 350, 300, 60);
        checkoutButton.setEnabled(false);

        plusButton.setFont(new Font("", Font.BOLD, 20));
        plusButton.setBackground(Color.DARK_GRAY);
        plusButton.setForeground(Color.WHITE);
        plusButton.setBounds(240, 550, 50, 30);
        plusButton.setEnabled(false);

        minusButton.setFont(new Font("", Font.BOLD, 20));
        minusButton.setBackground(Color.DARK_GRAY);
        minusButton.setForeground(Color.WHITE);
        minusButton.setBounds(295, 550, 50, 30);
        minusButton.setEnabled(false);

        removeButton.setFont(new Font("", Font.BOLD, 20));
        removeButton.setBackground(Color.DARK_GRAY);
        removeButton.setForeground(Color.WHITE);
        removeButton.setBounds(380, 550, 170, 30);
        removeButton.setEnabled(false);
    }

    public void setPropertiesJCP() { //sets properties for Table and JScrollPane to adhere to
        cartList.setModel(model);
        cartList.getTableHeader().setReorderingAllowed(false);
        cartList.getTableHeader().setEnabled(false);
        model.addColumn("ItemName");
        model.addColumn("Quantity");
        model.addColumn("Unit Price");
        model.addColumn("Sub-Total");
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
    }
//getters
    public JButton getPlusButton() {
        return plusButton;
    }

    public JButton getMinusButton() {
        return minusButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JTable getCartList() {
        return cartList;
    }

}
