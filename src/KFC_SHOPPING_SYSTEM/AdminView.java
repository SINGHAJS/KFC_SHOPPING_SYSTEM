/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author singh
 */
public class AdminView extends JFrame implements Observer{

    private JPanel headPanel = new JPanel();
    private JPanel browsePanel  = new JPanel();
    private JLabel backLabel = new JLabel();
    private JLabel adminLabel = new JLabel("HI THERE ROHIT");
   
    
    public AdminView( ){
        
    }
//    public static void main(String[] args) {
//        AdminView g = new AdminView();
//
//      g.showTable();
//    }
    public void back(){
         headPanel.setBackground(Color.DARK_GRAY);
        headPanel.setBounds(0, 0, 1200, 30);
        headPanel.setLayout(null);
        
        backLabel.setFont(new Font("", Font.BOLD, 13));
        backLabel.setForeground(Color.WHITE);
        backLabel.setBounds(20, 0, 150, 30);
        
        headPanel.add(backLabel);
        
        this.add(headPanel);
        this.repaint();
        this.setVisible(true);
    }
        public void browse() {
        browsePanel.setBackground(Color.WHITE);
        browsePanel.setBounds(0, 30, 1200, 770);
        browsePanel.setLayout(null);
    }
    public void showTable(){
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.back();
        this.browse();
        adminLabel.setForeground(Color.GRAY);
        adminLabel.setBounds(50,5,200,50);
        
        browsePanel.add(adminLabel);
        
        this.add(browsePanel);
        this.revalidate();
       this.repaint();
        this.setVisible(true);
    }
    @Override
    public void update(Observable o, Object arg) {
        BrowseData data = (BrowseData) arg;
        if (data.adminFlag == true){
            this.showTable();
            System.out.println("    hi");
        }
    }
    
    
}
