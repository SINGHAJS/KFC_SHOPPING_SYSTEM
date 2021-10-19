package KFC_SHOPPING_SYSTEM;

import java.util.Vector;

/**
 *
 * @author singh
 */
public class BrowseData {
    boolean browseFlag = false;
    boolean cartFlag = false;
    boolean adminFlag = false;
    boolean itemListFlag = false;
    int count = 0;
    Vector<String> categories = new Vector<String>();
    Vector<Products> items = new Vector<Products>();
    Vector<String> cart = new Vector<String>();
}
