package KFC_SHOPPING_SYSTEM;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class Cart {

    //ArrayList which can store multiple Product objects 
    private final Vector<Products> viewCart = new Vector<>();

    public Cart(){
        
    }
    //Method to add into arraylist
    public void addItem(Products o, double quantity) {
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

    public int getCartSize() {
        return this.viewCart.size();
    }

    public void removeItem(int index) {
        this.viewCart.remove(index);
    }

    public Products getProduct(int index) {
        return this.viewCart.get(index);
    }

    public double getUnitTotal() {
        double unitTotal = 0.0;
        for (Products o : this.viewCart) {
            unitTotal += o.getPrice() * o.getQuantity();
        }
        return unitTotal;
    }

    public void setCartQuantity(int index, double quantity) {
        this.viewCart.get(index).setQuantity(quantity);
    }

    public double getItemQuantity(int index) {
        return this.viewCart.get(index).getQuantity();
    }
    public Vector<String> returnCartItems(){
        Vector<String> itemNames = new Vector<String>();
        int count = 1;
        for (Products o: this.viewCart){
             itemNames.add(String.format("\n%1s %-15s %18.2f %30.2f %30.2f", "[" + count++ + "]", o.getItemName(), o.getQuantity(), o.getPrice(), o.getPrice() * o.getQuantity()));
        }
        return itemNames;
    }
    @Override
    public String toString() {
        int count = 1;
        String printer = "";
        for (Products o : this.viewCart) {
            printer += String.format("\n%1s %-15s %18.2f %30.2f %30.2f", "[" + count++ + "]", o.getItemName(), o.getQuantity(), o.getPrice(), o.getPrice() * o.getQuantity());
        }
        return printer;
    }
}
