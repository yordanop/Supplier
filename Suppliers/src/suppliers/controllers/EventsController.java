/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import suppliers.models.EventsViewModelInterface;


/**
 *
 * @author YordanoEynar
 */
public class EventsController implements EventsViewControllerInterface {

    EventsViewModelInterface model;

    public EventsController(EventsViewModelInterface model) {
        this.model = model;
        model.initialize();
    }

    @Override
    public void viewEvents() {
        
    }

    @Override
    public void newEvent() {
  
    }

    @Override
    public void loadEvent() {
        
    }

}
