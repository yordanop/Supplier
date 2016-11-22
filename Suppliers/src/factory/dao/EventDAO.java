/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao;

import java.util.List;
import pojos.Tevents;




/**
 *
 * @author imjesr
 */
public interface EventDAO {

    void add(Tevents event);

    Tevents find(int id);

    List<Tevents> findAll();
}
