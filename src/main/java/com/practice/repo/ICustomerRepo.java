package com.practice.repo;

import com.practice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findByNameContainingOrCityContaining(String name, String city);
    List<Customer> findByStatusEquals(String status);
    List<Customer> findByNameContainingAndStatusEquals(String name, String status);

}
