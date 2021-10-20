package KFC_SHOPPING_SYSTEM;

import java.util.Vector;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class BrowseData {

    boolean browseFlag = false;
    boolean cartFlag = false;
    boolean itemListFlag = false;
    int count = 0;
    Vector<String> categories = new Vector<String>();
    Vector<ProductItems> items = new Vector<ProductItems>();
    CartList cart = new CartList();
}
