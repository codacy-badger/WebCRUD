package de.yannismate.webcrud.dao;

import de.yannismate.webcrud.model.Customer;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

  @Autowired
  private SessionFactory sessionFactory;

  public int save(Customer customer) {
    sessionFactory.getCurrentSession().save(customer);
    return customer.getId();
  }

  public Customer get(int id) {
    return sessionFactory.getCurrentSession().get(Customer.class, id);
  }

  public List<Customer> list() {
    Session session = sessionFactory.getCurrentSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
    Root<Customer> root = cq.from(Customer.class);
    cq.select(root);
    Query<Customer> query = session.createQuery(cq);
    return query.getResultList();
  }

  public void update(int id, Customer customer) {
    Session session = sessionFactory.getCurrentSession();
    Customer customer2 = session.byId(Customer.class).load(id);
    customer2.setForename(customer.getForename());
    customer2.setSurname(customer.getSurname());
    customer2.setEmail(customer.getEmail());
    customer2.setPhone(customer.getPhone());
    session.flush();
  }

  public void delete(int id) {
    Session session = sessionFactory.getCurrentSession();
    Customer customer = session.byId(Customer.class).load(id);
    session.delete(customer);
  }

}
