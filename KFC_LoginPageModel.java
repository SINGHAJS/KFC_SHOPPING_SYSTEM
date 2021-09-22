/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KFC_SHOPPING_SYSTEM;

import java.util.Observable;
import javax.swing.*;

/**
 *
 * @author ajit_singh
 */
public class KFC_LoginPageModel extends Observable{

    KFC_LoginPageView view; 
    KFC_LoginPageController controller; 
    
    public void KFC_LoginPageModel() {
        System.out.println("[KFC MODEL]");
    }
//Customer Login----------------------------------------------------------------
    public void performCustomerLogin() {
       String username = view.aNameField.getText();
       String password = view.aPassField.getText();
       if(username.trim().equals("") && password.equals("")){
       }
        
    }

//Customer Registration---------------------------------------------------------
    public void performCustomerRegistration() {
    }

//Manager-----------------------------------------------------------------------   
    public void performManagerLogin() {

    }

//Perfrom FAQViewRequest--------------------------------------------------------
    public void viewFAQ() {

    }
    
//------------------------------------------------------------------------------       
}
