package lk.customer.customer.service.impl;

import jakarta.transaction.Transactional;
import lk.customer.customer.dto.CustomerDto;
import lk.customer.customer.entyty.Customer;
import lk.customer.customer.repo.CustomerRepo;
import lk.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service

public class CustomerServiceImpl implements CustomerService {
  @Autowired
  private CustomerRepo customerRepo;

    @Override
    public String save(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setId(customerDto.getId());
        customer.setAge(customerDto.getAge());
        customerRepo.save(customer);
        return "saved";
    }

    @Override
    public Customer update(CustomerDto customerDto) {
        if (customerRepo.existsById(customerDto.getId())) {
            Customer customer = customerRepo.findById(customerDto.getId()).get();
            customer.setName(customerDto.getName());
            customer.setAddress(customerDto.getAddress());
            customer.setAge(customerDto.getAge());
            return customerRepo.save(customer);

        }
        return null;
    }

    @Override
    public String delete(int Id) {
        if (customerRepo.existsById(Id)) {
            customerRepo.deleteById(Id);
            return "deleted";
        }else {
            return "not deleted";
        }
    }

    @Override
    public CustomerDto get(int Id) {
        if (customerRepo.existsById(Id)) {
            Customer customer = customerRepo.findById(Id).get();
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(customer.getId());
            customerDto.setName(customer.getName());
            customerDto.setAddress(customer.getAddress());
            customerDto.setAge(customer.getAge());
            return customerDto;

        }else {
            return null;
        }

    }

    @Override
    public List<Customer> getAll() {
        final List<Customer> all = customerRepo.findAll();
        return all;
    }
}
