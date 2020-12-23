package cn.edu.zjut.dao;
import cn.edu.zjut.po.Customer;
import org.hibernate.Query;

import java.util.List;

public class CustomerDAO extends BaseHibernateDAO implements ICustomerDAO{
    public void save(Customer transientInstance) {
        System.out.println("execute --save()-- method.");
        try {
            getSession().save(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }
    public void delete(Customer transientInstance) {
        System.out.println("execute --delete()-- method.");
        try {
            getSession().delete(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }
    public void update(Customer transientInstance) {
        System.out.println("execute --update()-- method.");
        try {
            getSession().update(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByHql(String hql) {
        System.out.println("execute --findByHql()-- method.");
        try {
            String queryString = hql;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}