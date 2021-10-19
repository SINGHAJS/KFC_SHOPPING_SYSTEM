package KFC_SHOPPING_SYSTEM;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class CartList extends Cart {

    //ArrayList which can store multiple Product objects
    private final Vector<ProductItems> viewCart = new Vector<>();
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public CartList() {

    }

    //Method to add into arraylist
    @Override
    public void addItem(ProductItems o, double quantity) {
        if (this.viewCart.contains(o)) {
            o.setQuantity(o.getQuantity() + quantity);
        } else {
            o.setQuantity(quantity);
            this.viewCart.add(o);
        }
    }

    public Vector getCart() {
        return this.viewCart;
    }

    @Override
    public int getCartSize() {
        return this.viewCart.size();
    }

    @Override
    public void removeItem(int index) {
        this.viewCart.remove(index + 1);
    }

    @Override
    public ProductItems getProduct(int index) {
        return this.viewCart.get(index);
    }

    @Override
    public String getUnitTotal() {
        double unitTotal = 0.0;
        for (ProductItems o : this.viewCart) {
            unitTotal += o.getPrice() * o.getQuantity();
        }
        String totalPrice = currencyFormat.format(unitTotal);
        return totalPrice;
    }

    public String getSubTotal(int index) {

        String itemPrice = currencyFormat.format(this.viewCart.get(index).getPrice() * getItemQuantity(index));
        return itemPrice;
    }

    @Override
    public void setCartQuantity(int index, double quantity) {
        this.viewCart.get(index).setQuantity(quantity);
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (ProductItems o : this.viewCart) {
            totalQuantity += o.getQuantity();
        }
        return totalQuantity;
    }

    @Override
    public double getItemQuantity(int index) {
        return this.viewCart.get(index).getQuantity();
    }

    public Vector<String> returnCartItems() {
        Vector<String> itemNames = new Vector<String>();
        int count = 1;
        for (ProductItems o : this.viewCart) {
            itemNames.add(String.format("\n%1s %-15s %18.2f %30.2f %30.2f", "[" + count++ + "]", o.getItemName(), o.getQuantity(), o.getPrice(), o.getPrice() * o.getQuantity()));
        }
        return itemNames;
    }

    @Override
    public String toString() {
        int count = 1;
        String printer = "";
        for (ProductItems o : this.viewCart) {
            printer += String.format("\n%1s %-15s %18.2f %30.2f %30.2f", "[" + count++ + "]", o.getItemName(), o.getQuantity(), o.getPrice(), o.getPrice() * o.getQuantity());
        }
        return printer;
    }
}
