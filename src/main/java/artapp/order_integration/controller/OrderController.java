package artapp.order_integration.controller;

import artapp.order_integration.controller.dto.ApiResponse;
import artapp.order_integration.controller.dto.OrderResponse;
import artapp.order_integration.controller.dto.PaginationResponse;
import artapp.order_integration.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customers")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/{customerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> getAllOrderByCustomer(@PathVariable("customerId") Long customerId,
                                                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        var pageResponse = orderService.findAllByCustomerId(customerId, PageRequest.of(page, pageSize));
        var totalOnOrders = orderService.findTotalOnOrdersByCustomer(customerId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        Map.of("totalOnOrders", totalOnOrders),
                        pageResponse.getContent(),
                        PaginationResponse.fromPage(pageResponse)));
    }
}
