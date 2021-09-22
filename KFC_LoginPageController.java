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
        if (e.equals(view.aLoginButton)) {
            model.performCustomerLogin();
        } else if (e.equals(view.aRegistrationButton)) {
            model.performCustomerRegistration();
        } else if (e.equals(view.aManagerLoginButton)) {
            model.performManagerLogin();
        } else if (e.equals(view.aFAQButton)) {
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
