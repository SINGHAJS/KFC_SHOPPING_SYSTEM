package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class KFCSystemRunner {

    public static void main(String[] args) {
        KFCSystemRunner aLoginPageRunner = new KFCSystemRunner();        
    }    

    public KFCSystemRunner() {
        LoginView aLoginPageView = new LoginView();
        RegistrationView aRegView = new RegistrationView();
        FAQPageView aFAQView = new FAQPageView();        
        BrowseView aBrowseView = new BrowseView();
        AdminView aAdminView = new AdminView();
        
        SystemModel Model = new SystemModel();
        SystemController Controller = new SystemController(Model, aLoginPageView, aRegView, aAdminView, aFAQView, aBrowseView);

    }
}
