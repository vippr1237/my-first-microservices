package com.ifisolution.bussiness_management.controllers;

import com.ifisolution.bussiness_management.models.Customer;
import com.ifisolution.bussiness_management.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> Customers = customerService.findAllCustomers();
        return new ResponseEntity<>(Customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer Customer = customerService.findCustomerById(id);
        return new ResponseEntity<>(Customer, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer Customer) {
        Customer newCustomer = customerService.addCustomer(Customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer Customer) {
        Customer updateCustomer = customerService.updateCustomer(Customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    // Theo stackoverflow thì transaction cập nhật nên phải thêm
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
