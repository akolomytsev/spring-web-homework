package com.geekbrains.springwebhomework.services;

import com.geekbrains.springwebhomework.dto.Cart;
import com.geekbrains.springwebhomework.dto.OrderDetailsDto;
import com.geekbrains.springwebhomework.dto.ProductDto;
import com.geekbrains.springwebhomework.entities.Order;
import com.geekbrains.springwebhomework.entities.OrderItem;
import com.geekbrains.springwebhomework.entities.Product;
import com.geekbrains.springwebhomework.entities.User;
import com.geekbrains.springwebhomework.exceptions.ResourceNotFoundException;
import com.geekbrains.springwebhomework.repositories.OrdersRepository;
import com.geekbrains.springwebhomework.repositories.ProductsRepository;
import com.geekbrains.springwebhomework.repositories.specifications.ProductsSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrdersRepository ordersRepository;
    private final CartService cartService;
    private final ProductsService productsService;

    @Transactional
    public void createOrder(User user, OrderDetailsDto orderDetailsDto) {
        Cart currentCart = cartService.getCurrentCart();
        Order order = new Order();
        order.setAddress(orderDetailsDto.getAddress());
        order.setPhone(orderDetailsDto.getPhone());
        order.setUser(user);
        order.setTotalPrice(currentCart.getTotalPrice());
        List<OrderItem> items = currentCart.getItems().stream()
                .map(o -> {
                    OrderItem item = new OrderItem();
                    item.setOrder(order);
                    item.setQuantity(o.getQuantity());
                    item.setPricePerProduct(o.getPricePerProduct());
                    item.setPrice(o.getPrice());
                    item.setProduct(productsService.findById(o.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
                    return item;
                }).collect(Collectors.toList());
        order.setItems(items);
        ordersRepository.save(order);
        currentCart.clear();
    }

    public List<Order> findOrdersByUsername(String username) {
        return ordersRepository.findAllByUsername(username);
    }
}
