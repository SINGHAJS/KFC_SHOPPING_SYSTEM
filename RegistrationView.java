package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ajit Singh ID: 19070642
 */
public class RegistrationView implements Observer {

    JFrame aRegistrationFrame;
    JPanel aHeaderPanel;
    JPanel aCenterPanel;
    JLabel aHeaderLabel;
    JButton aRegBackButton;
    JButton aRegSubmitButton;
    JTextField aNameField;
    JPasswordField aPassField;
    JPasswordField aConfirmPasswordField;
    JTextField aEmailField;
    JTextArea aAddressArea;

    public RegistrationView() {
        System.out.println("[KFC: VIEWING REGISTRATION PAGE]");
        //------------------------------------------------------------------------------   
// Background Image
        ImageIcon aRegistrationBackgroundImage = new ImageIcon("./resources/RegistrationPageImages/KFCBackgroundImage.jpeg");
        Image aBackgroundImage = aRegistrationBackgroundImage.getImage().
                getScaledInstance(1200, 800, java.awt.Image.SCALE_SMOOTH);
        aRegistrationBackgroundImage = new ImageIcon(aBackgroundImage);

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
        aCenterPanel.setBackground(new Color(255, 255, 255, 100));
        aCenterPanel.setBounds(600, 150, 500, 500);
        aBackground.add(aCenterPanel);

//------------------------------------------------------------------------------
// KFC Title Label
        JLabel aTitleLabel = new JLabel("KFC REGISTRATION");
        aTitleLabel.setBounds(350, 0, 550, 80);
        aTitleLabel.setForeground(Color.WHITE);
        aTitleLabel.setFont(new Font("", Font.BOLD, 50));
        aHeaderPanel.add(aTitleLabel);

// Center Panel Label
        JLabel aCenterHeader = new JLabel("CREATE YOUR ACCOUNT");
        aCenterHeader.setFont(new Font("", Font.BOLD, 30));
        aCenterHeader.setBounds(10, -80, 400, 200);
        aCenterPanel.add(aCenterHeader);
//------------------------------------------------------------------------------  
// Name Label + User Name Field
        JLabel aNameLabel = new JLabel("Enter User Name");
        aNameLabel.setFont(new Font("", Font.BOLD, 15));
        aNameLabel.setBounds(40, 50, 150, 50);
        aCenterPanel.add(aNameLabel);

        aNameField = new JTextField();
        aNameField.setBounds(250, 70, 150, 20);
        aCenterPanel.add(aNameField);

// Password Label + Password Field
        JLabel aPasswordLabel = new JLabel("Enter Password");
        aPasswordLabel.setFont(new Font("", Font.BOLD, 15));
        aPasswordLabel.setBounds(40, 100, 150, 50);
        aCenterPanel.add(aPasswordLabel);

        aPassField = new JPasswordField("");
        aPassField.setBounds(250, 120, 150, 20);
        aCenterPanel.add(aPassField);

// Confirm Password Label + Confirm Password Field
        JLabel aConfirmPasswordLabel = new JLabel("Confirm Password");
        aConfirmPasswordLabel.setFont(new Font("", Font.BOLD, 15));
        aConfirmPasswordLabel.setBounds(40, 150, 150, 50);
        aCenterPanel.add(aConfirmPasswordLabel);

        aConfirmPasswordField = new JPasswordField();
        aConfirmPasswordField.setBounds(250, 170, 150, 20);
        aCenterPanel.add(aConfirmPasswordField);

// Email Label + Text Field
        JLabel aEmailLabel = new JLabel("Enter Email");
        aEmailLabel.setFont(new Font("", Font.BOLD, 15));
        aEmailLabel.setBounds(40, 200, 150, 50);
        aCenterPanel.add(aEmailLabel);

        aEmailField = new JTextField();
        aEmailField.setBounds(250, 220, 200, 20);
        aCenterPanel.add(aEmailField);

// Address Label + Text Field
        JLabel aAddresslLabel = new JLabel("Enter Home Addresss");
        aAddresslLabel.setFont(new Font("", Font.BOLD, 15));
        aAddresslLabel.setBounds(40, 250, 200, 50);
        aCenterPanel.add(aAddresslLabel);

        aAddressArea = new JTextArea();
        aAddressArea.setBounds(250, 270, 200, 100);
        aAddressArea.setLineWrap(true);
        aAddressArea.setWrapStyleWord(true);
        aAddressArea.setEditable(true);
        aCenterPanel.add(aAddressArea);

//------------------------------------------------------------------------------  
//KFC Registration BACK BUTTON 
        aRegBackButton = new JButton("BACK");
        aRegBackButton.setBounds(5, 5, 50, 20);
        aHeaderPanel.add(aRegBackButton);

//KFC Submit Button 
        aRegSubmitButton = new JButton("Submit");
        aRegSubmitButton.setBounds(400, 400, 50, 20);
        aCenterPanel.add(aRegSubmitButton);

//------------------------------------------------------------------------------  
// JFrame Default Settings
        aRegistrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aRegistrationFrame.setSize(1200, 800);
        aRegistrationFrame.setResizable(false);
        aRegistrationFrame.setVisible(false);
//------------------------------------------------------------------------------

    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addActionListener(ActionListener AL) {
        aRegSubmitButton.addActionListener(AL);
        aRegBackButton.addActionListener(AL);
    }

}
