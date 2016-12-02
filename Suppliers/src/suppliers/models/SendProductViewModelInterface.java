/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.List;
import pojos.Tevents;
import pojos.Tproducts;
import pojos.Ttransfer;
import suppliers.views.ProductsViewObserver;

/**
 *
 * @author YordanoEynar
 */
public interface SendProductViewModelInterface {

    void addEvent();

    void initialize();

    void notifyObservers();

    void registerObserver(ProductsViewObserver productsObserver);

    void removeObserver(ProductsViewObserver productsObserver);

    void queryProducts();

    List<Tproducts> getProducts();

    String getStatusMessage();
    
    Tevents getEvents();

    void addTransfer(Ttransfer transfer);
}
