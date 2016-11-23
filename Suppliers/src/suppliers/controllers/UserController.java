/*
 * To change this license header, choose License Headers in User Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import java.util.List;
import pojos.EmployeeType;
import pojos.Tuser;
import suppliers.models.UserViewModelInterface;
import suppliers.views.NewUserView;

/**
 *
 * @author YordanoEynar
 */
public class UserController implements UserViewControllerInterface {

    UserViewModelInterface userModel;

    public UserController(UserViewModelInterface userModel) {
        this.userModel = userModel;
        userModel.initialize();
    }

    @Override
    public void viewUser() {

    }

    @Override
    public void loadUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newUser() {
        NewUserControllerInterface userController = new NewUserController(userModel);
        NewUserView userView = new NewUserView(userModel, userController);
        userModel.initializeNew();
        userView.setVisible(true);
        
    }
}
