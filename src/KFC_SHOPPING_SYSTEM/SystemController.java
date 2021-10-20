package KFC_SHOPPING_SYSTEM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class SystemController implements ActionListener {

    private SystemModel aModel;
    private LoginView aLoginPageView;
    private FAQPageView aFAQView;
    private RegistrationView aRegView;   
    private BrowseView aBrowseView;
    private BrowseModel aBrowseModel;
    private BrowseController controller;
    private AdminView aAdminView;
    private AdminModel aAdminModel;
    private AdminController aAdminController;
    /**
     * @param aModel
     * @param aLoginPageView
     * @param aRegView
     * @param aFAQView
     * @param aBrowseView
     * @param aAdminView
     */
    public SystemController(SystemModel aModel, LoginView aLoginPageView, RegistrationView aRegView, AdminView aAdminView, FAQPageView aFAQView, BrowseView aBrowseView) {
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
        this.aAdminView = aAdminView;
        this.aAdminModel = new AdminModel();
        this.aAdminController = new AdminController(this.aAdminModel,this.aAdminView,this.aLoginPageView);
        aAdminModel.addObserver(aAdminView);
        this.aAdminModel.getAllItems();
        
        System.out.println("[CONTROLLER: ADDING FAQ PAGE VIEW]");
        this.aFAQView = aFAQView;
        this.aFAQView.addActionListener(this);

        System.out.println("[CONTROLLER: ADDING HOME PAGE VIEW]");
        this.aBrowseView = aBrowseView;
        this.aBrowseModel = new BrowseModel();
        this.controller = new BrowseController(this.aBrowseModel,this.aBrowseView,this.aLoginPageView);
        aBrowseModel.addObserver(aBrowseView);        
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
            this.aModel.performCustomerLogin(this.aLoginPageView, this.aBrowseView, this.aAdminView);

        } //MANAGER LOGIN BUTTON----------------------------------------------------------        
        else if (e.getSource() == aLoginPageView.aManagerLoginButton) {

            System.out.println("[PERFORMING MANAGER LOGIN]");
            this.aModel.performManagerLogin(this.aLoginPageView, this.aAdminView);

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
            this.aModel.createNewCustomerAccount(this.aRegView, this.aLoginPageView, this.aBrowseView);

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
