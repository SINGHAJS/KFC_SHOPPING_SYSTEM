package KFC_SHOPPING_SYSTEM;

import java.util.Scanner;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID:17981754
 *
 */
public class KFC_FAQ {

    //-------------------------------------------------------FAQ Header Message-
    public static void aLoginMessage() {
        System.out.println("\n______________________________________________________________________\n");
        System.out.println("                 [WELCOME TO THE KFC FAQ PAGE]                        ");
        System.out.println("______________________________________________________________________\n");

    }

    //---------------------------------------------------------Print FAQ Method-
    public static void printFAQ(String tableName) {
        String aQnA = "SELECT * FROM " + tableName + " WHERE QUESTION=? AND ANSWER=?";

    }
   

    //---------------------------------------------------Record Question Method-    
    public static void recordQuestion(Scanner scan, String aFile) {
        String question, input;
        String defaultAnswer = "(Waiting For Answer)";
        boolean running = true;

        System.out.println("\n[PLEASE ENTER YOUR QUESTION]");
        question = scan.nextLine();

        submitQuestion(question, scan, aFile, defaultAnswer); // submit qestion method

        while (running) {

            System.out.println("\n[GOT MORE QUESTION?\tY | N ]");
            input = scan.nextLine(); // take user input

            if (input.trim().equalsIgnoreCase("Y")) {
                System.out.println("\n[PLEASE ENTER YOUR QUESTION]");
                question = scan.nextLine();
                File_IO.writeToFAQFile(aFile, question, defaultAnswer); // write the question to the file
                submitQuestion(question, scan, aFile, defaultAnswer); // prompt the user to submit the question
            } else if (input.trim().equalsIgnoreCase("N")) {
                System.out.println("\n[THANK YOU | WE WILL GET BACK TO AS SOON AS POSSIBLE]\n"); // message
                running = false;
            } else {
                System.out.println("\n[INVALID INPUT\tPLEASE ONLY ENTER Y |N ]"); // error message
            }
        }

    }

    //---------------------------------------------------Submit Question Method-
    public static void submitQuestion(String question, Scanner scan, String aFile, String defaultAnswer) {
        String submission;
        boolean jogging = true;
        while (jogging) {
            System.out.println("\n[SUBMIT QUESTION:\tY  |  N ]");
            submission = scan.nextLine(); // take user input 

            if (submission.trim().equalsIgnoreCase("Y")) {
                File_IO.writeToFAQFile(aFile, question, defaultAnswer); // write the question to the temp file               
                jogging = false;
            } else if (submission.trim().equalsIgnoreCase("N")) {
                System.out.println("\n[PLEASE ENTER YOU QUESTION]"); // ask the user to write the question
                question = scan.nextLine();
            } else {
                System.out.println("\n[INVALID INPUT\tPLEASE ONLY ENTER Y |N ]"); // error message
            }

        }
    }

    //--------------------------------------------------Manager FAQ View Method-
    public static void managerQuestionView(String aFile) {
        Scanner scan = new Scanner(System.in);
        String response, question, answer, submit;
        boolean running = true;

         File_IO.printFile("./resources/CustomerQuestion.txt"); //  print the FAQ file     
        while (running) {
                  
            System.out.println("\n[ANSWER FAQ QUESTIONS:\tY  |  N  ]");
            response = scan.nextLine();//  take manager response

            if (response.trim().equalsIgnoreCase("Y")) {
                System.out.print("\n[ENTER QUESTION] ");
                question = scan.nextLine(); // take manager question input
                //running = false;
                System.out.print("[ENTER QUESTION ANSWER] ");
                answer = scan.nextLine(); // take manager answer input

                File_IO.writeToFAQFile(aFile, question, answer); // write the question and answer to the official FAQ .txt            

            } else if (response.trim().equalsIgnoreCase("N")) {
                System.out.println("\n[QUESTION NOT ANSWERED]"); // prompt message
                running = false;
            } else {
                System.out.println("\n[INVALID INPUT\tPLEASE ONLY ENTER  Y | N ]"); // error message
                                                
            }

        }

    }

}
