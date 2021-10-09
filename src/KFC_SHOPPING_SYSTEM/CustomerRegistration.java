package KFC_SHOPPING_SYSTEM;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Ajit_Singh ID: 19070642
 * @author Rohit_Singh ID:17981754
 */
public class CustomerRegistration {

    // java regex for name, address, email and password
    private static final String USER_NAME_REGEX = "^[a-zA-Z0-9]{3,}$";
    private static final String USER_ADDRESS_REGEX = "^[#.0-9a-zA-Z\\s/,-]+$";
    private static final String USER_EMAIL_REGEX = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)";    
    private static final String USER_PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{7,}$";

    /**
     * @param aRegView
     * @param aCustomerTable
     * @param DBM
     * @param URL
     * @param aView
     * @param homeView
     *
     * Gets text from the swing components in the RegistrationView.java class
     * and check if the text matches the requirements. If so, add the details to
     * the database.
     */
    public static void aNewCustomer(RegistrationView aRegView, String aCustomerTable, DBManager DBM, String URL, LoginView aView, HomeView homeView) {
        // define variables 
        // set the variables values to the swing components from the RegistrationView.java class
        String nameField = aRegView.aNameField.getText().trim();
        String passField = aRegView.aPassField.getText();
        String confirmPassField = aRegView.aConfirmPasswordField.getText();
        String emailField = aRegView.aEmailField.getText();
        String addressField = aRegView.aAddressArea.getText();
        String insertCustomerTableValues = "INSERT INTO " + aCustomerTable + " VALUES ('" + nameField + "', '" + passField + "', '" + emailField + "', " + "'" + addressField + "')";

        if (validateUserName(nameField) && validateUserPassword(passField, confirmPassField) && validateUserEmail(emailField) && validateUserAddress(addressField)) {
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
            } finally {
                DBM.closeConnections();
            }
        } else if ((nameField.equals("")) && (passField.equals("")) && (confirmPassField.equals("")) && (emailField.equals("")) && (addressField.equals(""))) {
            JOptionPane.showMessageDialog(aRegView.aRegistrationFrame, "PLEASE MAKE SURE ALL INFORMATION HAS BEEN FILLED", "REGISTRATION FAILED", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *
     * @param aRegView
     * @param aView
     * @param homeView
     *
     * Stores the user input of "Yes", "No" or "X" into an variable name "input"
     * uses input data to allow the log in to the home view from the
     * RegistrationView.java class View or let the user to go back to the
     * LoginView.java class View.
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

    /**
     *
     * @param REGEX
     * @param str
     * @return match
     *
     * This function uses Java Regex API to validate the pattern given the
     * expression and the string value to compare. This return the match which
     * is true when the string matches the pattern and false if the match
     * failed.
     *
     */
    public static boolean validate(final String REGEX, String str) {
        Pattern ptn = Pattern.compile(REGEX);
        Matcher match = ptn.matcher(str);
        return match.matches();
    }

    /**
     *
     * @param userName
     * @return Boolean
     *
     * When the userName matches with the regex, this function returns true.
     *
     * When the userName does not match with the regex, this function returns
     * false and shows an error message to correct the input.
     *
     */
    public static boolean validateUserName(String userName) {
        boolean isValid = validate(USER_NAME_REGEX, userName);
        if (isValid) {
            return true;
        } else if (!isValid && userName.length() > 0) {
            JOptionPane.showMessageDialog(null, "PLEASE ONLY INCLUDE\n\n- CHARACTERS FROM A-Z OR a-z\n- NUMBERS FROM 0-9\n\nNOTE: MAKE SURE THERE ARE NO SPACES OR TABS IN BETWEEN AND THE USERNAME IS ATLEAST 3 CHARACTERS IN LENGTH", "INVALID USER NAME", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return false;
    }

    /**
     *
     * @param userPassword
     * @param userConfirmPassword
     * @return Boolean
     *
     * When the userPassword matches with the regex and the userPassword is
     * equal to the userConfirmPassword it will return true.
     *
     * When the userPassword does not match with the regex it will return false
     * and the error message is displayed to the user to correct the input.
     *
     * When the userPassword is not equal to the confirmPassword it will return
     * false and it will prompt the user with the error message to correct the
     * input.
     *
     * When the userPassword or the userConfirmPassword fields are empty it will
     * prompt user to correct the input.
     */
    public static boolean validateUserPassword(String userPassword, String userConfirmPassword) {
        boolean isPassValid = validate(USER_PASSWORD_REGEX, userPassword);

        if (isPassValid && userPassword.equals(userConfirmPassword)) {
            return true;
        } else if (!isPassValid && userPassword.length() > 0) {
            JOptionPane.showMessageDialog(null, "PLEASE MAKE SURE YOUR PASSWORD INCLUDES ATLEAST\n\n- ONE UPPERCASE AND LOWERCASE CHARACTER\n- NO SPACES OR TABS IN PASSWORD\n- 7 CHARACTERS IN LENGTH\n- A NUMBER", "INVALID USER PASSWORD", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!userPassword.equals(userConfirmPassword) || !userConfirmPassword.equals(userPassword)) {
            JOptionPane.showMessageDialog(null, "PLEASE MAKE SURE BOTH OF YOUR PASSWORD MATCHES", "INVALID USER PASSWORD", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (userPassword.equals("") || userConfirmPassword.equals("")) {
            JOptionPane.showMessageDialog(null, "PASSWORD FIELDS ARE EMPTY", "EMPTY FAILED", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return false;
    }

    /**
     *
     * @param userEmail
     * @return Boolean
     *
     * When the userEmail matches with the regex it will return true.
     *
     * When the userEmail does not match with the regex it will return false and
     * an error message is displayed to the user to correct the input;
     *
     * When the userEmail field is left empty, the user is prompted with an
     * error message to correct the input.
     */
    public static boolean validateUserEmail(String userEmail) {
        boolean isValid = validate(USER_EMAIL_REGEX, userEmail);
        if (isValid) {
            return true;
        } else if (!isValid && userEmail.length() > 0) {
            JOptionPane.showMessageDialog(null, "PLEASE MAKE SURE YOUR EMAIL FORMAT IS VALID\n\nEXAMPLE FORMAT:\nexample@example.com", "INVALID EMAIL FORMAT", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (userEmail.equals("")) {
            JOptionPane.showMessageDialog(null, "EMAIL FIELD IS EMPTY", "EMPTY FAILED", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return false;
    }

    /**
     *
     * @param userAddress
     * @return Boolean
     *
     * When the userAddress matches with the regex it will return true.
     *
     * When the userAddress does not match with the regex it will return false
     * and an error message is prompted to the user to fix the input.
     *
     * When the userAddress is empty, it will prompt the user with the error
     * message.
     */
    public static boolean validateUserAddress(String userAddress) {
        boolean isValid = validate(USER_ADDRESS_REGEX, userAddress);
        if (isValid) {
            return true;
        } else if (!isValid && userAddress.length() > 0) {
            JOptionPane.showMessageDialog(null, "PLEASE MAKE SURE YOU HAVE INPUTED A VALID ADDRESS\n\nPLEASE NOTE SPECIAL CHARACTERS SUCH AS !@$%&*^ WILL NOT BE ACCEPTED", "INVALID ADDRESS", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (userAddress.equals("")) {
            JOptionPane.showMessageDialog(null, "ADDRESS FIELD IS EMPTY", "EMPTY FAILED", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return false;
    }

}
