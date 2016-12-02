/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import factory.dao.database.MySQLEventDAO;
import factory.dao.database.MySQLTransferDAO;
import java.util.ArrayList;
import java.util.List;
import pojos.Tevents;
import pojos.Tproducts;
import pojos.Ttransfer;

import suppliers.views.ProductsViewObserver;

/**
 *
 * @author YordanoEynar
 */
public class SendProductsViewModel implements SendProductViewModelInterface, QueryCallBack {

    private List<ProductsViewObserver> productObserver;
    String statusMessage = "Ready";
    MySQLEventDAO dao = new MySQLEventDAO();
    MySQLTransferDAO dao1 = new MySQLTransferDAO();
    private List<Tproducts> products;
    Tevents event;

    public SendProductsViewModel() {
        productObserver = new ArrayList<>();
        products = new ArrayList<>();
    }

    @Override
    public void initialize() {
        queryProducts();
    }

    @Override
    public void notifyObservers() {
        for (ProductsViewObserver productsObserver : productObserver) {
            productsObserver.UpdateView();
        }
    }

    @Override
    public void addEvent() {
        statusMessage = "Wait, getting products...";
        notifyObservers();
        QueryTransfer queryTransfer = new QueryTransfer(this);
        Thread hilo = new Thread(queryTransfer);
        hilo.start();
    }

    @Override
    public void registerObserver(ProductsViewObserver productsObserver) {
        productObserver.add(productsObserver);
    }

    @Override
    public void removeObserver(ProductsViewObserver productsObserver) {
        productObserver.add(productsObserver);
    }

    @Override
    public void finishedQueryCallBack(List items) {
        statusMessage = "Ready";
        products = items;
        notifyObservers();
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public void finishedEmployeeCallBack(List items) {

    }

    @Override
    public void queryProducts() {
        statusMessage = "Wait, getting products...";
        notifyObservers();
        QueryProducts queryProducts = new QueryProducts(this);
        Thread hilo = new Thread(queryProducts);
        hilo.start();
    }

    @Override
    public List<Tproducts> getProducts() {
        return products;
    }

    @Override
    public void addTransfer(Ttransfer transfer) {
        Thread threadq = new Thread(new Runnable() {
            @Override
            public void run() {
                dao1.add(transfer);
            }
        });

        threadq.start();
    }

    @Override
    public Tevents getEvents() {
        event=dao.lastEvent();
        return event;
    }
}
