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

/**
 *
 * @author imjesr
 */
public abstract class DAOFactory {

    // Un indice por cada Factory Concreto
    public static final int SQL = 0;
    public static final int FILE = 1;
    public static final int DUMMY = 2;

    public abstract ProductDAO getProductDAO();

    public abstract EventDAO getEventDAO();

    public abstract TransferDAO getTransferDAO();
    
    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case SQL:
                return new MySQLFactory();
            case FILE:
                break;
            case DUMMY:
                break;
        }
        // TODO: Cambiar tipo de retorno
        return null;
    }
}
