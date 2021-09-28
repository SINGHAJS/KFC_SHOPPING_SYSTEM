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
        LoginPageView aLoginPageView = new LoginPageView();
        LoginPageModel Model = new LoginPageModel();            
        LoginPageController Controller = new LoginPageController(Model, aLoginPageView);
        Model.addObserver(aLoginPageView);

    }
}
