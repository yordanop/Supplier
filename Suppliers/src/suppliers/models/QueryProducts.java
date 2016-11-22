/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;


import factory.DAOFactory;
import factory.dao.ProductDAO;
import java.util.List;
import pojos.Tproducts;

/**
 *
 * @author YordanoEynar
 */
public class QueryProducts implements Runnable {

    private QueryCallBack callback;
    // Factory
    private DAOFactory factory = DAOFactory.getDAOFactory(0);
    private ProductDAO dao = factory.getProductDAO();

    public QueryProducts(QueryCallBack callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        List<Tproducts> products = dao.findAll();
        callback.finishedQueryCallBack(products);
    }

}
