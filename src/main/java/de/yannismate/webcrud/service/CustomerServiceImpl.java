package de.yannismate.webcrud.service;

import de.yannismate.webcrud.dao.CustomerDao;
import de.yannismate.webcrud.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDao customerDao;

  @Transactional
  public int save(Customer customer) {
    return customerDao.save(customer);
  }

  public Customer get(int id) {
    return customerDao.get(id);
  }

  public List<Customer> list() {
    return customerDao.list();
  }

  @Transactional
  public void update(int id, Customer customer) {
    customerDao.update(id, customer);
  }

  @Transactional
  public void delete(int id) {
    customerDao.delete(id);
  }
}
