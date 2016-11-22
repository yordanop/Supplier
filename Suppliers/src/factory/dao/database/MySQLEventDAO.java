/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao.database;


import factory.dao.EventDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojos.EventType;
import pojos.Tevents;
import pojos.Tuser;
import suppliers.MySessionFactory;

/**
 *
 * @author YordanoEynar
 */
public class MySQLEventDAO implements EventDAO {

    private MySessionFactory mySessionFactory;
    private SessionFactory sessionFactory;

    public MySQLEventDAO() {
        mySessionFactory = new MySessionFactory();

    }

    @Override
    public void add(Tevents event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Tevents> findAll() {
        List<Tevents> events = null;
        List<Tuser> users=null;
        List<EventType> types=null;
        try {
            sessionFactory = mySessionFactory.setUp();
            Session session = sessionFactory.openSession();
            
            session.beginTransaction();

            events = session.createQuery("FROM Tevents").list();
            users = session.createQuery("FROM Tuser").list();
            types = session.createQuery("FROM EventType").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            Logger.getLogger(MySQLEventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

    @Override
    public Tevents find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
