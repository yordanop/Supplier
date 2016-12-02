/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao.database;


import factory.dao.ProductDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojos.Tproducts;
import suppliers.MySessionFactory;

/**
 *
 * @author YordanoEynar
 */
public class MySQLProductDAO implements ProductDAO {

    private MySessionFactory mySessionFactory;
    private SessionFactory sessionFactory;

    Session session;
    
    public MySQLProductDAO() {
        try {
            mySessionFactory = new MySessionFactory();
            
            sessionFactory = mySessionFactory.setUp();
            session = sessionFactory.openSession();
        } catch (Exception ex) {
            System.out.println("Error creating session");
        }
    }

    @Override
    public void add(Tproducts product) {
            try {
            sessionFactory = mySessionFactory.setUp();
            Session session = sessionFactory.openSession();
            
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            Logger.getLogger(MySQLProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Tproducts find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Tproducts product) {
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }

    @Override
    public List<Tproducts> findAll() {
        List<Tproducts> products = null;
        try {
                       
            session.beginTransaction();

            products = session.createQuery("FROM Tproducts").list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(MySQLProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }


}
