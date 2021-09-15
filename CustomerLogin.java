package KFC_SHOPPING_SYSTEM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID:19070642
 * @author Rohit Singh ID: 17981754
 */
public class CustomerLogin extends Customers {

    //---------------------------------------------------------------USER_LOGIN-
    CustomerLogin(String userName, String userPassword, String confirmPassword) {
        super(userName, userPassword, confirmPassword);
    }

    //------------------------------------------------------------LOGIN MESSAGE-
    public static void aLoginMessage() {
        System.out.println("______________________________________________________________________\n");
        System.out.println("                [WELCOME TO THE KFC CUSTOMER LOGIN PAGE]                     ");
        System.out.println("______________________________________________________________________\n");
    }

    //-------------------------------------------------------LOGIN VERIFICATION-     
    public static void verifyCustomerLogin(String username, String password, String filePath) {
        // temp variables        
        String tempUserName = "";
        String tempUserPassword = "";

        try {
            Scanner aScan = new Scanner(new File(filePath));
            aScan.useDelimiter("[,\n]");// using delimiter         

            while (aScan.hasNext()) {
                tempUserName = aScan.next();
                tempUserPassword = aScan.next();

                // if the username and password input matches the temp username and password: login is successful
                if (tempUserName.trim().equals(username.trim()) && tempUserPassword.trim().equals(password.trim())) {
                    viewLodingVisual();
                    System.out.println("\n[Login Successful!]");
                    customerSelection(username);
                    break;
                    // if the password input does not matche the temp password: display error message
                } else if (tempUserName.trim().equals(username.trim()) && !tempUserPassword.trim().equals(password.trim())) {
                    viewLodingVisual();
                    System.out.println("\n[Incorrect Password]\n");
                    CustomerLogin.performLoginAgain();
                    break;
                    // if the username input does not matche the temp username: display error message
                } else if (!tempUserName.trim().equals(username.trim()) && tempUserPassword.trim().equals(password.trim())) {
                    viewLodingVisual();
                    System.out.println("\n[Incorrect Name]\n");
                    CustomerLogin.performLoginAgain();
                    break;
                }
            }
            aScan.close(); // close file

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e); // catch exception
        }
    }

    //-------------------------------------------------------PERFORM USER LOGIN-
    public static void performCustomerLogin() {
        aLoginMessage(); // customer login message              
        // define variable
        Scanner scan = new Scanner(System.in);
        String name, password;

        // take user input
        System.out.print("Name: ");
        name = scan.next().trim();
        System.out.print("Password: ");
        password = scan.next().trim();

        // user the input and verify the login
        Customers usrLgn = new CustomerLogin(name, password, null);
        verifyCustomerLogin(usrLgn.getName(), usrLgn.getPassword(), usrLgn.getFilePath());
    }

    public static void customerSelectionHeader(String name) {
        // print header message
        System.out.println("\n______________________________________________________________________\n");
        System.out.println("      [WELCOME TO KFC " + name.toUpperCase() + ", WHAT WOULD YOU LIKE TO DO TODAY?]                     ");
        System.out.println("______________________________________________________________________\n");
        System.out.println("[0]Exit System\n[1]Go Back\n[2]Browse\n[3]View Reciept"); // options
        System.out.print("[YOUR INPUT]: ");

    }

    //---------------------------------------------------PROVIDE USER SELECTION-
    public static void customerSelection(String name) {
        // variables
        Scanner scan = new Scanner(System.in);
        int userInput;
        boolean stopped = false;

        while (!stopped) {
            CustomerLogin.customerSelectionHeader(name);// Customer Login header message
            try {
                userInput = scan.nextInt();

                if (userInput == 0) {
                    KFCSystem.Terminate(); // terminate the system
                } else if (userInput == 1) {
                    break; //  break out of loop and go back 
                } else if (userInput == 2) {
                    BrowseProduct.selectProduct(); // initiate Browse Product Class 
                } else if (userInput == 3) {
                    ProductReciept.viewProductReciept(); // initiate Product List Class 
                } else {
                    System.out.println("[Invalid Input  |  Please Only Input From 0 To 3]"); // error message   
                }

            } catch (InputMismatchException ex) {
                System.out.println("[Invalid Input  |  Please Only Input From 0 To 3]"); // error message   
                scan.next();
            }
        }

    }

    //--------------------------------------------------LET USER TO LOGIN AGAIN-
    public static void performLoginAgain() {
        // define variable
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        String again;

        // take user y/n input
        System.out.println("\n[Would You Like To Go Back\tY | N ]");
        again = scan.nextLine();

        while (run) {
            if (again.trim().equalsIgnoreCase("Y")) {
                Customers.KFC_Users(); //  let the user go back to the previous page 
                run = false;

            } else if (again.trim().equalsIgnoreCase("N")) {
                CustomerLogin.performCustomerLogin(); //  let the customer login again
                run = false;

            } else {
                System.out.println("\n[Invalid Input | Please Only Enter Y | N Only]"); //  error message
                System.out.println("\n[Would You Like To Go Back\tY | N ]"); // error message
                again = scan.next();
            }
        }

    }

}
