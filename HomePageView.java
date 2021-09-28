package KFC_SHOPPING_SYSTEM;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author ajit_singh
 */
public class HomePageView {

    JFrame aHomeFrame;
    JPanel aHeaderPanel;
    JPanel aCenterPanel;
    JPanel aFooterPanel;

    HomePageView() {
//------------------------------------------------------------------------------
//Images                   
// Background Image
        ImageIcon aLoginBackgroundImage = new ImageIcon("./resources/HomePageImages/storeOutside.jpg");
        Image aBackgroundImage = aLoginBackgroundImage.getImage()
                .getScaledInstance(1200, 800, java.awt.Image.SCALE_SMOOTH);
        aLoginBackgroundImage = new ImageIcon(aBackgroundImage);

//------------------------------------------------------------------------------   
//JFrame        
        aHomeFrame = new JFrame("Login Page");
        aHomeFrame.setLayout(null);
        JLabel aBackground = new JLabel("", aLoginBackgroundImage, JLabel.CENTER);
        aBackground.setBounds(0, 0, 1200, 800);
        aHomeFrame.add(aBackground);
        
        
//------------------------------------------------------------------------------   
//JPanel 


//------------------------------------------------------------------------------   
//
        
//------------------------------------------------------------------------------   
//JFrame Defualt Settings    
        aHomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aHomeFrame.setSize(1200, 800);
        aHomeFrame.setResizable(false);
        aHomeFrame.setVisible(true);
    }

}
