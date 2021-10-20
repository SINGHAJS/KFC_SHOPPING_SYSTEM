package KFC_SHOPPING_SYSTEM;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Ajit_Singh ID: 19070642
 * @author Rohit_Singh ID:17981754
 */
public class AdminController implements ListSelectionListener {

    public AdminModel model;
    public AdminView view;

    public AdminController(AdminModel model, AdminView view) {
        this.model = model;
        this.view = view;
        this.view.addListSelectionListener(this);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        for (int i = 0; i < this.view.getEditor().getRowCount(); i++) {
            if (this.view.getEditor().getValueAt(i, 3).equals(Boolean.FALSE)) {
                this.model.editItem(i, false);
            } else if (this.view.getEditor().getValueAt(i, 3).equals(Boolean.TRUE)) {
                this.model.editItem(i, true);
            }
        }
    }

}
