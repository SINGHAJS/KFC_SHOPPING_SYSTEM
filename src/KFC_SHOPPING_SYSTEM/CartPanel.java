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
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author singh
 */
public class CartPanel extends JPanel {

    private JList cartList = new JList();
    private JScrollPane cartListJCP = new JScrollPane();

    private final JLabel myBucketLabel = new JLabel("MY BUCKET");

    private final JButton plusButton = new JButton("+");
    private final JButton minusButton = new JButton("-");
    private final JButton removeButton = new JButton("Remove Item");

    CartPanel() {
        this.setBackground(Color.WHITE);
        this.setBounds(0, 30, 1200, 770);
        this.setLayout(null);
    }

    public void cart(Vector<String> items) {
        myBucketLabel.setFont(new Font("", Font.BOLD, 25));
        myBucketLabel.setForeground(Color.BLACK);
        myBucketLabel.setBounds(50, 5, 300, 50);

        plusButton.setFont(new Font("", Font.BOLD, 20));
        plusButton.setBounds(50, 400, 60, 60);

        minusButton.setFont(new Font("", Font.BOLD, 20));
        minusButton.setBounds(120, 400, 60, 60);

        removeButton.setFont(new Font("", Font.BOLD, 20));
        removeButton.setBounds(180, 400, 170, 60);

        cartList.setListData(items);
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
