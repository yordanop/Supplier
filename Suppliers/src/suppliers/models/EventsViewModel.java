/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import pojos.Tevents;
import suppliers.views.ProductsViewObserver;

/**
 *
 * @author YordanoEynar
 */
public class EventsViewModel implements EventsViewModelInterface,QueryCallBack {

    private List<ProductsViewObserver> eventObserver;
    private List<Tevents> events;
    String statusMessage = "Ready";

    public EventsViewModel() {
        eventObserver = new ArrayList<>();
        events = new ArrayList<>();
    }

    private List<Tevents> getEventsDummyData() {//agregsr los datos a la tabla
        List<Tevents> dummyEvents = new ArrayList<>();
        return dummyEvents;//devolver los datos
    }

    @Override
    public void initialize() {
        queryEvents();
    }

    @Override
    public void notifyObservers() {
        for (ProductsViewObserver eventsObserver : eventObserver) {
            eventsObserver.UpdateView();
        }
    }

    @Override
    public void registerObserver(ProductsViewObserver eventsObserver) {
        eventObserver.add(eventsObserver);
    }

    @Override
    public void removeObserver(ProductsViewObserver eventsObserver) {
        eventObserver.add(eventsObserver);
    }

    @Override
    public TableModel getEventsTableModel() {
        return new EventsModelData(events);
    }

    @Override
    public void queryEvents() {
        statusMessage = "Wait,executing query...";
        notifyObservers();
        QueryEvents queryEvents = new QueryEvents(this);
        Thread thread = new Thread(queryEvents);
        thread.start();
    }

    @Override
    public void finishedQueryCallBack(List items) {
          events = items;
        statusMessage = "Ready";
        notifyObservers();
    }

    @Override
    public void addEvent(Tevents event) {
        events.add(event);
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
