package com.Microservices.orderservice.Service;


import com.Microservices.orderservice.DTO.OrderLineItemsDto;
import com.Microservices.orderservice.DTO.OrderRequest;
import com.Microservices.orderservice.Model.Order;
import com.Microservices.orderservice.Model.OrderLineItems;
import com.Microservices.orderservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList =  orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::MapToDTO)
                .toList();

        order.setOrderLineItemsList(orderLineItemsList);
        orderRepository.save(order);
                

    }

    private OrderLineItems MapToDTO(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }

}
