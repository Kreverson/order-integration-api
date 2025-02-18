package artapp.order_integration.controller;

import artapp.order_integration.controller.dto.OrderResponse;
import artapp.order_integration.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/customer/{customerId}/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrderByCustomer(@PathVariable("customerId") Long customerId){
        return ResponseEntity.ok(orderService.findAllByCustomerId(customerId));
    }
}
