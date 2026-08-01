package com.example.journal.controlar;

import com.example.journal.Entity.Customer;
import com.example.journal.Repository.CustomerRepo;
import com.example.journal.Repository.OrderItemRepository;
import com.example.journal.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerUIController {

    private final CustomerService service;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepo customerRepo;

    public CustomerUIController(CustomerService service,
                                OrderItemRepository orderItemRepository ,CustomerRepo customerRepo) {
        this.service = service;
        this.orderItemRepository = orderItemRepository;
        this.customerRepo = customerRepo;
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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {

        Long totalOrders = orderItemRepository.count();
        Long totalCustomer = customerRepo.count();

        System.out.println("Total Orders = " + totalOrders);

        model.addAttribute("totalOrders", totalOrders);
        model.addAttribute("totalcustomer",totalCustomer);

        return "home";
    }

}
