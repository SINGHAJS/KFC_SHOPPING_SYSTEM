package KFC_SHOPPING_SYSTEM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ajit Singh ID: 19070642
 */
public class LoginPageModel extends Observable {

    private LoginPageView view;
    private FAQPageView aFAQView;
    protected final String FAQFile = "./resources/Shop'sFAQ.txt"; // file location   
    private static final String URL = "jdbc:derby:KFC_DB_Ebd; create=true";
    private ResultSet rs = null;
    private DBManager DBM;
    private PreparedStatement ps;
    private final String aCustomerTable = "CUSTOMER";

    public void LoginPageModel() {
        System.out.println("[KFC MODEL]");

    }
//Customer Login----------------------------------------------------------------

    public void performCustomerLogin() {
        DBM = new DBManager(URL);
        DBM.createCustomerTable(aCustomerTable);
        view = new LoginPageView();
        verifyCustomerLogin(view);
    }

    public void verifyCustomerLogin(LoginPageView view) {
        String aCustomerLogin = "SELECT * FROM " + aCustomerTable
                + " WHERE USERNAME=? AND PASSWORD=?";

        try {
            this.ps = DBM.getConnection().prepareStatement(aCustomerLogin);
            ps.setString(1, view.aNameField.getText());
            ps.setString(2, view.aPassField.getText());
            rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFUL");
                HomePageView aHomeView = new HomePageView();
            } else {
                JOptionPane.showMessageDialog(view.aLoginPageFrame,
                        "LOGIN FAILED: Please Make Sure You Have An Existing"
                        + " Account Or Inputed Valid Information",
                        "KFC LOGIN UNSUCCESSFUL",
                        JOptionPane.INFORMATION_MESSAGE);
                view.aLoginPageFrame.dispose();
            }
        } catch (SQLException ex) {
            System.out.println("[ERROR: " + ex + "]");
        }
    }

//Customer Registration---------------------------------------------------------
    public void performCustomerRegistration() {
        view = new LoginPageView();
        view.aLoginPageFrame.dispose();
        KFCCustomerRegistrationView aRegistration = new KFCCustomerRegistrationView();
    }

//Manager-----------------------------------------------------------------------   
    public void performManagerLogin() {

    }

//Perfrom FAQViewRequest--------------------------------------------------------
    public void viewFAQ() {
//        LoginPageView view = new LoginPageView();
//        view.aLoginPageFrame.dispose();
        FAQPageView FAQView = new FAQPageView();
        readFAQFile(FAQView);
    }

    public void readFAQFile(FAQPageView aFAQView) {
        try {
            FileReader fr = new FileReader(FAQFile);
            BufferedReader br = new BufferedReader(fr);
            aFAQView.aFAQTextArea.read(br, null);
            br.close();
            aFAQView.aFAQTextArea.requestFocus();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(aFAQView.aFAQFrame,
                    "ERROR: FILE NOT FOUND", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(aFAQView.aFAQFrame,
                    "ERROR: IO EXCEPTION OCCURED ", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

//------------------------------------------------------------------------------       
}
