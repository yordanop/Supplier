/*
 * To change this license header, choose License Headers in Transfer Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import suppliers.models.TransferViewModelInterface;



/**
 *
 * @author YordanoEynar
 */
public class TransferController implements TransferViewControllerInterface {

    TransferViewModelInterface transferModel;

    public TransferController(TransferViewModelInterface transferModel) {
        this.transferModel = transferModel;
        transferModel.initialize();
    }

  

    @Override
    public void loadTransfer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newTransfer() {
        
    }

    @Override
    public void viewTransfer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
