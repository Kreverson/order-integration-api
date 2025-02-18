package artapp.order_integration.controller;

import artapp.order_integration.controller.dto.ApiResponse;
import artapp.order_integration.controller.dto.OrderResponse;
import artapp.order_integration.controller.dto.PaginationResponse;
import artapp.order_integration.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ApiResponse<OrderResponse>> getAllOrderByCustomer(@PathVariable("customerId") Long customerId,
                                                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        var pageResponse = orderService.findAllByCustomerId(customerId, PageRequest.of(page, pageSize));

        return ResponseEntity.ok(
                new ApiResponse<>(
                        pageResponse.getContent(),
                        PaginationResponse.fromPage(pageResponse)));
    }
}
