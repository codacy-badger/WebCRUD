package de.yannismate.webcrud.controller;

import de.yannismate.webcrud.model.Customer;
import de.yannismate.webcrud.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping("/customer")
  public ResponseEntity<?> save(@RequestBody Customer customer) {
    int id = customerService.save(customer);
    return ResponseEntity.ok().body("New Customer has been saved with ID:" + id);
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> get(@PathVariable("id") int id) {
    Customer customer = customerService.get(id);
    return ResponseEntity.ok().body(customer);
  }

  @GetMapping("/customer")
  public ResponseEntity<List<Customer>> list() {
    List<Customer> customers = customerService.list();
    return ResponseEntity.ok().body(customers);
  }

  @PutMapping("/customer/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Customer customer) {
    customerService.update(id, customer);
    return ResponseEntity.ok().body("Customer has been updated successfully.");
  }

  @DeleteMapping("/customer/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") int id) {
    customerService.delete(id);
    return ResponseEntity.ok().body("Customer has been deleted successfully.");
  }

}
