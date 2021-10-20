package KFC_SHOPPING_SYSTEM;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ajit Singh ID:19070642
 * @author Rohit Singh ID: 17981754
 */
public class CustomerLogin {

    /**
     * 
     * @param aView
     * @param aHomeView
     * @param aCustomerTable
     * @param DBM
     * @param ps
     * @param rs 
     * 
     * checks the database if an existing customer exists, if true grant access 
     * to the customer to view the KFC home page
     * 
     */
    public static void verifyCustomerLogin(LoginView aView, BrowseView aBrowseView, String aCustomerTable, DBManager DBM, PreparedStatement ps, ResultSet rs) {
        String aCustomerLogin = "SELECT * FROM " + aCustomerTable + " WHERE USERNAME=? AND PASSWORD=?";

        try {
            ps = DBM.getConnection().prepareStatement(aCustomerLogin);
            ps.setString(1, aView.aNameField.getText());
            ps.setString(2, aView.aPassField.getText());
            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");               
                aView.aLoginPageFrame.setVisible(false);
                aBrowseView.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(aView.aLoginPageFrame, "PLEASE MAKE SURE YOU HAVE AN EXISTING ACCOUNT OR ENTERED VALID INFORMATION", "LOGIN UNSUCCESSFUL", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("[ERROR: " + ex + "]");
            JOptionPane.showMessageDialog(aView.aLoginPageFrame, "SQL EXCEPTION OCCURED", "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBM.closeConnections();
        }
    }
}
