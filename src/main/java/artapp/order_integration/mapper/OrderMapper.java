package artapp.order_integration.mapper;

import artapp.order_integration.controller.dto.OrderResponse;
import artapp.order_integration.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public abstract class OrderMapper {
    public static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public abstract OrderResponse toOrderResponse(OrderEntity entity);
}
