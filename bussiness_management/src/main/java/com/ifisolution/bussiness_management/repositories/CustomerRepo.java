package com.ifisolution.bussiness_management.repositories;

import com.ifisolution.bussiness_management.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(Long id);

    void deleteCustomerById(Long id);
}
