/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao.database;

import factory.dao.UserDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojos.EmployeeType;
import pojos.Tuser;
import suppliers.MySessionFactory;

/**
 *
 * @author YordanoEynar
 */
public class MySQLUserDAO implements UserDAO {

    private MySessionFactory mySessionFactory;
    private SessionFactory sessionFactory;

    public MySQLUserDAO() {
        mySessionFactory = new MySessionFactory();

    }

    @Override
    public void add(Tuser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tuser> findAll() {
        List<Tuser> user = null;
        List<Tuser> users = null;
        List<EmployeeType> types=null;
        try {
            sessionFactory = mySessionFactory.setUp();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            user = session.createQuery("FROM Tuser").list();
            types=session.createQuery("FROM EmployeeType").list();
 
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public Tuser find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmployeeType> getType() {
        List<EmployeeType> types=null;
        try {
            sessionFactory = mySessionFactory.setUp();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            types=session.createQuery("Select EmployeeType FROM EmployeeType").list();
 
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return types;
    }

}
