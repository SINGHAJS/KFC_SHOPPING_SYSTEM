package KFC_SHOPPING_SYSTEM;

import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class KFCSystem {

    // method to terminate the system
    public static void Terminate() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.print("...");// display this in each iteration
                Thread.sleep(500);// sleep for 0.5 seconds
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);// catch exception
        }
        System.out.println("\n[SYSTEM EXECUTION SUCCESSFUL]");
        System.exit(0);
    }

    // method to allow the user to go back 
    public static boolean GoBack(Scanner scan, String input) {
        boolean running = true;
        while (running) {
            System.out.println("[GO BACK?\tY  |  N ]");
            input = scan.next(); // take user input of (y/n) 
            if (input.trim().equalsIgnoreCase("Y")) {
                return true; // return true when input is y
            } else if (input.trim().equalsIgnoreCase("N")) {
                return false; //  return false when input is n
            } else {
                System.out.println("\n[INVALID INPUT\tPLEASE ENTER\tY  |  N]");// display error message
                running = true;
            }

        }
        return false;
    }
}
