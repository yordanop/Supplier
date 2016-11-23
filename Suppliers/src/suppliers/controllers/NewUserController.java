/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;



import java.util.List;
import pojos.EmployeeType;
import pojos.Tuser;
import suppliers.models.UserViewModelInterface;




/**
 *
 * @author YordanoEynar
 */
public class NewUserController implements NewUserControllerInterface {

    private UserViewModelInterface userModel;
    public NewUserController(UserViewModelInterface model){
        this.userModel=model;
    }

    @Override
    public void addUser(Tuser user) {
        userModel.addUser(user);
    }

    @Override
    public void queryTypes() {
        userModel.queryUser();
    }

    @Override
    public List<EmployeeType> getTypes() {
       return userModel.getTypes();
    }
    
  
}
