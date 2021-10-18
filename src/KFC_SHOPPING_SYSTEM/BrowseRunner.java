package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author singh
 */
public class BrowseRunner {

    public static void main(String[] args) {
        
        BrowseView view = new BrowseView();
        AdminView aview = new AdminView();
        
        BrowseModel model = new BrowseModel();
        
        BrowseController controller = new BrowseController(model, view);
        
        model.addObserver(view);
        model.addObserver(aview);
    }

}
