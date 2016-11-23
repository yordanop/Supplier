/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.controllers;

import java.util.List;
import pojos.EmployeeType;
import pojos.Tuser;



/**
 *
 * @author YordanoEynar
 */
public interface NewUserControllerInterface {

     void addUser(Tuser user);
    
    void queryTypes();
    
    List<EmployeeType> getTypes();
}
