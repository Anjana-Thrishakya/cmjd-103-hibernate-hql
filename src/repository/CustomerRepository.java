package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.CustomerEntity;
import util.SessionFactoryConfiguration;

public class CustomerRepository {
    Session session = SessionFactoryConfiguration.getInstance().getSession();

    public CustomerEntity getCustomer(String id){
        CustomerEntity customerEntity = session.get(CustomerEntity.class, id);
        return customerEntity;
    }

    public List<CustomerEntity> getAllCustomers(){
        String hql = "FROM CustomerEntity";
        Query query = session.createQuery(hql);
        List<CustomerEntity> customerEntities = query.list();
        return customerEntities;

    }

    public List<Object[]> getAllCustomersByNative(){
        String sql = "SELECT * FROM Customer";
        Query query = session.createSQLQuery(sql);
        List<Object[]> data = query.list();
        return data;

    }

    public List<Object[]> getCustomerNameAndDob(){
        String hql = "SELECT C.id, C.name, C.dob FROM CustomerEntity C";
        Query query = session.createQuery(hql);
        List<Object[]> data = query.list();
        return data;

    }

    public CustomerEntity getCustomerByHQL(String custId){
        String hql = "FROM CustomerEntity WHERE id= '" + custId + "'";
        Query query = session.createQuery(hql);
        CustomerEntity customerEntity = (CustomerEntity) query.uniqueResult();
        return customerEntity;
    }

    public CustomerEntity getCustomerByHQLUsingNamedParameterd(String custId){
        String hql = "FROM CustomerEntity WHERE id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", custId);
        CustomerEntity customerEntity = (CustomerEntity) query.uniqueResult();
        return customerEntity;
    }
}
