package com.example.journal.controlar;

import com.example.journal.Entity.OrderItme;
import com.example.journal.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.journal.Repository.OrderItemRepository;

@Controller
@RequestMapping("/Order")
public class OrderContoler {

    private final CustomerService service;
    private final OrderItemRepository orderItemRepository;
    public OrderContoler(CustomerService service, OrderItemRepository orderItemRepository) {
        this.service = service;
        this.orderItemRepository = orderItemRepository;
    }


    @GetMapping("/newOrder")
    public String addOrder(Model model){
        model.addAttribute("order",new OrderItme());
        return "new_order";
    }
@PostMapping("/save")
    public String saveOrder(@ModelAttribute OrderItme order){
    orderItemRepository.save(order);

    return "redirect:/orders/list";
}

}
