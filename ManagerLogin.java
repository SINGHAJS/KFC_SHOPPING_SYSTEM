package KFC_SHOPPING_SYSTEM;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class ManagerLogin implements KFCMethods {

    // Offical FAQ File Path
    private String aFAQFilePath = "./resources/Shop'sFAQ.txt";

    //------------------------------------------------------GET AND SET METHODS-
    protected void setAFAQFilePath(String aFile) {
        this.aFAQFilePath = aFile;
    }

    protected String getAFAQFilePath() {
        return this.aFAQFilePath;
    }

    //----------------------------------------------------------MANAGER HASHMAP-
    HashMap<String, String> managerLogin = new HashMap<>();

    //------------------------------------------------------MANAGER CONSTRUCTOR-
    ManagerLogin() {
        // HashMap key set to "Manager" and value set to "Manager12345"
        managerLogin.put("Manager", "Manager12345");

    }

    // get method for the manager login
    protected HashMap getManagerLogin() {
        return managerLogin; // return the HashMap for managerLogin
    }

    //---------------------------------------------------MANAGER HEADER MESSAGE-
    @Override
    public void pageIntroMessage() {
        System.out.println("\n______________________________________________________________________\n");
        System.out.println("                [WELCOME TO THE KFC MANAGER LOGIN PAGE]                        ");
        System.out.println("______________________________________________________________________\n");
    }

    //----------------------------------------------------VISUAL LOADING METHOD-
    @Override
    public void loadingVisual() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.print("###");// display this in each iteration
                Thread.sleep(500);// sleep for 0.5 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);// catch exception
        }
    }

    //----------------------------------------------VERIFY MANAGER LOGIN METHOD-
    public static void verifyManagerLogin(String name, String password, ManagerLogin aML) {
        boolean run = true;
        while (true) {
            if (aML.getManagerLogin().containsKey(name.trim()) && aML.getManagerLogin().containsValue(password.trim())) {
                aML.loadingVisual();
                System.out.println("\n[Admin Login Successful!]\n"); // successful login message
                managerSelection(aML);//  perform manager selection        
                break;
            } else {
                aML.loadingVisual();
                System.out.println("\n[Invalid Name/Password]"); // invalid name/password message                
                ManagerLogin.performManagerLoginAgain(); // get user response to perform login again
                break;

            }

        }
    }

    //---------------------------------------------PERFORM MANAGER LOGIN METHOD-
    public static void performManagerLogin() {
        ManagerLogin aML = new ManagerLogin();
        aML.pageIntroMessage(); // print manager header message
        // define variable
        Scanner scan = new Scanner(System.in);
        String name, password;

        System.out.print("Name: ");
        name = scan.nextLine(); //  take name input            
        System.out.print("Password: ");
        password = scan.nextLine(); // take password input            
        verifyManagerLogin(name, password, aML); //  verify the manager login

    }
    
    //----------------------------------------------PERFORM MANAGER LOGIN AGAIN-
    public static void performManagerLoginAgain() {
        // define variable
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        String again;

        // get user input
        System.out.println("\n[Would You Like To Go Back\tY | N ]");
        again = scan.nextLine();

        while (run) {
            if (again.trim().equalsIgnoreCase("Y")) {
                Customers.KFC_Users(); // go back
                run = false;

            } else if (again.trim().equalsIgnoreCase("N")) {
                ManagerLogin.performManagerLogin(); // perform manager login again
                run = false;

            } else {
                System.out.println("\n[Invalid Input | Please Only Enter Y | N Only]");
                System.out.println("\n[Would You Like To Go Back\tY | N ]");
                again = scan.next();
            }
        }

    }
    
    //-------------------------------------------------MANAGER SELECTION HEADER-
    public static void managerSelectionHeader() { // ManagerSelection Header Message
        System.out.println("\n______________________________________________________________________\n");
        System.out.println("                [WHAT WOULD YOU LIKE TO DO TODAY?]                        ");
        System.out.println("______________________________________________________________________\n");

        System.out.println("[0]Exit System\n[1]Go Back\n[2]Add to Invetory\n[3]Edit Inventory Item\n[4]View FAQ\n");
    }

    //--------------------------------------------------------MANAGER SELECTION-
    public static void managerSelection(ManagerLogin aML) {
        // define variable
        Scanner scan = new Scanner(System.in);
        int userInput = 0;
        boolean stopped = false;

        while (!stopped) {
            ManagerLogin.managerSelectionHeader(); //  manager selection header
            try {
                userInput = scan.nextInt(); 

                if (userInput == 0) {
                    KFCSystem.Terminate(); // exit out of the system
                } else if (userInput == 1) {
                    break; //  go back, break
                } else if (userInput == 2) {
                    Manager.addInventory(); //  add to inventory
                } else if (userInput == 3) {
                    Manager.editInventory(); // edit inventory
                } else if (userInput == 4) {
                    KFC_FAQ.managerQuestionView(aML.getAFAQFilePath()); // view the recent FAQ about the store
                } else {
                    System.out.println("[Invalid Input  |  Please Only Input From 0 To 4]"); // error message   
                }

            } catch (InputMismatchException ex) {
                System.out.println("[Invalid Input  |  Please Only Input From 0 To 4]"); // error message   
                scan.next();
            }
        }
    }

}
