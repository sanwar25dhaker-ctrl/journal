package com.example.journal.controlar;

import com.example.journal.Service.CustomerService;
import org.springframework.ui.Model;
import com.example.journal.Entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerUIController {


    private final CustomerService service;

    public CustomerUIController(CustomerService service) {
        this.service = service;
    }

    // Open Add Customer Page
    @GetMapping("/add")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add_customer";
    }

    // Save Customer
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        service.addCustomer(customer);
        return "redirect:/customers/list";
    }

    // View Customer List
    @GetMapping("/list")
    public String customerList(Model model) {
        model.addAttribute("customers", service.getAllCustomers());
        return "customer_list";
    }
}
