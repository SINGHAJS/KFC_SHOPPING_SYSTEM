package KFC_SHOPPING_SYSTEM;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ajit_Singh ID: 19070642
 * @author Rohit_Singh ID:17981754
 */
public class CustomerRegistration {

    /**
     * @param aRegView
     * @param aCustomerTable
     * @param DBM
     * @param URL
     * @param aView
     * @param homeView
     *
     * gets text from the swing components in the RegistrationView.java class
     * and check if the text matches the requirements. If so, add the details to
     * the database
     */
    public static void aNewCustomer(RegistrationView aRegView, String aCustomerTable, DBManager DBM, String URL, LoginView aView, HomeView homeView) {
        // define variables 
        // set the variables values to the swing components from the RegistrationView.java class
        String nameField = aRegView.aNameField.getText();
        String passField = aRegView.aPassField.getText();
        String confirmPassField = aRegView.aConfirmPasswordField.getText();
        String emailField = aRegView.aEmailField.getText();
        String addressField = aRegView.aAddressArea.getText();
        String insertCustomerTableValues = "INSERT INTO " + aCustomerTable + " VALUES ('" + nameField + "', '" + passField + "', '" + emailField + "', " + "'" + addressField + "')";

        if ((nameField.length() > 0) && (passField.length() > 0) && (confirmPassField.length() > 0) && (emailField.length() > 0) && (addressField.length() > 0)) {
            if (passField.length() <= 7) {
                JOptionPane.showMessageDialog(aRegView.aRegistrationFrame, "PLEASE MAKE SURE YOUR PASSWORD IS ATLEAST 8 CHARACTERS LONG", "REGISTRATION FAILED", JOptionPane.INFORMATION_MESSAGE);

            } else if (!passField.equals(confirmPassField)) {
                JOptionPane.showMessageDialog(aRegView.aRegistrationFrame, "PLEASE MAKE SURE YOUR PASSWORD MATCHES", "REGISTRATION FAILED", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    DBM = new DBManager(URL);
                    Statement st = DBM.getConnection().createStatement();
                    st.execute(insertCustomerTableValues);

                    /* uses the shopNowMessage function to allow the user to go 
                    straight to the HomeView.java View upon successful registration */
                    shopNowMessage(aRegView, aView, homeView);
                } catch (SQLException ex) {
                    System.out.println("[ERROR:" + ex + "]");
                    JOptionPane.showMessageDialog(aRegView.aRegistrationFrame, "SQL EXCEPTION OCCURED", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(aRegView.aRegistrationFrame, "PLEASE MAKE SURE ALL INFORMATION HAS BEEN FILLED", "REGISTRATION FAILED", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *
     * @param aRegView
     * @param aView
     * @param homeView
     *
     * stores the user input of "Yes", "No" or "X" into an variable name "input"
     * uses input data to allow the log in to the home view from the
     * RegistrationView.java class View or let the user to go back to the
     * LoginView.java class View
     */
    public static void shopNowMessage(RegistrationView aRegView, LoginView aView, HomeView homeView) {
        int input = JOptionPane.showConfirmDialog(aRegView.aRegistrationFrame, "THANK YOU FOR REGISTERING, FINGER LIKING DEALS ARE WAITING FOR YOU AT KFC!\nSHOP NOW?", "REGISTRATION SUCCESSFUL", JOptionPane.YES_NO_OPTION);
        switch (input) {
            case 0: // user inputs "Yes" as the response
                aRegView.aRegistrationFrame.setVisible(false);
                homeView.aHomeFrame.setVisible(true);
                break;
            case 1: // user inputs "No" as the response
                aRegView.aRegistrationFrame.setVisible(false);
                aView.aLoginPageFrame.setVisible(true);
                break;
            case -1: // user inputs "X" as the response
                aRegView.aRegistrationFrame.setVisible(true);
                break;
            default:
                break;
        }
    }

}
