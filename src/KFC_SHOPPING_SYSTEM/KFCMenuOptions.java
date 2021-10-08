package KFC_SHOPPING_SYSTEM;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
abstract class KFCMenuOptions {

    public static ArrayList<Products> getcItems() {
        return cItems;
    }

    public static void clearcItems() {
        cItems.clear();
    }
    public static Scanner scan = new Scanner(System.in); //change to prive))))))))))))))))))))))))
    private static ArrayList<Products> menuItems = new ArrayList<>();
    private static ArrayList<String> list = new ArrayList<>();
    private static ArrayList<Products> cItems = new ArrayList<>();
    private static final String KFC_MENU = "./resources/KFC_MENU.txt";
    private static String scanned = "";

    public static void updateMenu() {
        getList().clear();
        menuItems.clear();
        list = File_IO.readFile(KFC_MENU);
        for (int i = 0; i < getList().size(); i++) {
            String[] seperate = getList().get(i).split(",");
            getMenuItems().add(new Products(seperate[0], seperate[1], Double.parseDouble(seperate[2])));
        }
    }

    public static String chooseCategory() {
        int input = 0;
        System.out.println("______________________________________________________________________");
        System.out.println("                            Choose a cateogry");
        System.out.println("                                                        Type x to exit");
        System.out.println("______________________________________________________________________");
        System.out.println("\n[0] Go Back\n[1] Buckets\n[2] Individual Meals\n[3] Burgers\n[4] Twisters & Salad\n[5] Snacks\n[6] Sides\n[7] Drinks & Desserts");
        System.out.print("\n[YOUR INPUT]: ");
        setScanned(scan.next());
        return getScanned();
    }

    public static void printCategory(String category) {
        int count = 0;
        updateMenu();
        for (Products p : getMenuItems()) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                count++;
                getcItems().add(p);
                String format = String.format("%02d", count);
                System.out.println(format + "| " + p);
            }
        }
    }

    public static String getCategory(int input) {
        String category = "";
        switch (input) {
            case 1:
                category = "Buckets";
                break;
            case 2:
                category = "Individual Meals";
                break;
            case 3:
                category = "Burgers";
                break;
            case 4:
                category = "Twisters & Salad";
                break;
            case 5:
                category = "Snacks";
                break;
            case 6:
                category = "Sides";
                break;
            case 7:
                category = "Drinks & Desserts";
                break;
        }
        return category;
    }

    public static ArrayList<String> getList() {
        return list;
    }

    public static void addList(String item) {
        list.add(item);
    }

    public static ArrayList<Products> getMenuItems() {
        return menuItems;
    }

    public static void setMenuItems(ArrayList<Products> aMenuItems) {
        menuItems = aMenuItems;
    }

    /**
     * @return the scanned
     */
    public static String getScanned() {
        return scanned;
    }

    /**
     * @param aScanned the scanned to set
     */
    public static void setScanned(String aScanned) {
        scanned = aScanned;
    }
}
