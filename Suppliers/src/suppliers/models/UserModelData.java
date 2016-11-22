/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;
import pojos.EmployeeType;
import pojos.Tuser;

/**
 *
 * @author YordanoEynar
 */
public class UserModelData extends AbstractTableModel {

    List<Tuser> userData = new ArrayList<>();
    String columnNames[] = {"User ID", "First Name", "Last Name", "Password", "Employee Type"};
    Class<?> columnClasses[] = {String.class, String.class, String.class, String.class, EmployeeType.class};

    UserModelData(List<Tuser> user) {
        userData = user;
    }

    @Override
    public int getRowCount() {
        return userData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return userData.get(rowIndex).getIduser();
        }
        if (columnIndex == 1) {
            return userData.get(rowIndex).getFirstName();
        }
        if (columnIndex == 2) {
            return userData.get(rowIndex).getLastName();
        }
        if (columnIndex == 3) {
            return userData.get(rowIndex).getPassword();
        }
        if (columnIndex == 4) {
            return userData.get(rowIndex).getEmployeeType().getEmployeeType();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            userData.get(rowIndex).setIduser((String) aValue);
        }
        if (columnIndex == 1) {
            userData.get(rowIndex).setFirstName((String) aValue);
        }
        if (columnIndex == 2) {
            userData.get(rowIndex).setLastName((String) aValue);
        }
        if (columnIndex == 3) {
            userData.get(rowIndex).setPassword((String) aValue);
        }
        if (columnIndex == 4) {
            userData.get(rowIndex).setEmployeeType((EmployeeType) aValue);
        }


        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}
