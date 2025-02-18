package artapp.order_integration.repository;

import artapp.order_integration.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByCustomerId(Long customerId);
}
