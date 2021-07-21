package com.ifisolution.bussiness_management.services;

import com.ifisolution.bussiness_management.exceptions.CustomerNotFoundException;
import com.ifisolution.bussiness_management.models.Customer;
import com.ifisolution.bussiness_management.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepo.findCustomerById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer by id " + id + " was not found"));
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteCustomerById(id);
    }
}
