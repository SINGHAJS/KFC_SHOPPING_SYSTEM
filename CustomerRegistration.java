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

    public static void aNewCustomer(RegistrationView aRegView, String aCustomerTable, DBManager DBM, String URL, LoginView aView, HomeView homeView) {
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

    public static void shopNowMessage(RegistrationView aRegView, LoginView aView, HomeView homeView) {
        int input = JOptionPane.showConfirmDialog(aRegView.aRegistrationFrame, "THANK YOU FOR REGISTERING, FINGER LIKING DEALS ARE WAITING FOR YOU AT KFC!\nSHOP NOW?", "REGISTRATION SUCCESSFUL", JOptionPane.YES_NO_OPTION);
        switch (input) {
            case 0:
                aRegView.aRegistrationFrame.setVisible(false);
                homeView.aHomeFrame.setVisible(true);
                break;
            case 1:
                aRegView.aRegistrationFrame.setVisible(false);
                aView.aLoginPageFrame.setVisible(true);
                break;
            case -1:
                aRegView.aRegistrationFrame.setVisible(true);
                break;
            default:
                break;
        }
    }

}
