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
 * @author singh
 */
public class BrowseView extends JFrame implements Observer {

    private final HeaderPanel headPanel;
    private final BrowsePanel browsePanel;
    private final CartPanel cartPanel;

    public BrowseView() {
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
        browsePanel.repaint();
        // this.repaint();
        this.setVisible(true);
    }

    public void bucketCounter(int count) {
        getBrowsePanel().bucketCounter(count);
        this.add(getBrowsePanel());
        this.revalidate();
        browsePanel.repaint();
        // this.repaint();
        this.setVisible(true);
    }

    public void cart(Vector<String> cart) {
        this.getContentPane().removeAll();
        this.back();
        getCartPanel().cart(cart);
        this.add(getCartPanel());
        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    public void back() {
        getHeaderPanel().back();
        this.add(headPanel);
        this.repaint();
        this.setVisible(true);
    }

    public void addMouseListener(MouseListener mouseListener) {
        getHeaderPanel().getBrowseLabel().addMouseListener(mouseListener);
        getHeaderPanel().getcLabel().addMouseListener(mouseListener);
        getHeaderPanel().getBackLabel().addMouseListener(mouseListener);
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
        System.out.println(data.categories);
        if (!data.items.isEmpty()) {
            this.itemsList(data.items);
            if (data.count != 0) {
                this.bucketCounter(data.count);
            }
            if(!data.cart.isEmpty()){
                this.cart(data.cart);
            }
        } else if (!data.categories.isEmpty()) {
            this.categoryList(data.categories);
        } 
    }
    public BrowsePanel getBrowsePanel() {
        return browsePanel;
    }
    public CartPanel getCartPanel() {
        return cartPanel;
    }
    public HeaderPanel getHeaderPanel(){
        return headPanel;
    }

}
