/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import factory.dao.database.MySQLProductDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import pojos.Tevents;
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
        MySQLProductDAO dao = new MySQLProductDAO();
        
    QueryProducts queryProducts;

    public ProductsViewModel() {
        productObserver = new ArrayList<>();
        products = new ArrayList<>();
        
        queryProducts = new QueryProducts(this);
    }

    @Override
    public void queryProducts() {
        statusMessage = "Wait,executing query...";
        notifyObservers();
        Thread thread = new Thread(queryProducts);
        thread.start();
    }


    @Override
    public void initialize() {
        queryProducts();
    }
    
    @Override
    public void deleteProduct(int productIndex){
        queryProducts.deleteProduct(products.get(productIndex));
        products.remove(productIndex);
        notifyObservers();
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
        Thread threadq = new Thread(new Runnable() {
            @Override
            public void run() {
                dao.add(product);
                notifyObservers();
            }
        });
        threadq.start();

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
