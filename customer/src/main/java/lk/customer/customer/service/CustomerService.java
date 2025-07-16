package lk.customer.customer.service;

import lk.customer.customer.dto.CustomerDto;
import lk.customer.customer.entyty.Customer;

import java.util.List;


public interface CustomerService {

    String save (CustomerDto customerDto);
    Customer update (CustomerDto customerDto);
    String delete(int Id);
    CustomerDto get(int Id);
    List<Customer> getAll();

}
