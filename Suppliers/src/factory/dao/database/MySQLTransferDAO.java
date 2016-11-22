/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.dao.database;


import factory.dao.TransferDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojos.Tevents;
import pojos.Tproducts;
import pojos.Ttransfer;
import suppliers.MySessionFactory;

/**
 *
 * @author YordanoEynar
 */
public class MySQLTransferDAO implements TransferDAO {

    private MySessionFactory mySessionFactory;
    private SessionFactory sessionFactory;

    public MySQLTransferDAO() {
        mySessionFactory = new MySessionFactory();

    }

    @Override
    public void add(Ttransfer transfer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ttransfer find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Ttransfer transfer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ttransfer> findAll() {
        List<Ttransfer> transfer = null;
          List<Tproducts> products = null;
            List<Tevents> events = null;
        try {
            sessionFactory = mySessionFactory.setUp();
            Session session = sessionFactory.openSession();
            
            session.beginTransaction();

            transfer = session.createQuery("FROM Ttransfer").list();
            products = session.createQuery("FROM Tproducts").list();
            events = session.createQuery("FROM Tevents").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            Logger.getLogger(MySQLTransferDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transfer;
    }


}
