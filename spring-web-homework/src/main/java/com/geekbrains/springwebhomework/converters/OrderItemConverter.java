package com.geekbrains.springwebhomework.converters;

import com.geekbrains.springwebhomework.dto.OrderItemDto;
import com.geekbrains.springwebhomework.dto.ProductDto;
import com.geekbrains.springwebhomework.entities.OrderItem;
import com.geekbrains.springwebhomework.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter {
    public OrderItem dtoToEntity(OrderItemDto orderItemDto) {
        throw new UnsupportedOperationException();
    }

    public OrderItemDto entityToDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.getProduct().getId(), orderItem.getProduct().getTitle(), orderItem.getQuantity(), orderItem.getPricePerProduct(), orderItem.getPrice());
    }
}
