package KFC_SHOPPING_SYSTEM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author singh
 */
public class BrowseController implements ActionListener, MouseListener, ListSelectionListener {

    public BrowseModel model;
    public BrowseView view;
    public AdminView view2;
    public BrowseController(BrowseModel model, BrowseView view) {
        this.view = view;
        this.model = model;
        view2 = new AdminView();
        this.view.addListSelectionListener(this);
        this.view.addActionListener(this);
        this.view.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "ADD ITEM TO CART":
                    this.model.getCart().addItem((Products) this.view.getBrowsePanel().getItemsList().getSelectedValue(), 1);
                    System.out.println(this.model.getCart().toString());
                    this.model.updateCart();
                    this.view.getBrowsePanel().getItemsList().clearSelection();
                    
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent ex) { 
        Object o = ex.getSource();
        if (ex.getValueIsAdjusting()){
            if (o.equals(this.view.getBrowsePanel().getCategoryList())){
                String categoryName = this.view.getBrowsePanel().getCategoryList().getSelectedValue().toString();
                System.out.println(categoryName);
                this.model.itemsList(categoryName);
            }else if (o.equals(this.view.getBrowsePanel().getItemsList())){
                this.view.getBrowsePanel().getAddButton().setEnabled(true);
            }
        }      
    }
            
    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.getHeaderPanel().getBrowseLabel())) {
            System.out.println("switching panel to browse");
            this.model.unsetCartFlag();
            this.model.setCategoryFlag();
        } else if(o.equals(this.view.getHeaderPanel().getcLabel())){
            if(this.model.getCart().getCartSize() != 0){
            System.out.println("switching panel to cart");
            this.model.unsetCategoryFlag();
            this.model.setCartFlag();}
        } else if (o.equals(this.view.getHeaderPanel().getBackLabel())){
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
