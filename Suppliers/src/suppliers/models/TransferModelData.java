/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojos.Tevents;
import pojos.Tproducts;
import pojos.Ttransfer;




/**
 *
 * @author YordanoEynar
 */
public class TransferModelData extends AbstractTableModel{
    List<Ttransfer> transferData=new ArrayList<>();
    String columnNames[]={"Transfer ID","Event","Product","Cost","Date","Quantity","RFC"};
    Class<?> columnClasses[] = {Integer.class,Tevents.class,Tproducts.class,Tproducts.class,Date.class,Integer.class,String.class};

    TransferModelData(List<Ttransfer> transfer){
        transferData=transfer;
    }
    
    @Override
    public int getRowCount() {
        return transferData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return transferData.get(rowIndex).getIdTransfer();
        }
        if (columnIndex == 1) {
            return transferData.get(rowIndex).getTevents().getIdevent();
        }
        if (columnIndex == 2) {
            return transferData.get(rowIndex).getTproducts().getProductName();
        }
        if (columnIndex == 3) {
            return transferData.get(rowIndex).getTproducts().getCost();
        }
        if (columnIndex == 5) {
            return transferData.get(rowIndex).getQuantity();
        }
        if (columnIndex == 6) {
            return transferData.get(rowIndex).getRfc();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            transferData.get(rowIndex).setIdTransfer((Integer) aValue);
        }
        if (columnIndex == 1) {
            transferData.get(rowIndex).setTevents((Tevents) aValue);
        }
        if (columnIndex == 2) {
            transferData.get(rowIndex).setTproducts((Tproducts) aValue);
        }
        if (columnIndex == 3) {
            transferData.get(rowIndex).setTproducts((Tproducts) aValue);
        }
        if (columnIndex == 5) {
            transferData.get(rowIndex).setQuantity((Integer) aValue);
        }
        if (columnIndex == 6) {
            transferData.get(rowIndex).setRfc((String) aValue);
        }
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
     @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}


