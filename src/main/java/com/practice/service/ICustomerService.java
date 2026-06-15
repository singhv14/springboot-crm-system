package com.practice.service;

import com.practice.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerService {

    void saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Integer id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer id);

    List<Customer> searchByNameContainingOrCityContaining(String name, String city);
    List<Customer> searchByStatusEquals(String status);
    List<Customer> searchByNameContainingAndStatusEquals(String name, String status);

    List<Customer> getAllCustomerSorted(String sortBy, String order);
    Page<Customer> getCustomerByPage(int pageNo, int pageSize);

}
