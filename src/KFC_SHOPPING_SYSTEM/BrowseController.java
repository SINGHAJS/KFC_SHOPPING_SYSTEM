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
        System.out.println(command);
        switch (command){
            case "ADD ITEM TO CART":
                
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent ex) { 
        
        if(ex.getValueIsAdjusting()){
            if (!this.view.getBrowsePanel().getCategoryList().isSelectionEmpty()){
             String categoryName = this.view.getBrowsePanel().getCategoryList().getSelectedValue().toString();
             System.out.println(categoryName);
            this.model.itemsList(categoryName);
            }
        }
        
    }
            
    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.getBrowseLabel())) {
            System.out.println("switching panel to browse");
            this.model.categoryList();
        } else if(o.equals(this.view.getcLabel())){
            System.out.println("switching panel to cart");
            //this.view.cart();
        } else if (o.equals(this.view.getBackLabel())){
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
