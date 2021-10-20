package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public class AdminRunner {

    public static void main(String[] args) {
        AdminView view = new AdminView();

        AdminModel model = new AdminModel();
        AdminController controller = new AdminController(model, view);

        model.addObserver(view);
        model.getAllItems();
    }
}
