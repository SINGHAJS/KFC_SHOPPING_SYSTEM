package KFC_SHOPPING_SYSTEM;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 */
public class ProductReciept {

    private static Scanner scan = new Scanner(System.in);
    private static String scanned = "";

    public static void viewProductReciept() {
        boolean Oloop = true;
        int input = 0;
        int id = 0;
        double nQuantity = 0;
        if (BrowseProduct.cartEmpty()) {
            Oloop = false;
            System.out.println("______________________________________________________________________");
            System.out.println("                              Cart Empty");
            System.out.println("                    Add items to cart to view reciept");
        }
        while (Oloop) {
            print();
            System.out.println();
            System.out.println("______________________________________________________________________");

            System.out.println("\n[0]Go Back\n[1]Checkout\n[2]Change Quantity\n[3]Remove Item");
            try {
                scanned = scan.next();
                input = Integer.parseInt(scanned.trim());

                if (input < 0 || input > 3) {
                    System.out.println("[INPUT A NUMBER BETWEEN 0 - 3]");
                } else if (input == 0) {
                    Oloop = false;
                } else if (input > 0 || input <= 3) {
                    switch (input) {
                        case 0:
                            Oloop = false;
                            break;
                        case 1:
                            System.out.println("[ORDER CONFIRMED]");
                            break;
                        case 2:
                            System.out.println("[CHOOSE ITEM BY ID]");
                            try {
                                scanned = scan.next();
                                id = Integer.parseInt(scanned.trim());
                                if (id > BrowseProduct.getCart().getCartSize() || id < 0) {
                                    System.out.println("[INVALID INPUT, ENTER VALUE BETWEEN 0 - " + BrowseProduct.getCart().getCartSize() + "]");
                                } else if (id <= BrowseProduct.getCart().getCartSize() + 1 && id > 0) {
                                    System.out.println("New Quantity?");

                                    try {
                                        scanned = scan.next();
                                        nQuantity = Double.parseDouble(scanned.trim());
                                        if (nQuantity < 1) {
                                            System.out.println("[INVALID INPUT, ENTER VALUE OF ITEM " + id + " FROM 1 TO " + BrowseProduct.getCart().getItemQuantity(id) + "]");
                                        } else if (nQuantity > 0) {
                                            BrowseProduct.getCart().setCartQuantity(id - 1, nQuantity);
                                        } else {
                                            System.out.println("[INVALID INPUT, ENTER VALUE OF ITEM " + id + " FROM 1 TO " + BrowseProduct.getCart().getItemQuantity(id) + "]");
                                        }
                                    } catch (NumberFormatException | InputMismatchException e) {
                                        if (scanned.equalsIgnoreCase("x")) {
                                            System.exit(0);
                                        } else {
                                            System.out.println("[INVALID INPUT ENTER VALUE OF ITEM " + id + " FROM 1 TO " + BrowseProduct.getCart().getItemQuantity(id) + "]");
                                        }
                                    }

                                } else {
                                    System.out.println("[INVALID INPUT, ENTER VALUE BETWEEN 0 - " + BrowseProduct.getCart().getCartSize() + "]");
                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                if (scanned.equalsIgnoreCase("x")) {
                                    System.exit(0);
                                } else {
                                    System.out.println("[INVALID INPUT ENTER VALUE BETWEEN 0 - " + BrowseProduct.getCart().getCartSize() + "]");
                                }
                            }

                            break;
                        case 3:
                            System.out.println("[CHOOSE ITEM BY [ID] TO REMOVE]                                                Enter [0] to go back");
                            try {
                                scanned = scan.next();
                                id = Integer.parseInt(scanned.trim());
                                if (id > BrowseProduct.getCart().getCartSize() || id < 0) {
                                    System.out.println("[INVALID INPUT ENTER VALUE BETWEEN 0 - " + BrowseProduct.getCart().getCartSize() + "]");
                                } else if (id <= BrowseProduct.getCart().getCartSize() + 1 && id > 0) {
                                    BrowseProduct.getCart().removeItem(id - 1);
                                } else if (id != 0) {

                                    System.out.println("[INVALID INPUT ENTER VALUE BETWEEN 0 - " + BrowseProduct.getCart().getCartSize() + "]");
                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                if (scanned.equalsIgnoreCase("x")) {
                                    System.exit(0);
                                } else {
                                    System.out.println("[INVALID INPUT ENTER VALUE BETWEEN 0 - " + BrowseProduct.getCart().getCartSize() + "]");
                                }
                            }

                            break;
                        default:
                            Oloop = false;
                            break;
                    }
                } else {
                    System.out.println("[INPUT A NUMBER BETWEEN 0 - 3]");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                if (scanned.equalsIgnoreCase("x")) {
                    System.exit(0);
                } else {
                    System.out.println("[INPUT A NUMBER BETWEEN 0 - 3]");
                }
            }
        }
    }

    public static void print() {

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String spaced = String.format("%55s", "KFC NZ");
        spaced += String.format("\n%59s", "AUT University");
        spaced += String.format("\n%56s", "Auckland");
        spaced += String.format("\n%66s", "Reciept #987654321 GST:12345");
        spaced += String.format("\n%50s", "----------------------------------------------------------------------------------------------------");
        spaced += String.format("\n%1s %1s %30s %30s %30s \n", "ID", "Name", "Quantity", "Unit Price", "SubTotal");
        spaced += String.format("\n%50s", "----------------------------------------------------------------------------------------------------");
        System.out.println(spaced + BrowseProduct.getCart());
        spaced = String.format("\n%50s", "----------------------------------------------------------------------------------------------------");
        spaced += String.format("\n%-93s %-12s", "Total", currencyFormat.format(BrowseProduct.getCart().getUnitTotal()));
        System.out.println(spaced);

    }
}
