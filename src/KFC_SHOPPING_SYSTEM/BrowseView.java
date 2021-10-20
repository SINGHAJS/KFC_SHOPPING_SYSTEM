package KFC_SHOPPING_SYSTEM;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observer;
import java.util.Observable;
import java.util.Vector;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class BrowseView extends JFrame implements Observer {

    private final HeaderPanel headPanel;
    private final BrowsePanel browsePanel;
    private final CartPanel cartPanel;

    public BrowseView() {//establishes frame and intializes the panels used 
        this.setSize(1200, 800);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        browsePanel = new BrowsePanel();
        cartPanel = new CartPanel();
        headPanel = new HeaderPanel();
        back();
    }

    public void categoryList(Vector<String> clist) {//removes previous panel and shows the browsePanel with data being passed through panel method
        this.getContentPane().removeAll();
        this.back();
        getBrowsePanel().categoryList(clist);
        getBrowsePanel().setVisible(true);
        this.add(getBrowsePanel());
        this.revalidate();
        this.repaint();
    }

    public void itemsList(Vector<ProductItems> ilist) {//adds to panel with items list whose data is presented from panel method
        getBrowsePanel().itemsList(ilist);
        browsePanel.setVisible(true);
        this.add(getBrowsePanel());
        this.revalidate();
        this.repaint();
    }

    public void bucketCounter(int count) { //adds bucket label which uses its panel method which is added to frame
        getBrowsePanel().bucketCounter(count);
        this.add(getBrowsePanel());
        this.revalidate();
        browsePanel.setVisible(true);
        browsePanel.repaint();
        this.repaint();
    }

    public void cart(CartList cart) { //removes previous panel and updates cartlist to be displayed to user
        this.getContentPane().removeAll();
        this.back();
        getCartPanel().cart(cart);
        cartPanel.setVisible(true);
        this.add(getCartPanel());
        this.revalidate();
        this.repaint();
    }

    public void back() {// setsup headerpanel for user to interact with
        getHeaderPanel().back();
        this.add(headPanel);
        this.repaint();
    }
//all listeners for specific tasks to ping controller using user actions 
    public void addMouseListener(MouseListener mouseListener) {
        getHeaderPanel().getBrowseLabel().addMouseListener(mouseListener);
        getHeaderPanel().getcLabel().addMouseListener(mouseListener);
        getHeaderPanel().getBackLabel().addMouseListener(mouseListener);
    }

    public void addActionListener(ActionListener actionListener) {
        getBrowsePanel().getAddButton().addActionListener(actionListener);
        getCartPanel().getPlusButton().addActionListener(actionListener);
        getCartPanel().getMinusButton().addActionListener(actionListener);
        getCartPanel().getRemoveButton().addActionListener(actionListener);
    }

    public void addListSelectionListener(ListSelectionListener selectionListener) {
        getBrowsePanel().getCategoryList().addListSelectionListener(selectionListener);
        getBrowsePanel().getItemsList().getSelectionModel().addListSelectionListener(selectionListener);
        getCartPanel().getCartList().getSelectionModel().addListSelectionListener(selectionListener);
    }

    @Override
    public void update(Observable o, Object arg) { //updates panels and chooses the right panel to display using the flag and fills right data to each method
        BrowseData data = (BrowseData) arg;
        if (data.cartFlag) {
            this.browsePanel.setVisible(false);
            this.cart(data.cart);
        } else if (data.count != 0) {
            this.bucketCounter(data.count);
        }
        if (data.browseFlag) {
            if (!data.items.isEmpty()) {

                this.itemsList(data.items);
            } else if (data.browseFlag) {
                this.cartPanel.setVisible(false);
                this.categoryList(data.categories);
            }
        }
    }
//getters
    public BrowsePanel getBrowsePanel() {
        return browsePanel;
    }

    public CartPanel getCartPanel() {
        return cartPanel;
    }

    public HeaderPanel getHeaderPanel() {
        return headPanel;
    }

}
