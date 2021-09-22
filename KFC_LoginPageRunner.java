package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author ajit_singh
 *
 */
public class KFC_LoginPageRunner {

    public static void main(String[] args) {
        KFC_LoginPageRunner kfc_runner = new KFC_LoginPageRunner();        
    }

    public KFC_LoginPageRunner() {
        KFC_LoginPageView kfc_View = new KFC_LoginPageView();
        KFC_LoginPageModel kfc_Model = new KFC_LoginPageModel();
        KFC_LoginPageController kfc_Controller = new KFC_LoginPageController();
        
        kfc_Model.addObserver(kfc_View);                
        kfc_Controller.addModel(kfc_Model);
        kfc_Controller.addView(kfc_View);
        kfc_View.addController(kfc_Controller);
        
    }
}
