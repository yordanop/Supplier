/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao;

import java.util.List;
import pojos.Tproducts;




/**
 *
 * @author imjesr
 */
public interface ProductDAO {

    void add(Tproducts product);

    Tproducts find(int id);

    void delete(Tproducts product);

    List<Tproducts> findAll();
}
