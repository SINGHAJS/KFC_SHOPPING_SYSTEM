package KFC_SHOPPING_SYSTEM;

import java.text.NumberFormat;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class Products {

    private String category, itemName;  //Decalaring variables with access modifiers
    private double price, quantity;

    public Products(String category, String itemName, double price) { //constructor to create product object
        this.category = category;
        this.price = price;
        this.itemName = itemName;
        this.quantity = 0;
    }

    /*
   getters and setters for variables in product class
     */
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /*
        To string method to override when displaying a product
        With formatting to include '$' in front of price
     */
    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String itemPrice = currencyFormat.format(getPrice());
        String alignment = String.format("%-44s  %20s", getItemName().trim(), itemPrice.trim());
        return alignment;

    }
}
