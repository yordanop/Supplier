/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.models;

import javax.swing.table.TableModel;
import pojos.Tevents;
import suppliers.views.ProductsViewObserver;

/**
 *
 * @author YordanoEynar
 */
public interface EventsViewModelInterface {

    TableModel getEventsTableModel();

    void addEvent(Tevents event);

    void queryEvents();

    void initialize();

    void notifyObservers();

    void registerObserver(ProductsViewObserver eventsObserver);

    void removeObserver(ProductsViewObserver eventsObserver);

    String getStatusMessage();
}
