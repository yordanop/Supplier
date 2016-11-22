/*
 * To change this license header, choose License Headers in Product Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import suppliers.models.ProductsViewModelInterface;
import suppliers.views.NewProductsView;



/**
 *
 * @author YordanoEynar
 */
public class ProductsController implements ProductsViewControllerInterface {

    ProductsViewModelInterface productsModel;

    public ProductsController(ProductsViewModelInterface productsModel) {
        this.productsModel = productsModel;
        productsModel.initialize();
    }

  

    @Override
    public void viewProducts() {

    }

    @Override
    public void loadProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newProduct() {
        NewProductsControllerInterface productController = new NewProductController();
        NewProductsView productsView = new NewProductsView(productsModel,productController);
        productsView.setVisible(true);
    }


}
