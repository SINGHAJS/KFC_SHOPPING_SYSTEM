package KFC_SHOPPING_SYSTEM;

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
public class AdminController implements ListSelectionListener, MouseListener {

    public AdminModel model;
    public AdminView view;
    public LoginView upperView;
    
    public AdminController(AdminModel model, AdminView view,LoginView upperView) {
        this.model = model;
        this.view = view;
        this.upperView = upperView;
        this.view.addListSelectionListener(this);
        this.view.addMouseListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) { //when a table cell is edited (checkbox), it updates the DB with new parameter.
        for (int i = 0; i < this.view.getEditor().getRowCount(); i++) {
            if (this.view.getEditor().getValueAt(i, 3).equals(Boolean.FALSE)) {
                this.model.editItem(i, false);
            } else if (this.view.getEditor().getValueAt(i, 3).equals(Boolean.TRUE)) {
                this.model.editItem(i, true);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       Object o = e.getSource();
       if(o.equals(this.view.getBackLabel())){
            this.upperView.aLoginPageFrame.setVisible(true);
            this.view.setVisible(false);
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
