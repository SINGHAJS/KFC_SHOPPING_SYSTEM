/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author singh
 */
public class AdminRunner {
    public static void main(String[] args) {
        AdminView view = new AdminView();
        
        AdminModel model = new AdminModel();
        AdminController controller = new AdminController(model,view);
        
        model.addObserver(view);
        model.getAllItems();
    }
}
