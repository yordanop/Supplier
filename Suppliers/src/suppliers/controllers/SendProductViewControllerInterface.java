/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import java.util.List;
import pojos.Tproducts;

/**
 *
 * @author YordanoEynar
 */
public interface SendProductViewControllerInterface {

    public void newSendProduct();
    
    public List<Tproducts> getProducts();
    
    public void queryProduct();
}
