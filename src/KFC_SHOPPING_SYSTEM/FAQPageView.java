package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 */
public class FAQPageView {

    JFrame aFAQFrame;
    JPanel aHeaderPanel;
    JPanel aCenterPanel;
    JLabel aHeaderLabel;
    JButton aBackButton;
    JTextArea aFAQTextArea;
    JTextArea aAskQuestionArea;
    JScrollPane aFAQScrollPane;
    JScrollPane aQnAScrollPane;

    FAQPageView() {
        System.out.println("[KFC: VIEWING FAQ PAGE]");
//------------------------------------------------------------------------------   
// Background Image       
        ImageIcon aFAQBackgroundImage = new ImageIcon("./resources/FAQPageImages/BackgroundImage.jpeg");
        Image aBackgroundImage = aFAQBackgroundImage.getImage().getScaledInstance(1200, 800, java.awt.Image.SCALE_SMOOTH);
        aFAQBackgroundImage = new ImageIcon(aBackgroundImage);

// Header Image
        ImageIcon aHeaderIcon = new ImageIcon("./resources/FAQPageImages/IconKFC.png");
        Image aHeaderImage = aHeaderIcon.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        aHeaderIcon = new ImageIcon(aHeaderImage);

//JFrame        
        aFAQFrame = new JFrame("KFC FAQ");
        aFAQFrame.setLayout(null);
        JLabel aBackground = new JLabel("", aFAQBackgroundImage, JLabel.CENTER);
        aBackground.setBounds(0, 0, 1200, 800);
        aFAQFrame.add(aBackground);

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
        aCenterPanel.setBackground(new Color(255, 255, 255));
        aCenterPanel.setBounds(100, 150, 1000, 600);
        aBackground.add(aCenterPanel);

//------------------------------------------------------------------------------
// KFC Title Label
        JLabel aTitleLabel = new JLabel("KFC FAQ");
        aTitleLabel.setBounds(500, 0, 400, 80);
        aTitleLabel.setForeground(Color.WHITE);
        aTitleLabel.setFont(new Font("", Font.BOLD, 50));
        aTitleLabel.setIcon(aHeaderIcon);
        aHeaderPanel.add(aTitleLabel);

// Center Panel Label
        JLabel aCenterHeader = new JLabel("HOW CAN WE HELP?");
        aCenterHeader.setFont(new Font("", Font.BOLD, 20));
        aCenterHeader.setBounds(10, -80, 300, 200);
        aCenterPanel.add(aCenterHeader);

//------------------------------------------------------------------------------  
// KFC FAQ TextField 
        aFAQTextArea = new JTextArea();
        aFAQTextArea.setLineWrap(true);
        aFAQTextArea.setWrapStyleWord(true);
        aFAQTextArea.setEditable(false);
        aFAQTextArea.setFont(new Font("Andada Pro", Font.PLAIN, 16));
        aFAQTextArea.setBounds(20, 50, 950, 500);
        aFAQTextArea.setBackground(new Color(255, 255, 255));

        aFAQScrollPane = new JScrollPane(aFAQTextArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        aCenterPanel.add(aFAQTextArea);

//------------------------------------------------------------------------------  
//KFC FAQ BACK BUTTON 
        aBackButton = new JButton("BACK");
        aBackButton.setBounds(5, 5, 50, 20);
        aBackButton.setBackground(Color.red);
        aHeaderPanel.add(aBackButton);

//------------------------------------------------------------------------------  
// JFrame Default Settings
        aFAQFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFAQFrame.setSize(1200, 800);
        aFAQFrame.setResizable(false);
        aFAQFrame.setVisible(false);
//------------------------------------------------------------------------------
    }

    public void addActionListener(ActionListener AL) {
        aBackButton.addActionListener(AL);
    }

}
