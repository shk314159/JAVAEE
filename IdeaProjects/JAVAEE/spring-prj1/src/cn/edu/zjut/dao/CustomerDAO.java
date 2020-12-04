package cn.edu.zjut.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cn.edu.zjut.po.Customer;
public class CustomerDAO extends BaseHibernateDAO
        implements ICustomerDAO{
    public void save(Customer transientInstance) {
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.save(transientInstance);
            tran.commit();
        } catch (RuntimeException re) {
            if(tran != null) tran.rollback();
            throw re;
        } finally {
            session.close();
        }
    }
}