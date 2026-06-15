package com.practice.service.implementation;

import com.practice.entity.Customer;
import com.practice.repo.ICustomerRepo;
import com.practice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerServiceImplementation implements ICustomerService {

    private final ICustomerRepo repo;

    @Autowired
    public ICustomerServiceImplementation(ICustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public void saveCustomer(Customer customer) {
        repo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return repo.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void updateCustomer(Customer customer) {
        repo.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Customer> searchByNameContainingOrCityContaining(String name, String city) {
        return repo.findByNameContainingOrCityContaining(name, city);
    }

    @Override
    public List<Customer> searchByStatusEquals(String status) {
        return repo.findByStatusEquals(status);
    }

    @Override
    public List<Customer> searchByNameContainingAndStatusEquals(String name, String status) {
        return repo.findByNameContainingAndStatusEquals(name, status);
    }

    @Override
    public List<Customer> getAllCustomerSorted(String sortBy, String order) {
        Sort sort = Sort.by(order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return repo.findAll(sort);
    }

    @Override
    public Page<Customer> getCustomerByPage(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return repo.findAll(pageRequest);
    }
}
