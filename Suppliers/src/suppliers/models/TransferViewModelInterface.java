/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import javax.swing.table.TableModel;
import pojos.Ttransfer;
import suppliers.views.ProductsViewObserver;


/**
 *
 * @author YordanoEynar
 */
public interface TransferViewModelInterface{

    void queryTransfer();

    TableModel getTransferTableModel();

    void addTransfer(Ttransfer transfer);

    void initialize();

    void notifyObservers();

    void registerObserver(ProductsViewObserver transferObserver);

    void removeObserver(ProductsViewObserver transferObserver);

    String getStatusMessage();
}
