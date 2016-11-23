/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.List;
import javax.swing.table.TableModel;
import pojos.EmployeeType;
import pojos.Tuser;
import suppliers.ModelObserver;

/**
 *
 * @author YordanoEynar
 */
public interface UserViewModelInterface {

    void queryUser();

    void queryTypes();

    TableModel getUserTableModel();

    void addUser(Tuser user);

    void initialize();

    void notifyObservers();

    void registerObserver(ModelObserver userObserver);

    void removeObserver(ModelObserver userObserver);

    String getStatusMessage();

    List<EmployeeType> getTypes();

    void initializeNew();
}
