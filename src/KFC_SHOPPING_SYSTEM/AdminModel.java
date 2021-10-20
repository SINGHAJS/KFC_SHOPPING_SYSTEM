/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

import java.util.Observable;
import java.util.Vector;

/**
 *
 * @author singh
 */
public class AdminModel extends Observable {
    private AdminData data = new AdminData();
    public Vector<ProductItems> holder = new Vector<ProductItems>();
    private final InventoryDB db;
    public AdminModel(){
        this.db = new InventoryDB();
        this.db.createItemsTable();
    }
    public void getAllItems(){
        holder = this.db.getEntireTable();
        data.allItems = this.holder;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    public void editItem(int id, boolean b){
        this.db.editItem(id+1, b);
        //this.getAllItems();
    }
}
