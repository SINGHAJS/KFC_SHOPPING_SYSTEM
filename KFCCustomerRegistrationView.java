package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Ajit Singh ID: 19070642
 */

public class KFCCustomerRegistrationView {

    JFrame aRegistrationFrame;
    JPanel aHeaderPanel;
    JPanel aCenterPanel;
    JLabel aHeaderLabel;
    JButton aBackButton;
    JButton aSubmitButton;
    JTextField aNameField;
    JPasswordField aPassField;
    JPasswordField aConfirmPasswordField;
    JTextField aEmailField;
    JTextField aAddressField;

    public KFCCustomerRegistrationView() {

        //------------------------------------------------------------------------------   
// Background Image
        ImageIcon aRegistrationBackgroundImage = new ImageIcon("./resources/RegistrationPageImages/KFCBackgroundImage.jpeg");
        Image aBackgroundImage = aRegistrationBackgroundImage.getImage().
                getScaledInstance(1200, 800, java.awt.Image.SCALE_SMOOTH);
        aRegistrationBackgroundImage = new ImageIcon(aBackgroundImage);

// Header Image
        ImageIcon aHeaderIcon = new ImageIcon("./resources/FAQPageImages/IconKFC.png");
        Image aHeaderImage = aHeaderIcon.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        aHeaderIcon = new ImageIcon(aHeaderImage);

//JFrame        
        aRegistrationFrame = new JFrame("KFC REGISTRATION");
        aRegistrationFrame.setLayout(null);
        JLabel aBackground = new JLabel("", aRegistrationBackgroundImage, JLabel.CENTER);
        aBackground.setBounds(0, 0, 1200, 800);
        aRegistrationFrame.add(aBackground);

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
        aCenterPanel.setBackground(new Color(0, 0, 0, 100));
        aCenterPanel.setBounds(100, 150, 1000, 600);
        aBackground.add(aCenterPanel);

//------------------------------------------------------------------------------
// KFC Title Label
        JLabel aTitleLabel = new JLabel("KFC REGISTRATION");
        aTitleLabel.setBounds(350, 0, 550, 80);
        aTitleLabel.setForeground(Color.WHITE);
        aTitleLabel.setFont(new Font("", Font.BOLD, 50));
        aTitleLabel.setIcon(aHeaderIcon);
        aHeaderPanel.add(aTitleLabel);        

// Center Panel Label
        JLabel aCenterHeader = new JLabel("CREATE YOUR ACCOUNT");
        aCenterHeader.setForeground(Color.WHITE);
        aCenterHeader.setFont(new Font("", Font.BOLD, 30));
        aCenterHeader.setBounds(10, -80, 400, 200);
        aCenterPanel.add(aCenterHeader);
//------------------------------------------------------------------------------  
// Name Label + User Name Field
        JLabel aNameLabel = new JLabel("Enter User Name");
        aNameLabel.setForeground(Color.WHITE);
        aNameLabel.setFont(new Font("", Font.BOLD, 15));
        aNameLabel.setBounds(40, 50, 150, 50);
        aCenterPanel.add(aNameLabel);

        aNameField = new JTextField();        
        aNameField.setBounds(40, 90, 150, 20);
        aCenterPanel.add(aNameField);

// Password Label + Password Field
        JLabel aPasswordLabel = new JLabel("Enter Password");
        aPasswordLabel.setForeground(Color.WHITE);
        aPasswordLabel.setFont(new Font("", Font.BOLD, 15));
        aPasswordLabel.setBounds(40, 110, 150, 50);
        aCenterPanel.add(aPasswordLabel);

        aPassField = new JPasswordField("");        
        aPassField.setBounds(40, 150, 150, 20);
        aCenterPanel.add(aPassField);
        
// Confirm Password Label + Confirm Password Field
        JLabel aConfirmPasswordLabel = new JLabel("Confirm Password");
        aConfirmPasswordLabel.setForeground(Color.WHITE);
        aConfirmPasswordLabel.setFont(new Font("", Font.BOLD, 15));
        aConfirmPasswordLabel.setBounds(40, 170, 150, 50);
        aCenterPanel.add(aConfirmPasswordLabel);     
        
        aConfirmPasswordField = new JPasswordField();        
        aConfirmPasswordField.setBounds(40, 210, 150, 20);
        aCenterPanel.add(aConfirmPasswordField);


// Email Label + Text Field
        JLabel aEmailLabel = new JLabel("Enter Email");
        aEmailLabel.setForeground(Color.WHITE);
        aEmailLabel.setFont(new Font("", Font.BOLD, 15));
        aEmailLabel.setBounds(40, 230, 150, 50);
        aCenterPanel.add(aEmailLabel);     
        
        aEmailField = new JTextField();        
        aEmailField.setBounds(40, 270, 200, 20);
        aCenterPanel.add(aEmailField);     
        
// Address Label + Text Field
        JLabel aAddresslLabel = new JLabel("Enter Home Addresss");
        aAddresslLabel.setForeground(Color.WHITE);
        aAddresslLabel.setFont(new Font("", Font.BOLD, 15));
        aAddresslLabel.setBounds(40, 290, 200, 50);
        aCenterPanel.add(aAddresslLabel);     
        
        aAddressField = new JTextField();        
        aAddressField.setBounds(40, 330, 200, 20);
        aCenterPanel.add(aAddressField);     
        
//------------------------------------------------------------------------------  
//KFC Registration BACK BUTTON 
        aBackButton = new JButton("BACK");
        aBackButton.setBounds(5, 5, 50, 20);
        aBackButton.setBackground(Color.red);
        aHeaderPanel.add(aBackButton);

//KFC Submit Button 
        aSubmitButton = new JButton("Submit");
        aSubmitButton.setBounds(40, 360, 50, 20);
        aCenterPanel.add(aSubmitButton);
        
        
//------------------------------------------------------------------------------  
// JFrame Default Settings
        aRegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aRegistrationFrame.setSize(1200, 800);
        aRegistrationFrame.setResizable(false);
        aRegistrationFrame.setVisible(true);
//------------------------------------------------------------------------------

    }
}
