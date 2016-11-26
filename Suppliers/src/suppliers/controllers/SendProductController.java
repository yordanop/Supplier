/*
 * To change this license header, choose License Headers in Product Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import suppliers.models.ProductsViewModelInterface;
import suppliers.models.SendProductViewModelInterface;


/**
 *
 * @author YordanoEynar
 */
public class SendProductController implements SendProductViewControllerInterface {

    SendProductViewModelInterface productsModel;

    public SendProductController(SendProductViewModelInterface productsModel) {
        this.productsModel = productsModel;
        productsModel.initialize();
    }

    @Override
    public void newSendProduct() {
        
    }

  



}
