package com.practice.controller;

import com.practice.entity.Customer;
import com.practice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private final ICustomerService service;

    @Autowired
    public CustomerController(ICustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers")
    public String getAllCustomers(
            Model model,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "") String status,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(defaultValue = "0") int page) {

        List<Customer> customers;

        // if search typed → search by name or city
        if (!search.isEmpty() && !status.isEmpty()) {
            customers = service.searchByNameContainingAndStatusEquals(search, status);
        } else if (!search.isEmpty()) {
            customers = service.searchByNameContainingOrCityContaining(search, search);
        } else if (!status.isEmpty()) {
            customers = service.searchByStatusEquals(status);
        } else {
            // no search → just sort and paginate
            customers = service.getAllCustomerSorted(sortBy, order);
        }

        model.addAttribute("customers", customers);
        model.addAttribute("search", search);
        model.addAttribute("status", status);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("order", order);
        return "Getallcustomers";
    }

    @GetMapping("/customers/add")
    public String showCustomers(@ModelAttribute("customer") Customer customer) {
        return "Showcustomerform";
    }

    @PostMapping("/customers/add")
    public String saveCustomers(@ModelAttribute("customer") Customer customer) {
        service.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String updateCustomersById(@PathVariable Integer id, Model model) {
        Customer customer = service.getCustomerById(id);
        model.addAttribute("customer",customer);
        return "Customerform";
    }

    @PostMapping("/customers/edit")
    public String editCustomersById(@ModelAttribute("customer") Customer customer) {
        service.saveCustomer(customer);
        return "redirect:/customers";
    }


    @GetMapping("/customers/delete/{id}")
    public String showDeleteConfirm(@PathVariable Integer id, Model model) {
        Customer customer = service.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "DeleteConfirm"; // show confirm page
    }


    @GetMapping("/customers/delete/confirm/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
        return "redirect:/customers";
    }

}
