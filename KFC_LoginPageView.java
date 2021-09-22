package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @author ajit_singh
 */
public class KFC_LoginPageView implements Observer {
    
    protected JButton aLoginButton;
    protected JButton aManagerLoginButton;
    protected JButton aRegistrationButton;
    protected JButton aFAQButton;
    protected JTextField aNameField;
    protected JTextField aPassField;         
    
    public KFC_LoginPageView() {
        System.out.println("[KFC VIEW]");
//------------------------------------------------------------------------------
        // Images                   

        // Background Image
        ImageIcon aLoginBackgroundImage = new ImageIcon("./resources/storeOutside.jpg");
        Image aBackgroundImage = aLoginBackgroundImage.getImage().getScaledInstance
        (1200, 800, java.awt.Image.SCALE_SMOOTH);
        aLoginBackgroundImage = new ImageIcon(aBackgroundImage);

        // Header Image
        ImageIcon stickManIcon = new ImageIcon("./resources/kfc_stickman.png");
        Image titleImage = stickManIcon.getImage().getScaledInstance
        (80, 80, java.awt.Image.SCALE_SMOOTH);
        stickManIcon = new ImageIcon(titleImage);

        // Login Panel Titile Image
        ImageIcon colonelSandersIcon = new ImageIcon("./resources/colonelSandersIcon.png");
        Image colonelSandersImageImage = colonelSandersIcon.getImage().getScaledInstance
        (40, 40, java.awt.Image.SCALE_SMOOTH);
        colonelSandersIcon = new ImageIcon(colonelSandersImageImage);

        // UserName Icon
        ImageIcon stickManUserIcon = new ImageIcon("./resources/kfc_stickman.png");
        Image loginImage = stickManUserIcon.getImage().getScaledInstance
        (25, 25, java.awt.Image.SCALE_SMOOTH);
        stickManUserIcon = new ImageIcon(loginImage);

        // Password Icon
        ImageIcon keyIcon = new ImageIcon("./resources/keyIcon.png");
        Image loginKeyImage = keyIcon.getImage().getScaledInstance
        (20, 20, java.awt.Image.SCALE_SMOOTH);
        keyIcon = new ImageIcon(loginKeyImage);

//------------------------------------------------------------------------------   
        //JFrame
        JFrame aFrame = new JFrame();
        aFrame.setLayout(null);

        JLabel aBackground = new JLabel("", aLoginBackgroundImage, JLabel.CENTER);
        aBackground.setBounds(0, 0, 1200, 800);
        aFrame.add(aBackground);

//------------------------------------------------------------------------------
        //Login Page Header Panel 
        JPanel aHeaderPanel = new JPanel();
        //aHeaderPanel.setBackground(new Color(178,34,34));        
        aHeaderPanel.setBackground(new Color(0, 0, 0, 95));
        aHeaderPanel.setBounds(0, 0, 1200, 80);
        aBackground.add(aHeaderPanel);

        //Login Page Footer Panel 
        JPanel aFooterPanel = new JPanel();
        //aFooterPanel.setBackground(new Color(178,34,34));
        aFooterPanel.setBackground(new Color(0, 0, 0, 80));
        aFooterPanel.setBounds(0, 695, 1200, 80);
        aFrame.add(aFooterPanel);

        //Login Page Center Panel 
        JPanel aCenterPanel = new JPanel();
        aCenterPanel.setLayout(null);
        aCenterPanel.setBackground(new Color(255, 255, 255, 95));
        aCenterPanel.setBounds(700, 200, 400, 400);
        aBackground.add(aCenterPanel);

//------------------------------------------------------------------------------
        // Center Panel Label
        JLabel aCenterHeader = new JLabel("LOGIN");
        aCenterHeader.setFont(new Font("", Font.BOLD, 40));
        aCenterHeader.setBounds(120, -50, 200, 200);
        aCenterHeader.setIcon(colonelSandersIcon);
        aCenterPanel.add(aCenterHeader);

        // KFC Title Label
        JLabel aTitleLabel = new JLabel("KFC");
        aTitleLabel.setBounds(0, 0, 200, 200);
        aTitleLabel.setForeground(Color.WHITE);
        aTitleLabel.setFont(new Font("", Font.BOLD, 50));
        aTitleLabel.setIcon(stickManIcon);
        aHeaderPanel.add(aTitleLabel);

//------------------------------------------------------------------------------
        // Name Label + User Name Field
        JLabel aNameLabel = new JLabel("UserName");
        aNameLabel.setFont(new Font("", Font.BOLD, 15));        
        aNameLabel.setBounds(10, 80, 150, 50);
        aNameLabel.setIcon(stickManUserIcon);
        aCenterPanel.add(aNameLabel);

        aNameField = new JTextField("Enter Username");
        aNameField.setBackground(new Color(255, 255, 255, 50));        
        aNameField.setBounds(150, 95, 150, 20);
        aCenterPanel.add(aNameField);

        // Password Label + Password Field
        JLabel aPasswordLabel = new JLabel("Password");        
        aPasswordLabel.setIcon(keyIcon);
        aPasswordLabel.setFont(new Font("", Font.BOLD, 15));
        aPasswordLabel.setBounds(15, 110, 150, 50);
        aCenterPanel.add(aPasswordLabel);

        JPasswordField aPassField = new JPasswordField("");
        aPassField.setBackground(new Color(255, 255, 255, 50));
        aPassField.setBounds(150, 125, 150, 20);
        aCenterPanel.add(aPassField);

//------------------------------------------------------------------------------
        // Login Button 
        aLoginButton = new JButton("Login");
        aLoginButton.setBounds(150, 150, 50, 20);
        aLoginButton.setBackground(Color.BLUE);
        aCenterPanel.add(aLoginButton);

        // Manager Button 
        aManagerLoginButton = new JButton("Manager Login");
        aManagerLoginButton.setBounds(200, 150, 100, 20);
        aCenterPanel.add(aManagerLoginButton);

        // Registeration Label + Button
        JLabel aRegistrationLabel = new JLabel("New? Register Now!");
        aRegistrationLabel.setFont(new Font("", Font.PLAIN, 15));
        aRegistrationLabel.setBounds(10, 350, 150, 50);
        aCenterPanel.add(aRegistrationLabel);

        aRegistrationButton = new JButton("Register");
        aRegistrationButton.setBounds(160, 365, 60, 20);
        aCenterPanel.add(aRegistrationButton);
        
        //FAQ Button
        aFAQButton = new JButton("VIEW FAQ");
        aFAQButton.setBounds(300, 365 , 70, 20);
        aCenterPanel.add(aFAQButton);
               
//------------------------------------------------------------------------------        

        // JFrame Default Settings
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setSize(1200, 800);
        aFrame.setResizable(false);
        aFrame.setVisible(true);        
//------------------------------------------------------------------------------
    }

    @Override
    public void update(Observable o, Object arg) {             
        // add code
    }
    

    public void addController(KFC_LoginPageController controller) {
        System.out.println("[View : Adding Controller]");
        aLoginButton.addActionListener(controller);
        aManagerLoginButton.addActionListener(controller);
        aRegistrationButton.addActionListener(controller);
        aFAQButton.addActionListener(controller);
        

    }

}
