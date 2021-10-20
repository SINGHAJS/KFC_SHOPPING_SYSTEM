package KFC_SHOPPING_SYSTEM;

import java.util.Observable;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class BrowseModel extends Observable {

    private final InventoryDB db;
    private BrowseData data = new BrowseData();
    private TreeSet<String> treeSet;
    private Vector<String> categoryHolder = new Vector<String>();
    private Vector<ProductItems> itemHolder = new Vector<ProductItems>();
    private CartList cart = new CartList();

    public BrowseModel() {
        db = new InventoryDB();
        db.createItemsTable();
    }

    public void categoryList() { //fills data with list of categories from DB and uses tree set to remove duplicate category name
        categoryHolder = this.db.getCategory();
        treeSet = new TreeSet(categoryHolder);
        categoryHolder.clear();
        categoryHolder.addAll(treeSet);
        data.categories = categoryHolder;
    }

    public void setCategoryFlag() {//flag to update view with new category list
        data.browseFlag = true;
        categoryList();
        data.items.clear();
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void unsetCategoryFlag() {//disables flag
        data.browseFlag = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void setCartFlag() {//flag to update view with new cart List
        data.cartFlag = true;
        cartList();
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void unsetCartFlag() {//disables flag
        data.cartFlag = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void itemsList(String categoryName) {//using input category it fills the data.items with item from the categroy
        itemHolder = this.db.getItems(categoryName);
        data.items = itemHolder;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public ProductItems getItemsList(int i) {//returns the tiem in the vector at specific index
        return data.items.get(i);
    }

    public void updateCart() {//updates quantity amount of cart
        data.count = cart.getTotalQuantity();
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void cartList() { //sets cart data
        data.cart = cart;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public CartList getCart() {//returns cart
        return cart;
    }
}
