package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ajit_singh
 */
public class ManagerView {
    
    LoginView aView;

    JFrame aManagerFrame;
    JPanel aHeaderPanel;
    JPanel aCenterPanel;
    JLabel aHeaderLabel;
    JButton aLogOutButton;

    public ManagerView() {
        System.out.println("[KFC: VIEWING MANAGER PAGE]");                           
        //------------------------------------------------------------------------------   
// Background Image
        ImageIcon aManagerBackgroundImage = new ImageIcon("./resources/RegistrationPageImages/KFCBackgroundImage.jpeg");
        Image aBackgroundImage = aManagerBackgroundImage.getImage().
                getScaledInstance(1200, 800, java.awt.Image.SCALE_SMOOTH);
        aManagerBackgroundImage = new ImageIcon(aBackgroundImage);

//JFrame        
        aManagerFrame = new JFrame("KFC MANAGER");
        aManagerFrame.setLayout(null);
        JLabel aBackground = new JLabel("", aManagerBackgroundImage, JLabel.CENTER);
        aBackground.setBounds(0, 0, 1200, 800);
        aManagerFrame.add(aBackground);

//------------------------------------------------------------------------------
//Login Page Header Panel 
        aHeaderPanel = new JPanel();
        aHeaderPanel.setLayout(null);
        aHeaderPanel.setBackground(new Color(0, 0, 0, 100));
        aHeaderPanel.setBounds(0, 0, 1200, 80);
        aBackground.add(aHeaderPanel);

//Login Page Center Panel 
        aCenterPanel = new JPanel();
        aCenterPanel.setLayout(null);
        aCenterPanel.setBackground(new Color(255, 255, 255, 100));
        aCenterPanel.setBounds(600, 150, 500, 500);
        aBackground.add(aCenterPanel);

//------------------------------------------------------------------------------
// KFC Title Label
//+ aView.aNameField.getText().toUpperCase()
        JLabel aTitleLabel = new JLabel("WELCOME ");
        aTitleLabel.setBounds(350, 0, 550, 80);
        aTitleLabel.setForeground(Color.WHITE);
        aTitleLabel.setFont(new Font("", Font.BOLD, 50));        
        aHeaderPanel.add(aTitleLabel);

// Center Panel Label
        JLabel aCenterHeader = new JLabel("???");
        aCenterHeader.setFont(new Font("", Font.BOLD, 30));
        aCenterHeader.setBounds(10, -80, 400, 200);
        aCenterPanel.add(aCenterHeader);

//------------------------------------------------------------------------------  
//KFC Registration BACK BUTTON 
        aLogOutButton = new JButton("LOG OUT");
        aLogOutButton.setBounds(5, 5, 50, 20);
        aHeaderPanel.add(aLogOutButton);

//------------------------------------------------------------------------------  
// JFrame Default Settings
        aManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aManagerFrame.setSize(1200, 800);
        aManagerFrame.setResizable(false);
        aManagerFrame.setVisible(false);
//------------------------------------------------------------------------------

    }

    public void addActionListener(ActionListener AL) {
        aLogOutButton.addActionListener(AL);
    }

}
