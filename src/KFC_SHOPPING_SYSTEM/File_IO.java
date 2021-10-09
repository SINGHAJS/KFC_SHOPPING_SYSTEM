package KFC_SHOPPING_SYSTEM;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 */
public class File_IO {

    // method to read file and return is as an array list
    public static ArrayList readFile(String fileName) {
        ArrayList<String> list = new ArrayList<>(); // arraylist
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String text = "";
            //scan .txt file
            while ((text = br.readLine()) != null) {
                list.add(text); // add text to the list
            }
            return list;
        } catch (FileNotFoundException e) {
            //print error, if file not found
            System.out.println("Error: " + e);
        } catch (IOException e) {

        }
        return null;

    }

    public static void writeFile(String fileName, List<String> list) {

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintWriter pw = new PrintWriter(fos);
            for (String l : list) {
                pw.println(l);
            }
            pw.flush();
            pw.close();

        } catch (IOException e) {
            System.out.println("ERROR: " + e);

        }

    }

    public static void printFile(String file) {
        //.txt file name and location
        File aFile = new File(file);
        try {
            //scan .txt file
            Scanner scan = new Scanner(aFile);
            while (scan.hasNext()) {
                //print .txt file
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            //print error, if file not found
            System.out.println("Error: " + e);
        }
    }

    //method to write to the FAQ file in a formated way 
    public static void writeToFAQFile(String fileName, String question, String answer) {

        PrintWriter aPW = null;
        try {
            aPW = new PrintWriter(new FileOutputStream(fileName, true));
            // writing the content to the FAQ file
            aPW.append("\nQuestion: " + question
                    + "\nAnswer: " + answer + "\n");
            aPW.close(); // close file
            System.out.println("[QUESTION SUBMTTED]");

        } catch (FileNotFoundException ex) {
            System.out.println("Exception: " + ex); // error
        }

    }

    /**
     * @param aFAQView
     */
    public static void readFAQFile(FAQPageView aFAQView, String FAQFile) {
        try {
            FileReader fr = new FileReader(FAQFile);
            BufferedReader br = new BufferedReader(fr);
            aFAQView.aFAQTextArea.read(br, null);
            br.close();
            aFAQView.aFAQTextArea.requestFocus();
        } catch (FileNotFoundException ex) {
            System.out.println("[ERROR: " + ex + "]");
            JOptionPane.showMessageDialog(aFAQView.aFAQFrame,
                    "ERROR: FILE NOT FOUND", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            System.out.println("[ERROR: " + ex + "]");
            JOptionPane.showMessageDialog(aFAQView.aFAQFrame,
                    "ERROR: IO EXCEPTION OCCURED ", "FILpE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
