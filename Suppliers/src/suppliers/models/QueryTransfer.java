/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;


import factory.DAOFactory;
import factory.dao.TransferDAO;
import java.util.List;
import pojos.Ttransfer;

/**
 *
 * @author YordanoEynar
 */
public class QueryTransfer implements Runnable {

    private QueryCallBack callback;
    // Factory
    private DAOFactory factory = DAOFactory.getDAOFactory(0);
    private TransferDAO dao = factory.getTransferDAO();

    public QueryTransfer(QueryCallBack callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        List<Ttransfer> transfer = dao.findAll();
        callback.finishedQueryCallBack(transfer);
    }

}
