package KFC_SHOPPING_SYSTEM;

import java.util.Observable;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author singh
 */
public class BrowseModel extends Observable{
    private final InventoryDB db;
    private BrowseData data = new BrowseData();
    private TreeSet<String> treeSet;
    private Vector<String> v = new Vector<String>();
    private Vector<Products> i = new Vector<Products>();
    
    public BrowseModel(){
        db = new InventoryDB();
        db.createItemsTable();
    }
    public void categoryList(){
        v = this.db.getCategory();
        treeSet = new TreeSet(v);
        v.clear();        
        v.addAll(treeSet);
        data.categories = v;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void itemsList(String categoryName){
        i = this.db.getItems(categoryName);
        data.items = i;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
}
