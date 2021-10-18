package KFC_SHOPPING_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observer;
import java.util.Observable;
import java.util.Vector;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author singh
 */
public class BrowseView extends JFrame implements Observer {

    private final JPanel headPanel = new JPanel();
    private final BrowsePanel browsePanel;
    private final CartPanel cartPanel;
    
    private final JLabel browseLabel = new JLabel("BROWSE MENU");
    private final JLabel cLabel = new JLabel("VIEW CART");
    private final JLabel backLabel = new JLabel("Back to LoginPage");

    public BrowseView() {
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        back();
        browsePanel = new BrowsePanel();
        cartPanel = new CartPanel();
    }

    public static void main(String[] args) {

        BrowseView g = new BrowseView();
        Vector<String> lists = new Vector<>();
        lists.add("Buckets");
        lists.add("Individual Meals");
        lists.add("Burgers");
        lists.add("Twisters & Salad");
        lists.add("Snacks");
        lists.add("Sides");
        lists.add("Drinks & Desserts");

        //g.cart(lists);
        // g.browse();
        g.categoryList(lists);
        Vector<Products> items = new Vector<>();
        items.add(new Products("SUCK", "YOUR", 69));
        items.add(new Products("SUCK", "YOUR", 69));
        items.add(new Products("SUCK", "YOUR", 69));
        items.add(new Products("SUCK", "YOUR", 69));
        items.add(new Products("SUCK", "YOUR", 69));
        items.add(new Products("SUCK", "Colonel Ultimate Burger Meal", 16.59));
        //g.itemsList(items);
        //lists.add("HEY");
        // g.categoryList(lists);

    }

    public void categoryList(Vector<String> clist) {
        this.getContentPane().removeAll();
        this.back();
        getBrowsePanel().categoryList(clist);
        this.add(getBrowsePanel());
        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    public void itemsList(Vector<Products> ilist) {
        getBrowsePanel().itemsList(ilist);
        this.add(getBrowsePanel());
        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    public void cart(Vector<String> items) {
        this.getContentPane().removeAll();
        this.back();
        getCartPanel().cart(items);
        this.add(getCartPanel());
        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    public void back() {

        headPanel.setBackground(Color.DARK_GRAY);
        headPanel.setBounds(0, 0, 1200, 30);
        headPanel.setLayout(null);

        browseLabel.setFont(new Font("", Font.BOLD, 20));
        browseLabel.setForeground(Color.WHITE);
        browseLabel.setBounds(400, 0, 200, 30);

        cLabel.setFont(new Font("", Font.BOLD, 20));
        cLabel.setForeground(Color.WHITE);
        cLabel.setBounds(625, 0, 200, 30);

        backLabel.setFont(new Font("", Font.BOLD, 20));
        backLabel.setForeground(Color.WHITE);
        backLabel.setBounds(20, 0, 200, 30);

        headPanel.add(cLabel);
        headPanel.add(browseLabel);
        headPanel.add(backLabel);

        this.add(headPanel);
        this.repaint();
        this.setVisible(true);
    }

    public void addMouseListener(MouseListener mouseListener) {
        this.browseLabel.addMouseListener(mouseListener);
        this.cLabel.addMouseListener(mouseListener);
        this.backLabel.addMouseListener(mouseListener);
    }

    public void addActionListener(ActionListener actionListener) {
        getBrowsePanel().getAddButton().addActionListener(actionListener);
    }

    public void addListSelectionListener(ListSelectionListener selectionListener) {
        getBrowsePanel().getCategoryList().addListSelectionListener(selectionListener);
        getBrowsePanel().getItemsList().addListSelectionListener(selectionListener);

    }

    @Override
    public void update(Observable o, Object arg) {
        BrowseData data = (BrowseData) arg;
        System.out.println(data.items.isEmpty());
        if (!data.items.isEmpty()) {
            System.out.println("hi");
            this.itemsList(data.items);
        } else if (!data.categories.isEmpty()) {
            System.out.println("displaying list");
            this.categoryList(data.categories);
        } else if (data.adminFlag) {
            this.setVisible(false);
        }

    }

    public JLabel getBrowseLabel() {
        return browseLabel;
    }

    public JLabel getBackLabel() {
        return backLabel;
    }

    public JLabel getcLabel() {
        return cLabel;
    }

    /**
     * @return the browsePanel
     */
    public BrowsePanel getBrowsePanel() {
        return browsePanel;
    }

    public CartPanel getCartPanel() {
        return cartPanel;
    }

}
