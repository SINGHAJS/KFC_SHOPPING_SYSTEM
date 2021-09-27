package KFC_SHOPPING_SYSTEM;

import java.util.InputMismatchException;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class Manager extends KFCMenuOptions {

    private static boolean Oloop = true;
    private static boolean Iloop = true;
    private static boolean lloop = true;
    public static Cart cart = new Cart();
    private static final String fName = "./resources/KFC_MENU.txt";
    private static int input = 0;
    private static String iName = " ";

    public static void addInventory() {
        updateMenu();
        Oloop = true;
        Iloop = true;
        while (Oloop) {
            try {
                input = Integer.parseInt(chooseCategory().trim());
                if (input > 7 || input < 0) {
                    System.out.println("\n[Invalid Input] - Enter number between 0-7");
                    Iloop = false;
                } else if (input == 0) {
                    Iloop = false;
                    Oloop = false;
                } else {
                    Iloop = true;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                if (getScanned().equalsIgnoreCase("x")) {
                    System.exit(0);
                } else {
                    System.out.println("\n[Invalid Input] - Enter number between 0-7");
                    Iloop = false;
                }
            }
            String category = getCategory(input);
            input = 0;
            while (Iloop) {
                System.out.println("______________________________________________________________________");
                System.out.println("\n                            " + category);
                System.out.println("                                                        Type x to exit");
                System.out.println("______________________________________________________________________");
                System.out.println("                                                              [0] Back\n");
                System.out.println("ID  Name                                                         Price");
                System.out.println("__  ____                                                         _____");
                printCategory(category);
                System.out.println("______________________________________________________________________");
                System.out.println("ENTER NEW ITEM NAME");
                System.out.print("\n[YOUR INPUT]:");
                scan.nextLine();
                iName = scan.nextLine();
                if (iName.equalsIgnoreCase("x")) {
                    System.exit(0);
                } else if (iName.equalsIgnoreCase("0")) {
                    Iloop = false;
                } else if (!iName.isEmpty()) {
                    while (lloop) {
                        System.out.println("______________________________________________________________________");
                        System.out.println("ENTER ITEM PRICE");
                        System.out.print("\n[YOUR INPUT]:");
                        try {
                            setScanned(scan.next());
                            double iprice = Double.parseDouble(getScanned().trim());
                            if (iprice > 0) {
                                addList(category + "," + upperCase(iName) + "," + iprice);
                                File_IO.writeFile(fName, getList());
                                updateMenu();
                                iName = null;
                                lloop = false;
                            } else if (iprice < 0) {
                                System.out.println("\n[Please enter a number above 0]");
                            } else if (iprice == 0) {
                                lloop = false;
                                Iloop = false;
                            }
                        } catch (NumberFormatException | InputMismatchException e) {
                            if (getScanned().equalsIgnoreCase("x")) {
                                System.exit(0);
                            } else {
                                System.out.println("\n[Please enter a number above 0]");
                            }
                        }
                    }
                }
            }
            setScanned(null);
        }
    }

    public static void editInventory() {
        updateMenu();
        Oloop = true;
        Iloop = true;
        while (Oloop) {
            try {
                input = Integer.parseInt(chooseCategory().trim());
            } catch (NumberFormatException | InputMismatchException e) {
                if (getScanned().equalsIgnoreCase("x")) {
                    System.exit(0);
                } else {
                    System.out.println("\n[Invalid Input] - Enter number between 0-7");
                    Iloop = false;
                }
            }
            if (input > 7 || input < 0) {
                System.out.println("\n[Invalid Input] - Enter number between 0-7");
                Iloop = false;
            } else if (input == 0) {
                Iloop = false;
                Oloop = false;
            } else {
                Iloop = true;
            }
            String category = getCategory(input);
            input = 0;
            while (Iloop) {
                System.out.println("______________________________________________________________________");
                System.out.println("\n                       CHOOSE ITEM BY ID TO REMOVE");
                System.out.println("                                                              [0] Back\n");
                System.out.println("______________________________________________________________________");
                System.out.println("ID  Name                                                         Price");
                System.out.println("__  ____                                                         _____");
                printCategory(category);
                System.out.println("______________________________________________________________________");
                System.out.print("\n[YOUR INPUT]:");
                try {
                    setScanned(scan.next());
                    int choosenItem = Integer.parseInt(getScanned().trim());
                    if (choosenItem <= getcItems().size() && choosenItem > 0) {
                        getMenuItems().remove(getcItems().get(choosenItem - 1));
                        getList().clear();
                        for (Products o : getMenuItems()) {
                            addList(o.getCategory() + "," + o.getItemName() + "," + o.getPrice());
                        }
                        File_IO.writeFile(fName, getList());
                        clearcItems();
                        updateMenu();
                        System.out.println("\nItem " + choosenItem + " removed from menu");
                    } else if (choosenItem > getcItems().size() || choosenItem < 0) {
                        System.out.println("______________________________________________________________________");
                        System.out.println("\n[Invalid Input Please Try Again]\nPlease Enter number between 0-" + getcItems().size());
                        clearcItems();
                    } else if (choosenItem == 0) {
                        Iloop = false;
                        clearcItems();
                    }

                } catch (NumberFormatException | InputMismatchException e) {
                    if (getScanned().equalsIgnoreCase("x")) {
                        System.exit(0);
                    } else {
                        System.out.println("______________________________________________________________________");
                        System.out.println("\n[Invalid Input Please Try Again]\nPlease Enter Number Between 0-" + getcItems().size());
                        clearcItems();
                    }
                }
            }
            setScanned(null);
        }

    }

    public static String upperCase(String input) {
        String finalWord = "";
        String letters[] = input.split("\\s");
        for (String w : letters) {
            String firstLetter = w.substring(0, 1);
            String afterFirst = w.substring(1);
            finalWord += firstLetter.toUpperCase() + afterFirst + " ";
        }
        return finalWord.trim();

    }
}
