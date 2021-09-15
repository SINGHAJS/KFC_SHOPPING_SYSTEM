package KFC_SHOPPING_SYSTEM;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class ShopSelection {

    public static void uSelect() {
        usrSelectMenu();

        //-----------------------------------------------------DEFINE VARIABLES-               
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        int userSelection = 10, usrLogin = 0;
        String goBack = "";
        //int usrLogin = 0;        

        //--------------------------------------------TAKE USER SELECTION INPUT-
        try {
            userSelection = scan.nextInt();            
            if (userSelection > 3 || userSelection < 0) { // set input boundaries, if breached display error message
                System.out.println("\n[PLEASE ENTER NUMBERS ONLY BETWEEN 0 TO 3 ONLY]");
            }
        } catch (InputMismatchException e) { // catch exception, string input
            System.out.println("\n[PLEASE ENTER NUMBERS ONLY BETWEEN 0 TO 3 ONLY]");
        }

        while (!exit) {
            // ----------------------------------------------------SYSTEM  EXIT-
            if (userSelection == 0) {// if input is equal to zero, exit the system                      
                KFCSystem.Terminate();

            }
            // ------------------------------------------------------USER LOGIN-
            if (userSelection == 1) {
                Customers.KFC_Users();
                // -----------------------------------------------------------USER REGISTRATION-
            } else if (userSelection == 2) {// if selection input is 2
                CustomerRegistration.performUserRegistration();// present user with the registration 
                exit = KFCSystem.GoBack(scan, goBack);

                // ----------------------------------------------------------------SHOP FAQ-
            } else if (userSelection == 3) {// if selection input is 3                        
                KFC_FAQ.printFAQ();
                exit = KFCSystem.GoBack(scan, goBack);
                // -------------------------------------------------------------SHOP BROWSE-
            } else {// defualt                               
                uSelect();// present user with selection menu
            }
        }
    }

    //-----------------------------------------------USER MENU SELECTION OPTION-
    public static void usrSelectMenu() {
        System.out.println("______________________________________________________________________\n");
        System.out.println("                      [Welcome To KFC ONLINE STORE]                ");
        System.out.println("______________________________________________________________________\n");
        System.out.println("[Please Pick One Of The Following Options]");
        System.out.println("[0]Exit\n[1]Login\n[2]Register\n[3]FAQs");
        System.out.println("[YOUR INPUT]: ");
    }

}
