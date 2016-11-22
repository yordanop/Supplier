/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import factory.dao.database.MySQLUserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import pojos.Tuser;
import suppliers.views.ProductsViewObserver;


/**
 *
 * @author YordanoEynar
 */
public class UserViewModel implements UserViewModelInterface, QueryCallBack {

    private List<ProductsViewObserver> userObserver1;
    private List<Tuser> user1;
    String statusMessage = "Ready";
    MySQLUserDAO dao=new MySQLUserDAO();
    public UserViewModel() {
        userObserver1 = new ArrayList<>();
        user1 = new ArrayList<>();
    }

    @Override
    public void queryUser() {
        statusMessage = "Wait,executing query...";
        notifyObservers();
        QueryUser queryUser = new QueryUser(this);
        Thread thread = new Thread(queryUser);
        thread.start();
    }
    
    @Override
    public void queryEmploTy(){
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            dao.getType();
        }
    });
    }


    @Override
    public void initialize() {
        queryUser();
        queryEmploTy();
    }

    @Override
    public void notifyObservers() {
        for (ProductsViewObserver userObserver : userObserver1) {
            userObserver.UpdateView();
        }
    }

    @Override
    public TableModel getUserTableModel() {
        return new UserModelData(user1);
    }

    @Override
    public void addUser(Tuser user) {
        user1.add(user);
        notifyObservers();

    }

    private List<Tuser> getUserDummyData() {//agregsr los datos a la tabla
        List<Tuser> dummyUser = new ArrayList<>();

        return dummyUser;//devolver los datos
    }

    @Override
    public void registerObserver(ProductsViewObserver userObserver) {
        userObserver1.add(userObserver);
    }

    @Override
    public void removeObserver(ProductsViewObserver userObserver) {
        userObserver1.add(userObserver);
    }

    @Override
    public void finishedQueryCallBack(List items) {
        user1 = items;
        statusMessage = "Ready";
        notifyObservers();
    }

    @Override
    public String getStatusMessage() {
        return statusMessage;
    }

}
