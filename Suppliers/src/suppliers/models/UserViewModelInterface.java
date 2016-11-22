/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import javax.swing.table.TableModel;
import pojos.Tuser;
import suppliers.views.ProductsViewObserver;

/**
 *
 * @author YordanoEynar
 */
public interface UserViewModelInterface {

    void queryUser();

    TableModel getUserTableModel();

    void addUser(Tuser user);

    void initialize();

    void notifyObservers();

    void registerObserver(ProductsViewObserver userObserver);

    void removeObserver(ProductsViewObserver userObserver);
    void getComboBox();

    String getStatusMessage();
}
