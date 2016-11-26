/*
 * To change this license header, choose License Headers in Product Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import suppliers.ModelObserver;

/**
 *
 * @author imjesr
 */
public interface MainViewModelInterface {

    void initialize();

    void notifyObservers();

    void registerObserver(ModelObserver observer);

    void removeObserver(ModelObserver observer);

    void viewProducts();

    void viewEvents();

    void viewTransfers();

    void viewUsers();
    
    void sendProduct();

}
