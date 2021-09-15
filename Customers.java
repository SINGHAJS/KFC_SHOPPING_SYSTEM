package KFC_SHOPPING_SYSTEM;

import static KFC_SHOPPING_SYSTEM.ShopSelection.uSelect;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 */
public class Customers {

    //-----------------------------------------------------------USER VARIABLES-    
    private String name, password, confrimPassword;
    private String filePath = "./resources/ShopCustomers.txt";

    //---------------------------------------------------------USER CONSTRUCTOR-
    public Customers(String userName, String userPassword, String confirmPassword) {
        this.name = userName;
        this.password = userPassword;
        this.confrimPassword = confirmPassword;
    }

    //------------------------------------------------------GET AND SET METHODS-
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected String getConfirmPassword() {
        return confrimPassword;
    }

    protected void setConfirmPassword(String confirmPassword) {
        this.confrimPassword = confirmPassword;
    }

    protected String getFilePath() {
        return filePath;
    }

    protected void setFilePath(String aFilePath) {
        this.filePath = aFilePath;
    }

    //-------------------------------------------------------USER LOGIN MESSAGE-
    public static void userLoginMessage() {
        System.out.println("______________________________________________________________________\n");
        System.out.println("                      [WELCOME TO THE LOGIN PAGE]                       ");
        System.out.println("______________________________________________________________________\n");
        System.out.println("[0]Exit System\n[1]Go Back\n[2]Manager Login\n[3]Customer Login");
    }

    //------------------------------------------------------USER LOADING VISUAL-
    public static void viewLodingVisual() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.print(".....");// display this in each iteration
                Thread.sleep(500);// sleep for 0.5 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);// catch exception
        }

    }
    //-------------------------------------------------------KFC USER SELECTION-
    public static void KFC_Users() {
        // define variables
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int userLogin = 0;
        
        Customers.userLoginMessage(); // login header message

        while (run) {
            try {
                userLogin = scan.nextInt(); // take user input for login
                if (userLogin == 0) {
                    KFCSystem.Terminate(); //  terminate system
                } else if (userLogin == 1) {
                    uSelect(); //  let the user select from the main page 
                } else if (userLogin == 2) {
                    ManagerLogin.performManagerLogin();// present user with admin login      
                } else if (userLogin == 3) {
                    CustomerLogin.performCustomerLogin();// present user with customer login         
                } else {
                    System.out.println("\n[PLEASE ENTER NUMBERS BETWEEN 0 TO 3 ONLY]\n");
                }
                run = false;
            } catch (InputMismatchException e) {// catch exception
                System.out.println("\n[ERROR:PLEASE ENTER NUMBERS VALUES BETWEEN 0 TO 3 ONLY]\n");
                run = true;
                break;
            }

        }
    }


}
