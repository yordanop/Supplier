/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.ArrayList;
import java.util.List;
import suppliers.ModelObserver;


/**
 *
 * @author imjesr
 */
public class MainViewModel implements MainViewModelInterface {

    private List<ModelObserver> observers = null;

    private boolean isViewEmployeesEnabled = true;

    public MainViewModel() {
        observers = new ArrayList<>();
    }

    @Override
    public void initialize() {
        notifyObservers();
    }


    @Override
    public void notifyObservers() {
        for (ModelObserver observer : observers) {
            observer.updateView();
        }
    }

    @Override
    public void viewProducts() {
        notifyObservers();
    }

    @Override
    public void viewEvents() {
        notifyObservers();
    }

    @Override
    public void registerObserver(ModelObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void viewTransfers() {
       notifyObservers();
    }

    @Override
    public void viewUsers() {
        notifyObservers();
    }

    @Override
    public void sendProduct() {
       notifyObservers();
    }

}
