package de.yannismate.webcrud.dao;

import de.yannismate.webcrud.model.Customer;
import java.util.List;

public interface CustomerDao {

  int save(Customer customer);

  Customer get(int id);

  List<Customer> list();

  void update(int id, Customer customer);

  void delete(int id);

}
