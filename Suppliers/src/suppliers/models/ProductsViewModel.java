/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import pojos.Tproducts;
import suppliers.views.ProductsViewObserver;

/**
 *
 * @author YordanoEynar
 */
public class ProductsViewModel implements ProductsViewModelInterface, QueryCallBack {

    private List<ProductsViewObserver> productObserver;
    private List<Tproducts> products;
    String statusMessage = "Ready";

    public ProductsViewModel() {
        productObserver = new ArrayList<>();
        products = new ArrayList<>();
    }

    @Override
    public void queryProducts() {
        statusMessage = "Wait,executing query...";
        notifyObservers();
        QueryProducts queryProducts = new QueryProducts(this);
        Thread thread = new Thread(queryProducts);
        thread.start();
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
    public TableModel getProductsTableModel() {
        return new ProductsModelData(products);
    }

    @Override
    public void addProduct(Tproducts product) {
        products.add(product);
        notifyObservers();

    }

    private List<Tproducts> getProductsDummyData() {//agregsr los datos a la tabla
        List<Tproducts> dummyProducts = new ArrayList<>();

        return dummyProducts;//devolver los datos
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
        products = items;
        statusMessage = "Ready";
        notifyObservers();
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public void finishedEmployeeCallBack(List items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
