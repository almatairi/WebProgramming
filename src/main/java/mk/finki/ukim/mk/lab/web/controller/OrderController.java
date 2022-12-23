package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrdersPage(Model model){
        model.addAttribute ("orders", this.orderService.findAll ());
        return "userOrders";
    }

    @GetMapping("/add")
    public String postOrdersPage(){
        Order order = this.orderService.getPendingOrder ();
        this.orderService.save(order.getBalloonColor(), order.getBalloonSize(), order.getClientName(), order.getClientAddress());
        this.orderService.removePendingOrder();
        return "redirect:/orders";
    }
}
