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
import pojos.EmployeeType;
import pojos.Tuser;
import suppliers.ModelObserver;

/**
 *
 * @author YordanoEynar
 */
public class UserViewModel implements UserViewModelInterface, QueryCallBack {

    private QueryCallBack callback;
    private List<ModelObserver> userObserver1;
    private List<Tuser> user1;
    private List<EmployeeType> types;
    String statusMessage = "Ready";
    MySQLUserDAO dao = new MySQLUserDAO();

    public UserViewModel() {
        userObserver1 = new ArrayList<>();
        user1 = new ArrayList<>();
        types=new ArrayList<>();
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
    public void initialize() {
        queryUser();
    }

    @Override
    public void notifyObservers() {
        for (ModelObserver userObserver : userObserver1) {
            userObserver.updateView();
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
    public void registerObserver(ModelObserver userObserver) {
        userObserver1.add(userObserver);
    }

    @Override
    public void removeObserver(ModelObserver userObserver) {
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

   
    @Override
    public List<EmployeeType> getTypes() {
        return types;
    }

    @Override
    public void initializeNew() {
        queryTypes();
    }

    @Override
    public void queryTypes() {
        statusMessage = "Wait, getting employee types";
        notifyObservers();
        QueryNewUser queryTypes = new QueryNewUser(this);
        Thread hilo = new Thread(queryTypes);
        hilo.start();
    }

}
