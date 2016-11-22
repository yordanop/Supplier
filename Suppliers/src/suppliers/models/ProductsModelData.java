/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pojos.Tproducts;


/**
 *
 * @author YordanoEynar
 */
public class ProductsModelData extends AbstractTableModel{
    List<Tproducts> productData=new ArrayList<>();
    String columnNames[]={"Product ID","CodeBar","Product Name","Cost","Description","Existence"};
    Class<?> columnClasses[] = {Integer.class,Integer.class,String.class,Integer.class,String.class,Integer.class};

    ProductsModelData(List<Tproducts> products){
        productData=products;
    }
    
    @Override
    public int getRowCount() {
        return productData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return productData.get(rowIndex).getProductId();
        }
        if (columnIndex == 1) {
            return productData.get(rowIndex).getCodebar();
        }
        if (columnIndex == 2) {
            return productData.get(rowIndex).getProductName();
        }
        if (columnIndex == 3) {
            return productData.get(rowIndex).getCost();
        }
        if (columnIndex == 4) {
            return productData.get(rowIndex).getDescription();
        }
        if (columnIndex == 5) {
            return productData.get(rowIndex).getExistence();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            productData.get(rowIndex).setProductId((Integer) aValue);
        }
        if (columnIndex == 1) {
            productData.get(rowIndex).setCodebar((String) aValue);
        }
        if (columnIndex == 2) {
            productData.get(rowIndex).setProductName((String) aValue);
        }
        if (columnIndex == 3) {
            productData.get(rowIndex).setCost((Integer) aValue);
        }
        if (columnIndex == 4) {
            productData.get(rowIndex).setDescription((String) aValue);
        }
        if (columnIndex == 5) {
            productData.get(rowIndex).setExistence((Integer) aValue);
        }
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
     @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}


