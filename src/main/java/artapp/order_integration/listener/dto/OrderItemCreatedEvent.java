package artapp.order_integration.listener.dto;

import java.math.BigDecimal;

public record OrderItemCreatedEvent(String produto,
                                    Integer quantidade,
                                    BigDecimal preco) {
}
