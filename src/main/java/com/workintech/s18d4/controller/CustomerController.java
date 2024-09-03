package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.find(id);
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody Customer customer) {
        Customer saved = this.customerService.save(customer);
        return new CustomerResponse(saved.getId(), saved.getEmail(), saved.getSalary());
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer saved = this.customerService.find(id);
        saved.setSalary(customer.getSalary());
        saved.setEmail(customer.getEmail());
        Customer updated = this.customerService.save(saved);
        return new CustomerResponse(updated.getId(), updated.getEmail(), updated.getSalary());
    }
}
