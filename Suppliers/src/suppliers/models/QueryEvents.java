/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;


import factory.DAOFactory;
import factory.dao.EventDAO;
import java.util.List;
import pojos.Tevents;


/**
 *
 * @author YordanoEynar
 */
public class QueryEvents implements Runnable {

    private QueryCallBack callback;
    // Factory
    private DAOFactory factory = DAOFactory.getDAOFactory(0);
    private EventDAO dao = factory.getEventDAO();

    public QueryEvents(QueryCallBack callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        List<Tevents> events = dao.findAll();
        callback.finishedQueryCallBack(events);
    }

}
