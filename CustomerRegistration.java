package KFC_SHOPPING_SYSTEM;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Ajit_Singh ID: 19070642
 * @author Rohit_Singh ID:17981754
 */

public class CustomerRegistration extends Customers {

    //-------------------------------------------------------USER REGISTERATION-
    CustomerRegistration(String userName, String userPassword, String confirmPassword) {
        super(userName, userPassword, confirmPassword);
    }

    //-----------------------------------------------------REGISTRATION MESSAGE-
    public static void userRegistrationMessage() {
        // printing the registration started message       
        System.out.println("______________________________________________________________________\n");
        System.out.println("                  [WELCOME TO THE KFC REGISTERATION PAGE]                      ");
        System.out.println("______________________________________________________________________\n");
        System.out.println("[PLEASE MAKE SURE YOU PASSWORD HAS ATLEAST]\n- 7 CHARACTERS\n- NUMBERS\n- UPPERCASE AND LOWERCASE CHARACTERS\n");
    }

    //-----------------------------------------------------CHECK VALID PASSWORD-
    public static boolean valPassword(String name, String password, String confirmPassword) {
        // if the password length is bigger or equal to 7 
        if (password.length() >= 7) {
            // then check the password and check confirm password equals to the password
            if (checkPassword(password) && password.equals(confirmPassword)) {
                return true; // return true, if conditions follow
            } else if (!password.equals(confirmPassword)) { // if confirm password not equal to password
                viewLodingVisual(); // display loading visual
                System.out.println("\n[PLEASE MAKE SURE YOUR BOTH PASSWORD MATCHES]\n"); //error message                
                return false;// returning false
            } else if (checkPassword(password) == false) { // if password standard is not ethical
                viewLodingVisual();// display loading visual
                System.out.println("\n[PLEASE MAKE SURE YOUR PASSWORD HAS ALL OF THE LISTED CONDITIONS ABOVE]\n"); // error message                
                return false;// returning false
            } else {
                return false;
            }
        } else { // if password length is smaller than 7, display error message
            viewLodingVisual();
            System.out.println("\n[THE PASSWORD MUST BE AT LEAST [7] CHARACTERS IN LENGTH]\n");            
            return false; // return false
        }
    }

    //-----------------------------------------------------------CHECK PASSWORD-
    public static boolean checkPassword(String password) {
        // define variables
        boolean hasUp = false, hasLow = false, hasNum = false;
        char c;

        // check each character of the password
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isDigit(c)) {// if the password contains number(s)
                hasNum = true;// return true
            } else if (Character.isUpperCase(c)) {// if the password contains uppercase character(s)
                hasUp = true;// return true
            } else if (Character.isLowerCase(c)) {// if the password contains lowercase character(s) 
                hasLow = true;// return true
            }

            // if all the above conditions are true
            if (hasNum && hasLow && hasUp) {
                return true;// return true
            }
        }
        // default: return false;
        return false;
    }

    //---------------------------------------------------SAVE USER REGISTRATION-
    public static void saveUser(String name, String password, String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            // save user with the name and password seperated by comma
            pw.println(name + "," + password);
            pw.flush();
            pw.close();

            viewLodingVisual(); // display loading visual
            System.out.println("\n[REGISTERATION COMPLETE]\n[THANK YOU FOR REGISTERING AT WITH KFC ONLINE SYSTEM]\n"); // success message            
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }

    //------------------------------------------------PERFORM USER REGISTRATION-
    public static void performUserRegistration() {
        // define variables
        Scanner scan = new Scanner(System.in);
        String name, password, confirmPassword;
        // display registration message
        CustomerRegistration.userRegistrationMessage();

        // take using input
        System.out.print("Enter Name: ");
        name = scan.next().trim();
        System.out.print("Enter Password: ");
        password = scan.next().trim();
        System.out.print("Confirm Password: ");
        confirmPassword = scan.next();

        // a new user created 
        Customers usrReg = new CustomerRegistration(name, password, confirmPassword);
        //checking user input         
        if (CustomerRegistration.valPassword(usrReg.getName(), usrReg.getPassword(), usrReg.getConfirmPassword())) {
            CustomerRegistration.saveUser(usrReg.getName(), usrReg.getPassword(), usrReg.getFilePath());// saving user
        }
    }

}
