/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao;

import java.util.List;
import pojos.Ttransfer;




/**
 *
 * @author imjesr
 */
public interface TransferDAO {

    void add(Ttransfer product);

    Ttransfer find(int id);

    void delete(Ttransfer product);

    List<Ttransfer> findAll();
}
