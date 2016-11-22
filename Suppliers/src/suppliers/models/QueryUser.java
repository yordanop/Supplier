/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;


import factory.DAOFactory;
import factory.dao.UserDAO;
import java.util.List;
import pojos.Tuser;

/**
 *
 * @author YordanoEynar
 */
public class QueryUser implements Runnable {

    private QueryCallBack callback;
    // Factory
    private DAOFactory factory = DAOFactory.getDAOFactory(0);
    private UserDAO dao = factory.getUserDAO();

    public QueryUser(QueryCallBack callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        List<Tuser> user = dao.findAll();
        callback.finishedQueryCallBack(user);
    }

}
