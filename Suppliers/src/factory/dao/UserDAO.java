/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao;

import java.util.List;
import pojos.EmployeeType;
import pojos.Tevents;
import pojos.Tuser;

/**
 *
 * @author imjesr
 */
public interface UserDAO {

    void add(Tuser user);

    Tuser find(int id);

    List<Tuser> findAll();

    List<EmployeeType> getType();
}
