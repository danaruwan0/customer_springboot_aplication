package lk.customer.customer.controller;


import lk.customer.customer.dto.CustomerDto;
import lk.customer.customer.entyty.Customer;
import lk.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aswasuma/api/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    ResponseEntity save(@RequestBody CustomerDto customerDto) {
        try {
            customerService.save(customerDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/update")
    ResponseEntity update(@RequestBody CustomerDto customerDto) {
        customerService.update(customerDto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Customer>> getAll() {
        try {
            List<Customer> all = customerService.getAll();
            return ResponseEntity.ok().body(all);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.ok("delete success");
    }
}

//    @GetMapping("/get/{id}")
//        CustomerDto get(@PathVariable int id){
//
//    }