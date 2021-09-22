package KFC_SHOPPING_SYSTEM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ajit_singh
 */
public class KFC_LoginPageController implements ActionListener {

    private KFC_LoginPageModel model;
    private KFC_LoginPageView view;

    public void KFC_LoginPageController() {
        System.out.println("[KFC CONTROLLER]");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("[CONTROLLER: ACTING ON MODEL]");
        if (e.getSource()==view.aLoginButton) {                 
            model.performCustomerLogin();
        } else if (e.getSource()==view.aRegistrationButton) {
            model.performCustomerRegistration();
        } else if (e.getSource()==view.aManagerLoginButton) {
            model.performManagerLogin();
        } else if (e.getSource()==view.aFAQButton) {
            model.viewFAQ();
        }
    }

    public void addModel(KFC_LoginPageModel m) {
        System.out.println("[Controller: Adding Model]");
        this.model = m;
    }

    public void addView(KFC_LoginPageView v) {
        System.out.println("[Controller: Adding View]");
        this.view = v;
    }

}
