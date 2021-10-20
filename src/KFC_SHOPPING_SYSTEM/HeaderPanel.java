package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class HeaderPanel extends JPanel {

    private final JLabel browseLabel = new JLabel("BROWSE MENU");
    private final JLabel cLabel = new JLabel("VIEW CART");
    private final JLabel backLabel = new JLabel("Back to LoginPage");
    private JLabel chooseTab = new JLabel("Click Tab To Browse or ViewCart");
    
    public HeaderPanel() {
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(0, 0, 1200, 30);
        this.setLayout(null);
    }

    public void back() {
        getBrowseLabel().setFont(new Font("", Font.BOLD, 20));
        getBrowseLabel().setForeground(Color.WHITE);
        getBrowseLabel().setBounds(400, 0, 200, 30);

        getcLabel().setFont(new Font("", Font.BOLD, 20));
        getcLabel().setForeground(Color.WHITE);
        getcLabel().setBounds(625, 0, 200, 30);

        getBackLabel().setFont(new Font("", Font.BOLD, 20));
        getBackLabel().setForeground(Color.WHITE);
        getBackLabel().setBounds(20, 0, 200, 30);

        chooseTab.setFont(new Font("", Font.BOLD, 15));
        chooseTab.setForeground(Color.WHITE);
        chooseTab.setBounds(950, 0, 300, 30);
        
        this.add(chooseTab);
        this.add(getcLabel());
        this.add(getBrowseLabel());
        this.add(getBackLabel());
    }

    public JLabel getBackLabel() {
        return backLabel;
    }

    public JLabel getcLabel() {
        return cLabel;
    }

    public JLabel getBrowseLabel() {
        return browseLabel;
    }
}
