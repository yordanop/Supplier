

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
import pojos.EventType;
import pojos.Tevents;
import pojos.Tuser;


/**
 *
 * @author YordanoEynar
 */
public class EventsModelData extends AbstractTableModel {

    List<Tevents> eventData = new ArrayList<>();
    String columnNames[] = {"Event ID", "Event Type", "User","Description","Date"};
    Class<?> columnClasses[] = {Integer.class,EventType.class, Tuser.class,String.class,Date.class};

    EventsModelData(List<Tevents> events) {
        eventData = events;
    }

    @Override
    public int getRowCount() {
        return eventData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return eventData.get(rowIndex).getIdevent();
        }
        if (columnIndex == 1) {
            return eventData.get(rowIndex).getEventType().getEventType();
        }
        if (columnIndex == 2) {
            return eventData.get(rowIndex).getTuser().getFirstName();
        }
        if (columnIndex == 3) {
            return eventData.get(rowIndex).getDescription();
        }
         if (columnIndex == 4) {
            return eventData.get(rowIndex).getDate();
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            eventData.get(rowIndex).setIdevent((Integer) aValue);
        }
        if (columnIndex == 1) {
            eventData.get(rowIndex).setEventType((EventType) aValue);
        }
        if (columnIndex == 3) {
            eventData.get(rowIndex).setDescription((String) aValue);
        }
        if (columnIndex == 4) {
            eventData.get(rowIndex).setDate((Date) aValue);
        }
         if (columnIndex == 2) {
            eventData.get(rowIndex).setTuser((Tuser) aValue);
        }
     
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
        @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
     @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }
    
}
