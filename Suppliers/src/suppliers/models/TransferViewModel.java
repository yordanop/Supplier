/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import pojos.Ttransfer;
import suppliers.views.ProductsViewObserver;


/**
 *
 * @author YordanoEynar
 */
public class TransferViewModel implements TransferViewModelInterface, QueryCallBack {

    private List<ProductsViewObserver> productObserver;
    private List<Ttransfer> transfer;
    String statusMessage = "Ready";

    public TransferViewModel() {
        productObserver = new ArrayList<>();
        transfer = new ArrayList<>();
    }

    @Override
    public void queryTransfer() {
        statusMessage = "Wait,executing query...";
        notifyObservers();
        QueryTransfer queryTransfer = new QueryTransfer(this);
        Thread thread = new Thread(queryTransfer);
        thread.start();
    }


    @Override
    public void initialize() {
        queryTransfer();
    }

    @Override
    public void notifyObservers() {
        for (ProductsViewObserver transferObserver : productObserver) {
            transferObserver.UpdateView();
        }
    }

    @Override
    public TableModel getTransferTableModel() {
        return new TransferModelData(transfer);
    }

    @Override
    public void addTransfer(Ttransfer product) {
        transfer.add(product);
        notifyObservers();

    }

    private List<Ttransfer> getTransferDummyData() {//agregsr los datos a la tabla
        List<Ttransfer> dummyTransfer = new ArrayList<>();

        return dummyTransfer;//devolver los datos
    }

    @Override
    public void registerObserver(ProductsViewObserver transferObserver) {
        productObserver.add(transferObserver);
    }

    @Override
    public void removeObserver(ProductsViewObserver transferObserver) {
        productObserver.add(transferObserver);
    }

    @Override
    public void finishedQueryCallBack(List items) {
        transfer = items;
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
