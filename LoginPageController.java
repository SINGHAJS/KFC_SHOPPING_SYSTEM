package KFC_SHOPPING_SYSTEM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ajit Singh ID: 19070642
 */
public class LoginPageController implements ActionListener {

    private LoginPageModel aModel;
    private LoginPageView aLoginPageView;
    private FAQPageView aFAQView;
    private KFCCustomerRegistrationView regView;

   /**
    * 
    * @param aModel
    * @param aLoginPageView 
    */
    public LoginPageController(LoginPageModel aModel, LoginPageView aLoginPageView) {
        System.out.println("[KFC CONTROLLER]");
        System.out.println("[CONTROLLER: ADDING MODEL]");
        this.aModel = aModel;
        System.out.println("[CONTROLLER: ADDING LOGIN PAGE VIEW]");
        this.aLoginPageView = aLoginPageView;
        this.aLoginPageView.addActionListener(this);
    }

    //    public LoginPageController(LoginPageModel aModel, LoginPageView aLoginPageView, FAQPageView aFAQView) {
//        System.out.println("[KFC CONTROLLER]");
//        System.out.println("[CONTROLLER: ADDING MODEL]");
//        this.aModel = aModel;
//        System.out.println("[CONTROLLER: ADDING LOGIN PAGE VIEW]");
//        this.aLoginPageView = aLoginPageView;
//        this.aLoginPageView.addActionListener(this);
//        
//        System.out.println("[CONTROLLER: ADDING FAQ PAGE VIEW]");
//        this.aFAQView = aFAQView;
//        this.aFAQView.addActionListener(this);                
//    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("[CONTROLLER: ACTING ON MODEL]");

        if (e.getSource() == aLoginPageView.aLoginButton) {

            System.out.println("[PERFORMING CUSTOMER LOGIN]");
            aModel.performCustomerLogin();

        } else if (e.getSource() == aLoginPageView.aRegistrationButton) {

            this.aLoginPageView.aLoginPageFrame.dispose();
            aModel.performCustomerRegistration();
            System.out.println("[PERFORMING CUSTOMER REGISTRATION]");

        } else if (e.getSource() == aLoginPageView.aManagerLoginButton) {

            aModel.performManagerLogin();
            System.out.println("[PERFORMING MANAGER LOGIN]");

        } else if (e.getSource() == aLoginPageView.aFAQButton) {

            System.out.println("[VIEWING KFC FAQ]");
            this.aLoginPageView.aLoginPageFrame.dispose();
            aModel.viewFAQ();

        } else if (e.getSource() == aFAQView.aBackButton) {

            System.out.println("[GOING BACK TO LOGIN PAGE]");
            this.aFAQView.aFAQFrame.dispose();
            LoginPageView aNewView = new LoginPageView();
            aNewView.aLoginPageFrame.setVisible(true);

        } else if (e.getSource() == regView.aBackButton) {

            this.regView.aRegistrationFrame.dispose();
            LoginPageView aNewView = new LoginPageView();
            aNewView.aLoginPageFrame.setVisible(true);

        }
    }

}
