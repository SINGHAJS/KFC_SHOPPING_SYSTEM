package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class BrowseProduct extends KFCMenuOptions {

    public static Cart getCart() {
        return cart;
    }

    public static boolean cartEmpty() {
        return cart.getCart().isEmpty();

    }
    private static final Cart cart = new Cart();
    private static int buy;
    private static double amount;
    private static String scanned = "";
    private static boolean Oloop;
    private static boolean Iloop;
    private static int input = 0;
    private static String chooseC = "";

    public static void selectProduct() {
        Oloop = true;
        Iloop = true;
        updateMenu();
        while (Oloop) {
            chooseC = chooseCategory();
            try {
                input = Integer.parseInt(chooseC.trim());
                if (input > 7 || input < 0) {
                    System.out.println("\n[Invalid Input] - Enter number between 0-7");
                    Iloop = false;
                } else if (input == 0) {
                    Iloop = false;
                    Oloop = false;
                } else {
                    Iloop = true;
                }
            } catch (NumberFormatException e) {
                if (scanned.equalsIgnoreCase("x")) {
                    System.exit(0);
                } else {
                    System.out.println("\n[Invalid Input] - Enter number between 0-7");
                    Iloop = false;
                }
            }

            String category = getCategory(input);
            while (Iloop) {
                System.out.println("______________________________________________________________________");
                System.out.println("\n                            " + category);
                System.out.println("                                                        Type x to exit");
                System.out.println("______________________________________________________________________");
                System.out.println("Add to cart using ID                                          [0] Back\n");
                System.out.println("ID  Name                                                         Price");
                System.out.println("__  ____                                                         _____");
                printCategory(category);
                System.out.print("\n[YOUR INPUT]:");
                scanned = scan.next();
                try {
                    buy = Integer.parseInt(scanned.trim());
                    if (buy <= getcItems().size() && buy > 0) {
                        System.out.println("______________________________________________________________________");
                        System.out.println("Item " + buy + " seleced, Amount?                                 Type x to exit");
                        System.out.print("\n[YOUR INPUT]:");
                        scanned = scan.next();
                        try {
                            amount = Double.parseDouble(scanned.trim());
                            if (amount > 0) {
                                getCart().addItem(getcItems().get(buy - 1), amount);
                                clearcItems();
                                System.out.println("______________________________________________________________________");
                                System.out.println("\nItem " + buy + " added to cart");
                            } else if (amount < 0) {
                                System.out.println("[Please enter a number above 0]");
                            }
                        } catch (NumberFormatException e) {
                            if (scanned.equalsIgnoreCase("x")) {
                                System.exit(0);
                            } else {
                                System.out.println("______________________________________________________________________");
                                System.out.println("[Please enter a number above 0]");
                                clearcItems();
                            }
                        }

                    } else if (buy > getcItems().size() || buy < 0) {
                        System.out.println("______________________________________________________________________");
                        System.out.println("\n[Invalid Input Please Try Again]\nPlease Enter number between 0-" + getcItems().size());
                        clearcItems();
                    } else if (buy == 0) {
                        Iloop = false;
                        clearcItems();
                    }
                } catch (NumberFormatException e) {
                    if (scanned.equalsIgnoreCase("x")) {
                        System.exit(0);
                    } else {
                        System.out.println("______________________________________________________________________");
                        System.out.println("\n[Invalid Input Please Try Again]\nPlease Enter number between 0-" + getcItems().size());
                        clearcItems();
                    }
                }
            }
        }
    }
}
