/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import factory.dao.EventDAO;
import factory.dao.ProductDAO;
import factory.dao.TransferDAO;
import factory.dao.UserDAO;
import factory.dao.database.MySQLEventDAO;
import factory.dao.database.MySQLProductDAO;
import factory.dao.database.MySQLTransferDAO;
import factory.dao.database.MySQLUserDAO;




/**
 *
 * @author imjesr
 */
public class MySQLFactory extends DAOFactory {

    @Override
    public ProductDAO getProductDAO() {
        return new MySQLProductDAO();
    }

    @Override
    public EventDAO getEventDAO() {
           return new MySQLEventDAO();
    }

    @Override
    public TransferDAO getTransferDAO() {
        return new MySQLTransferDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

}
