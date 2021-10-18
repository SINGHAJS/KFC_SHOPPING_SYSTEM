/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

import java.util.Observable;

/**
 *
 * @author singh
 */
public class AdminModel extends Observable {
    private AdminData data = new AdminData();
    public AdminModel(){
        
    }
    public void setAdminPage(){
        System.out.println("done");
        data.adminPage = true;
        System.out.println(data.adminPage);
        this.setChanged();
        this.notifyObservers(this.data);
    }
}
