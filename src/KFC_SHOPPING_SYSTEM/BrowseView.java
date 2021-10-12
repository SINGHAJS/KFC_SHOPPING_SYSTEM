package KFC_SHOPPING_SYSTEM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author singh
 */
public class BrowseView extends JFrame implements Observer {

    private final JPanel headPanel = new JPanel();

    private final JPanel browsePanel = new JPanel();
    private final JPanel cartPanel = new JPanel();

    private final JLabel browseLabel = new JLabel("BROWSE MENU");
    private final JLabel cLabel = new JLabel("VIEW CART");
    private final JLabel backLabel = new JLabel("Back to LoginPage");
    private final JLabel chooseC = new JLabel("CHOOSE A CATEGORY: ");
    private final JLabel pickItem = new JLabel("PICK AN ITEM");

    private ListSelectionModel listselectionmodel;
    private JScrollPane jcpCategory = new JScrollPane();
    private JScrollPane jcpItems = new JScrollPane();
    private JList category = new JList();
    private JList items = new JList();

    public static void main(String[] args) {
        BrowseView g = new BrowseView();
        Vector<String> lists = new Vector<>();
        lists.add("fffffffff");
        lists.add("abcedefoeioiifg");
        g.browse();
        g.categoryList(lists);
        Vector<Products> i = new Vector<>();
        i.add(new Products("abc", "rohit", 9.99));
        i.add(new Products("abc", "rohit", 9.99));
        i.add(new Products("abc", "rohit", 9.99));
        
        g.itemsList(i);
    }

    public BrowseView() {
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        back();
    }

    public void browse() {
        browsePanel.setBackground(Color.WHITE);
        browsePanel.setBounds(0, 30, 1200, 770);
        browsePanel.setLayout(null);

        this.getContentPane().remove(cartPanel);
        //when view connected with main add repaint

    }

    public void categoryList(Vector<String> clist) {
        chooseC.setFont(new Font("", Font.BOLD, 15));
        chooseC.setForeground(Color.BLACK);
        chooseC.setBounds(50, 5, 200, 50);

        category = new JList(clist);
        category.setForeground(Color.WHITE);
        category.setBackground(Color.DARK_GRAY);
        category.setSelectionBackground(Color.lightGray);
        category.setSelectionBackground(Color.lightGray);

        category.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listselectionmodel = category.getSelectionModel();
        
        jcpCategory = new JScrollPane(category, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jcpCategory.setBounds(50, 50, 200, 300);
        browsePanel.add(jcpCategory);
        browsePanel.add(chooseC);
        this.add(browsePanel);
        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    public void itemsList(Vector<Products> ilist) {
        pickItem.setFont(new Font("", Font.BOLD, 15));
        pickItem.setForeground(Color.BLACK);
        pickItem.setBounds(300, 5, 200, 50);

        items = new JList(ilist);
        items.setForeground(Color.WHITE);
        items.setBackground(Color.DARK_GRAY);
        items.setSelectionBackground(Color.lightGray);
        items.setSelectionBackground(Color.lightGray);

        items.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jcpItems = new JScrollPane(items, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jcpItems.setBounds(300, 50, 230, 300);

        browsePanel.add(pickItem);
        browsePanel.add(jcpItems);

        this.add(browsePanel);
        this.revalidate();
        this.repaint();
        this.setVisible(true);

    }

    public void back() {
        headPanel.setBackground(Color.DARK_GRAY);
        headPanel.setBounds(0, 0, 1200, 30);
        headPanel.setLayout(null);

        browseLabel.setFont(new Font("", Font.BOLD, 13));
        browseLabel.setForeground(Color.WHITE);
        browseLabel.setBounds(475, 0, 100, 30);

        cLabel.setFont(new Font("", Font.BOLD, 13));
        cLabel.setForeground(Color.WHITE);
        cLabel.setBounds(625, 0, 100, 30);

        backLabel.setFont(new Font("", Font.BOLD, 13));
        backLabel.setForeground(Color.WHITE);
        backLabel.setBounds(20, 0, 150, 30);

        headPanel.add(cLabel);
        headPanel.add(browseLabel);
        headPanel.add(backLabel);

        this.add(headPanel);

    }

    public void items() {

        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    public void cart() {
        cartPanel.setBackground(Color.BLUE);
        cartPanel.setBounds(0, 30, 1200, 770);
        cartPanel.setLayout(null);

        //cButton.setBounds(600, 400, 100, 300);
        //cartPanel.add(cButton);
        this.getContentPane().remove(browsePanel);
        cartPanel.setVisible(true);

        this.add(cartPanel);
        this.revalidate();
        this.repaint();
    }

    public void addMouseListener(MouseListener listener) {
        this.browseLabel.addMouseListener(listener);
        this.cLabel.addMouseListener(listener);
    }

    public void addActionListener(ActionListener listener) {

    }

    public void addListSelectionListener(ListSelectionListener listener) {
       //this.category.addListSelectionListener(listener);
        this.listselectionmodel.addListSelectionListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        BrowseData data = (BrowseData) arg;
        System.out.println(data.categories.isEmpty());
        System.out.println(data.items);
        System.out.println(data.items.isEmpty());
        System.out.println("-----------");
            if (!data.categories.isEmpty()) {
            this.categoryList(data.categories);
            if(!data.items.isEmpty()){
               // this.itemsList(data.items);
            }
        }else if (!data.items.isEmpty()) {
            System.out.println("n");
           // this.itemsList(data.items);
        }
    }

    public JList getCategory() {
        return category;
    }

    public JLabel getBrowseLabel() {
        return browseLabel;
    }

    public JLabel getcLabel() {
        return cLabel;
    }

}
