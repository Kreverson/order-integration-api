package artapp.order_integration.listener;

import artapp.order_integration.listener.dto.OrderCreatedEvent;
import artapp.order_integration.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static artapp.order_integration.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {
    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);
    private final OrderService orderService;

    public OrderCreatedListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listener(Message<OrderCreatedEvent> message) {
        logger.info("Message consumed: {}", message.getPayload());

        orderService.save(message.getPayload());
    }
}
