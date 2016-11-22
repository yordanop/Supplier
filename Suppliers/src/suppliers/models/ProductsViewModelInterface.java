/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import javax.swing.table.TableModel;
import pojos.Tproducts;
import suppliers.views.ProductsViewObserver;

/**
 *
 * @author YordanoEynar
 */
public interface ProductsViewModelInterface {

    void queryProducts();

    TableModel getProductsTableModel();

    void addProduct(Tproducts product);

    void initialize();

    void notifyObservers();

    void registerObserver(ProductsViewObserver productsObserver);

    void removeObserver(ProductsViewObserver productsObserver);

    String getStatusMessage();
}
