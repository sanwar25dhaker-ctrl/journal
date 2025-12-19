package com.example.journal.Service;

import com.example.journal.Entity.Customer;
import com.example.journal.Repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo repository;

    public CustomerService(CustomerRepo repository) {
        this.repository = repository;
    }

    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
