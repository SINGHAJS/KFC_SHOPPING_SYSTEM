package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author Ajit Singh ID: 19070642
 *
 */
public class KFCSystemRunner {

    public static void main(String[] args) {
        KFCSystemRunner aLoginPageRunner = new KFCSystemRunner();
    }

    public KFCSystemRunner() {

        LoginView aLoginPageView = new LoginView();
        RegistrationView aRegView = new RegistrationView();
        ManagerView aMgrView = new ManagerView();
        FAQPageView aFAQView = new FAQPageView();
        HomeView aHomeView = new HomeView();

        SystemModel Model = new SystemModel();
        SystemController Controller = new SystemController(Model, aLoginPageView, aRegView, aMgrView, aFAQView, aHomeView);

    }
}
