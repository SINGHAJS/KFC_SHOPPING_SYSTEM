package KFC_SHOPPING_SYSTEM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class BrowseController implements ActionListener, MouseListener, ListSelectionListener {

    public BrowseModel model;
    public BrowseView view;
    public AdminView view2;

    public BrowseController(BrowseModel model, BrowseView view) {
        this.view = view;
        this.model = model;
        //view2 = new AdminView();
        this.view.addListSelectionListener(this);
        this.view.addActionListener(this);
        this.view.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int cartListRow = this.view.getCartPanel().getCartList().getSelectedRow();
        int itemListRow = this.view.getBrowsePanel().getItemsList().getSelectedRow();
        System.out.println(cartListRow);
        switch (command) {
            case "ADD ITEM TO CART":
                this.model.getCart().addItem(this.model.getItemsList(itemListRow), 1);
                this.model.updateCart();
                this.view.getBrowsePanel().getItemsList().clearSelection();
                break;
            case "+":
                this.model.getCart().addItem(this.model.getCart().getProduct(cartListRow), 1);
                this.model.setCartFlag();
                this.view.getCartPanel().getCartList().clearSelection();
                break;
            case "-":
                this.model.getCart().addItem(this.model.getCart().getProduct(cartListRow), -1);
                this.model.setCartFlag();
                this.view.getCartPanel().getCartList().clearSelection();
                break;
            case "Remove Item":
                this.model.getCart().removeItem(cartListRow);
                this.model.setCartFlag();
                this.view.getCartPanel().getCartList().clearSelection();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent ex) {
        Object o = ex.getSource();

        if (ex.getValueIsAdjusting()) {
            if (o.equals(this.view.getBrowsePanel().getCategoryList())) {

                String categoryName = this.view.getBrowsePanel().getCategoryList().getSelectedValue().toString();
                System.out.println(categoryName);
                this.model.itemsList(categoryName);
            } else if (o.equals(this.view.getBrowsePanel().getItemsList().getSelectionModel())) {
                this.view.getBrowsePanel().getAddButton().setEnabled(true);
            } else if (o.equals(this.view.getCartPanel().getCartList().getSelectionModel())) {
                int cartListRow = this.view.getCartPanel().getCartList().getSelectedRow();
                if (cartListRow >= 0) {
                    this.view.getCartPanel().getPlusButton().setEnabled(true);
                    this.view.getCartPanel().getRemoveButton().setEnabled(true);
                    if (this.model.getCart().getProduct(cartListRow).getQuantity() > 1) {
                        this.view.getCartPanel().getMinusButton().setEnabled(true);
                    }
                }
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.getHeaderPanel().getBrowseLabel())) {
            System.out.println("switching panel to browse");
            this.model.unsetCartFlag();
            this.model.updateCart();
            this.model.setCategoryFlag();
        } else if (o.equals(this.view.getHeaderPanel().getcLabel())) {
            if (this.model.getCart().getCartSize() != 0) {
                System.out.println("switching panel to cart");
                this.model.unsetCategoryFlag();
                this.model.setCartFlag();
            }
        } else if (o.equals(this.view.getHeaderPanel().getBackLabel())) {
            System.out.println("Switching back");
            this.model.adminPage();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
