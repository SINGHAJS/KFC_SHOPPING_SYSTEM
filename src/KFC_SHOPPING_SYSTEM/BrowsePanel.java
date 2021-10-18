/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author singh
 */
public class BrowsePanel extends JPanel {

    private JList categoryList = new JList();
    private JList itemsList = new JList();
    private JScrollPane categoryJCP = new JScrollPane();
    private JScrollPane itemsJCP = new JScrollPane();
   
    private JTextField itemNumText = new JTextField();
    private final JButton addButton = new JButton("ADD ITEM TO CART");
    
    private ImageIcon arrowImage = new ImageIcon("./resources/BrowseImages/arrow.png");
    private final Image arrow = arrowImage.getImage().getScaledInstance(40, 40, 40);
    private final JLabel arrowLabel = new JLabel(new ImageIcon(arrow));
    
    private ImageIcon bucketImage = new ImageIcon("./resources/BrowseImages/bucket.PNG");
    private final Image bucket = bucketImage.getImage().getScaledInstance(100, 100, 100);
    private final JLabel bucketLabel = new JLabel(new ImageIcon(bucket));
    
    private final JLabel chooseCategoryLabel = new JLabel("CHOOSE A CATEGORY: ");
    private final JLabel selectLabel = new JLabel("SELECT ITEM:");
    
    BrowsePanel() {
        this.setBackground(Color.WHITE);
        this.setBounds(0, 30, 1200, 770);
        this.setLayout(null);
    }

    public void categoryList(Vector<String> cList) {
        chooseCategoryLabel.setFont(new Font("", Font.BOLD, 25));
        chooseCategoryLabel.setForeground(Color.BLACK);
        chooseCategoryLabel.setBounds(50, 5, 300, 50);
        
        categoryList.setListData(cList);
        categoryList.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
        categoryList.setForeground(Color.WHITE);
        categoryList.setBackground(Color.DARK_GRAY);
        categoryList.setSelectionBackground(Color.WHITE);
        
        categoryList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        categoryJCP.setViewportView(this.categoryList);
        categoryJCP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        categoryJCP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        categoryJCP.setBounds(50, 50, 300, 600);
        
        this.add(categoryJCP);
        this.add(chooseCategoryLabel);
        this.setVisible(true);
    }

    public void itemsList(Vector<Products> iList) {
        selectLabel.setFont(new Font("", Font.BOLD, 25));
        selectLabel.setForeground(Color.BLACK);
        selectLabel.setBounds(400, 5, 200, 50);
        
        arrowLabel.setText("NEXT");
        arrowLabel.setVerticalTextPosition(JLabel.BOTTOM);
        arrowLabel.setHorizontalTextPosition(JLabel.CENTER);
        arrowLabel.setBounds(250, 5, 250, 75);
        
        getAddButton().setBounds(650, 655, 150, 30);
        getAddButton().setBackground(Color.DARK_GRAY);
        getAddButton().setForeground(Color.WHITE);
        
        itemsList.setListData(iList);
        itemsList.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        itemsList.setForeground(Color.WHITE);
        itemsList.setBackground(Color.DARK_GRAY);
        itemsList.setSelectionBackground(Color.WHITE);
        itemsList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        itemsJCP.setViewportView(this.itemsList);
        itemsJCP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        itemsJCP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        itemsJCP.setBounds(400, 50, 400, 600);
        
        
        
        this.add(getAddButton());
        this.add(arrowLabel);
        this.add(selectLabel);
        this.add(itemsJCP);
        this.setVisible(true);
    }
    public void bucketCounter(int count){
        bucketLabel.setBounds(950, 300, 100, 100);
        
        itemNumText.setText(String.valueOf(count));
        itemNumText.setFont(new Font("", Font.BOLD, 15));
        itemNumText.setBorder(null);
        itemNumText.setHorizontalAlignment(JTextField.CENTER);
        itemNumText.setHorizontalAlignment(JTextField.CENTER);
        itemNumText.setBounds(985, 325, 30, 30);
        
        this.add(bucketLabel);
        this.add(itemNumText);
        this.setVisible(true);
    }
    public JList getCategoryList() {
        return categoryList;
    }
    public JList getItemsList(){
        return itemsList;
    }
     public JButton getAddButton() {
        return addButton;
    }
}
