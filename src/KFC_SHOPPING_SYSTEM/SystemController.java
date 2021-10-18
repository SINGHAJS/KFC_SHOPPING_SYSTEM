package KFC_SHOPPING_SYSTEM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ajit Singh ID: 19070642
 */
public class SystemController implements ActionListener {

    private SystemModel aModel;
    private LoginView aLoginPageView;
    private FAQPageView aFAQView;
    private RegistrationView aRegView;
    private ManagerView aMgrView;
    private HomeView aHomeView;

    /**
     * @param aModel
     * @param aLoginPageView
     * @param aRegView
     * @param aMgrView
     * @param aFAQView
     * @param aHomeView
     */
    public SystemController(SystemModel aModel, LoginView aLoginPageView, RegistrationView aRegView, ManagerView aMgrView, FAQPageView aFAQView, HomeView aHomeView) {
        System.out.println("[KFC: CONTROLLER]");
        System.out.println("[CONTROLLER: ADDING MODEL]");
        this.aModel = aModel;

        System.out.println("[CONTROLLER: ADDING LOGIN PAGE VIEW]");
        this.aLoginPageView = aLoginPageView;
        this.aLoginPageView.addActionListener(this);

        System.out.println("[CONTROLLER: ADDING REGISTRATION PAGE VIEW]");
        this.aRegView = aRegView;
        this.aRegView.addActionListener(this);

        System.out.println("[CONTROLLER: ADDING MANAGER PAGE VIEW]");
        this.aMgrView = aMgrView;
        this.aMgrView.addActionListener(this);

        System.out.println("[CONTROLLER: ADDING FAQ PAGE VIEW]");
        this.aFAQView = aFAQView;
        this.aFAQView.addActionListener(this);

        System.out.println("[CONTROLLER: ADDING HOME PAGE VIEW]");
        this.aHomeView = aHomeView;
        this.aHomeView.addActionListener(this);

    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("[CONTROLLER: ACTING ON MODEL]");
//LOGIN BUTTON------------------------------------------------------------------
        if (e.getSource() == aLoginPageView.aLoginButton) {

            System.out.println("[PERFORMING CUSTOMER LOGIN]");
            this.aModel.performCustomerLogin(this.aLoginPageView, this.aHomeView, this.aMgrView);

        } //MANAGER LOGIN BUTTON----------------------------------------------------------        
        else if (e.getSource() == aLoginPageView.aManagerLoginButton) {

            System.out.println("[PERFORMING MANAGER LOGIN]");
            this.aModel.performManagerLogin(this.aLoginPageView, this.aMgrView);

        } //REGISTRATION BUTTON-----------------------------------------------------------        
        else if (e.getSource() == aLoginPageView.aRegistrationButton) {

            System.out.println("[PERFORMING CUSTOMER REGISTRATION]");            
            this.aLoginPageView.aLoginPageFrame.setVisible(false);
            aRegView.aRegistrationFrame.setVisible(true);

        } //REGISTRATION BACK BUTTON------------------------------------------------------        
        else if (e.getSource() == this.aRegView.aRegBackButton) {
            
            System.out.println("[GOING BACK TO LOGIN PAGE]");
            this.aRegView.aRegistrationFrame.setVisible(false);
            this.aLoginPageView.aLoginPageFrame.setVisible(true);

        } //REGISTRATION SUBMIT BUTTON----------------------------------------------------        
        else if (e.getSource() == this.aRegView.aRegSubmitButton) {

            System.out.println("[ATTEMPTING REGISTRATION FOR NEW USER]");
            this.aModel.createNewCustomerAccount(this.aRegView, this.aLoginPageView, this.aHomeView);

        } //FAQ BUTTON--------------------------------------------------------------------        
        else if (e.getSource() == this.aLoginPageView.aFAQButton) {

            System.out.println("[VIEWING KFC FAQ]");
            this.aModel.viewFAQ(this.aLoginPageView, this.aFAQView);

        } //FAQ BACK BUTTON---------------------------------------------------------------        
        else if (e.getSource() == this.aFAQView.aBackButton) {

            System.out.println("[GOING BACK TO LOGIN PAGE]");
            this.aLoginPageView.aLoginPageFrame.setVisible(true);
            this.aFAQView.aFAQFrame.setVisible(false);
        }
//------------------------------------------------------------------------------

    }

}
