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

    public BrowseController(BrowseModel model, BrowseView view) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
        this.view.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
    }

    @Override
    public void valueChanged(ListSelectionEvent ex) { 
        String category = (String) this.view.getCategory().getSelectedValue();
          System.out.println(category);
       if(!ex.getValueIsAdjusting()){
           System.out.println("valuechangeed");
          // System.out.println((String)this.view.getCategory().getSelectedValue());
          // System.out.println(ex.);
         // String category = (String) this.view.getCategory().getSelectedValue();
          //System.out.println(category);
          if (category != null){
         // this.model.itemsList(category);
          }
         // System.out.println(ex.getSource().equals(this.view.getCategory()));
       }
    }
            
    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getSource();
        if (o.equals(this.view.getBrowseLabel())) {
            System.out.println("switching panel to browse");
            this.view.browse();
            this.model.categoryList();
            this.view.addListSelectionListener(this);
          //  view.browse();
        } else if(o.equals(this.view.getcLabel())){
            System.out.println("switching panel to cart");
            view.cart();
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
