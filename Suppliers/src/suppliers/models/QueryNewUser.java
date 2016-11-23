/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import factory.DAOFactory;
import factory.dao.UserDAO;
import java.util.List;
import pojos.EmployeeType;

/**
 *
 * @author YordanoEynar
 */
public class QueryNewUser implements Runnable{
 private QueryCallBack callback;
    // Factory
    private DAOFactory factory = DAOFactory.getDAOFactory(0);
    private UserDAO dao = factory.getUserDAO();

    public QueryNewUser(QueryCallBack callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
         List<EmployeeType> type = dao.getType();
        callback.finishedEmployeeCallBack(type);
    }
    
}
