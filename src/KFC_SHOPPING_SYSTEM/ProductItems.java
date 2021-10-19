package KFC_SHOPPING_SYSTEM;

import java.text.NumberFormat;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class ProductItems extends Products {

    public ProductItems(String category, String itemName, double price) { //constructor to create product object
        super(category, itemName, price);
    }

    public String getItemPrice() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String itemPrice = currencyFormat.format(getPrice());
        return itemPrice;
    }
}
