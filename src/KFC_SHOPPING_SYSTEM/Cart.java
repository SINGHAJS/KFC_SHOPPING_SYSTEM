/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KFC_SHOPPING_SYSTEM;

/**
 *
 * @author Ajit Singh ID: 19070642
 * @author Rohit Singh ID: 17981754
 *
 */
public abstract class Cart {

    public abstract void addItem(ProductItems o, double quantity);

    public abstract int getCartSize();

    public abstract void removeItem(int index);

    public abstract ProductItems getProduct(int index);

    public abstract String getUnitTotal();

    public abstract void setCartQuantity(int index, double quantity);

    public abstract double getItemQuantity(int index);

}
