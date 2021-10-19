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
    private Cart cart = new Cart();
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
    }
    public void setCategoryFlag(){
        data.browseFlag = true;
        categoryList();
        data.items.clear();
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void unsetCategoryFlag(){
        data.browseFlag = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void setCartFlag(){
        data.cartFlag = true;
        cartList();
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void unsetCartFlag(){
        data.cartFlag = false;
this.setChanged();
        this.notifyObservers(this.data);
    }
    public void itemsList(String categoryName){
        i = this.db.getItems(categoryName);
        data.items = i;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void adminPage(){
        data.adminFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void updateCart(){
        data.count++;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void cartList(){
        data.cart = cart.returnCartItems();
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public Cart getCart() {
        return cart;
    }
}
