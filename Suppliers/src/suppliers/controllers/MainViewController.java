/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import suppliers.models.EventsViewModel;
import suppliers.models.EventsViewModelInterface;
import suppliers.models.MainViewModelInterface;
import suppliers.models.ProductsViewModel;
import suppliers.models.ProductsViewModelInterface;
import suppliers.models.SendProductViewModelInterface;
import suppliers.models.SendProductsViewModel;
import suppliers.models.TransferViewModel;
import suppliers.models.TransferViewModelInterface;
import suppliers.models.UserViewModel;
import suppliers.models.UserViewModelInterface;
import suppliers.views.EventsView;
import suppliers.views.MainView;
import suppliers.views.ProductsView;
import suppliers.views.SendProductView;
import suppliers.views.TransferView;
import suppliers.views.UserView;




/**
 *
 * @author imjesr
 */
public class MainViewController implements MainViewControllerInterface {

    private MainViewModelInterface model;
    private MainView view;

    public MainViewController(MainViewModelInterface model) {
        this.model = model;
        view = new MainView(this, model);
        view.setVisible(true);

    }

    @Override
    public void viewEvents() {
        this.model.viewEvents();

        EventsViewModelInterface model = new EventsViewModel();//Evento del click crea model y controller
        EventsViewControllerInterface controller = new EventsController(model);
        EventsView empView = new EventsView(model, controller);//crear una vista que recibe el modelo y el controlador
        model.initialize();//carga los datos siempre que se quiera inciar una ventana
        empView.setVisible(true);//hacer la vista visible

    }

    @Override
    public void viewProducts() {
         this.model.viewProducts();
        ProductsViewModelInterface model = new ProductsViewModel();//Evento del click crea model y controller
        ProductsViewControllerInterface controller = new ProductsController(model);
        ProductsView empView = new ProductsView(model, controller);//crear una vista que recibe el modelo y el controlador
        model.initialize();//carga los datos siempre que se quiera inciar una ventana
        empView.setVisible(true);//hacer la vista visible

    }

    @Override
    public void viewTransfers() {
        this.model.viewTransfers();

        TransferViewModelInterface model = new TransferViewModel();//Evento del click crea model y controller
        TransferViewControllerInterface controller = new TransferController(model);
        TransferView tranView = new TransferView(model, controller);//crear una vista que recibe el modelo y el controlador
        model.initialize();//carga los datos siempre que se quiera inciar una ventana
        tranView.setVisible(true);
    }

    @Override
    public void viewUsers() {
       this.model.viewUsers();

        UserViewModelInterface model = new UserViewModel();//Evento del click crea model y controller
        UserViewControllerInterface controller = new UserController(model);
        UserView useView = new UserView(model, controller);//crear una vista que recibe el modelo y el controlador
        model.initialize();//carga los datos siempre que se quiera inciar una ventana
        useView.setVisible(true);
    }

    @Override
    public void sendProduct() {
        this.model.sendProduct();

        SendProductViewModelInterface model = new SendProductsViewModel();//Evento del click crea model y controller
        SendProductViewControllerInterface controller = new SendProductController(model);
        SendProductView sendView = new SendProductView(model, controller);//crear una vista que recibe el modelo y el controlador
        model.initialize();//carga los datos siempre que se quiera inciar una ventana
        sendView.setVisible(true);
    }





}
