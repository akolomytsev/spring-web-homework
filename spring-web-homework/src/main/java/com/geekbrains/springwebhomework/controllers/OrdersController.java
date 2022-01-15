package com.geekbrains.springwebhomework.controllers;

import com.geekbrains.springwebhomework.converters.OrderConverter;
import com.geekbrains.springwebhomework.dto.OrderDetailsDto;
import com.geekbrains.springwebhomework.dto.OrderDto;
import com.geekbrains.springwebhomework.entities.Order;
import com.geekbrains.springwebhomework.entities.User;
import com.geekbrains.springwebhomework.exceptions.ResourceNotFoundException;
import com.geekbrains.springwebhomework.services.OrderService;
import com.geekbrains.springwebhomework.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal, @RequestBody OrderDetailsDto orderDetailsDto) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        orderService.createOrder(user, orderDetailsDto);
    }

    @GetMapping
    public List<OrderDto> getCurrentUserOrders(Principal principal) {
        return orderService.findOrdersByUsername(principal.getName()).stream()
                .map(orderConverter::entityToDto).collect(Collectors.toList());
    }
}
