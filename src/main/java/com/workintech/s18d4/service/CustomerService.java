package com.workintech.s18d4.service;


import com.workintech.s18d4.entity.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> findAll();
    Customer save(Customer customer);
    Customer find(Long id);
    Customer delete(Long id);
}
