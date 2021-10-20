package KFC_SHOPPING_SYSTEM;

import java.text.NumberFormat;
import java.util.Vector;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class CartList extends Cart {

    //Vector which can store multiple Product objects
    private final Vector<ProductItems> viewCart = new Vector<>();
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public CartList() {

    }
    //Method to add into vector
    @Override
    public void addItem(ProductItems o, double quantity) {
        if (this.viewCart.contains(o)) {
            o.setQuantity(o.getQuantity() + quantity);
        } else {
            o.setQuantity(quantity);
            this.viewCart.add(o);
        }
    }

    public Vector getCart() {//returns cart
        return this.viewCart;
    }

    @Override
    public int getCartSize() {//returns cart size
        return this.viewCart.size();
    }

    @Override
    public void removeItem(int index) {//removes item at specific index
        this.viewCart.remove(this.viewCart.get(index));
    }

    @Override
    public ProductItems getProduct(int index) {//returns item at specific index
        return this.viewCart.get(index);
    }

    @Override
    public String getUnitTotal() {//returns grand total of cart
        double unitTotal = 0.0;
        for (ProductItems o : this.viewCart) {
            unitTotal += o.getPrice() * o.getQuantity();
        }
        String totalPrice = currencyFormat.format(unitTotal);
        return totalPrice;
    }

    public String getSubTotal(int index) { //gets sub total for the selected item with the quantity amount

        String itemPrice = currencyFormat.format(this.viewCart.get(index).getPrice() * getItemQuantity(index));
        return itemPrice;
    }

    @Override
    public void setCartQuantity(int index, double quantity) { //updates cart items quantity 
        this.viewCart.get(index).setQuantity(quantity);
    }

    public int getTotalQuantity() {//returns total quantity of all items in cart
        int totalQuantity = 0;
        for (ProductItems o : this.viewCart) {
            totalQuantity += o.getQuantity();
        }
        return totalQuantity;
    }

    @Override
    public double getItemQuantity(int index) { //returns specific items quantity
        return this.viewCart.get(index).getQuantity();
    }
}
