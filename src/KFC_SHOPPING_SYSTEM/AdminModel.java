package KFC_SHOPPING_SYSTEM;

import java.util.Observable;
import java.util.Vector;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class AdminModel extends Observable {

    private AdminData data = new AdminData();
    public Vector<ProductItems> holder = new Vector<ProductItems>();
    private final InventoryDB db;

    public AdminModel() {
        this.db = new InventoryDB();
        this.db.createItemsTable();
    }

    public void getAllItems() { //fills data with all Items from DB and triggers Observer for updates
        holder = this.db.getEntireTable();
        data.allItems = this.holder;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void editItem(int id, boolean b) { //edits the availability of an item on the DB
        this.db.editItem(id + 1, b);
    }
}
