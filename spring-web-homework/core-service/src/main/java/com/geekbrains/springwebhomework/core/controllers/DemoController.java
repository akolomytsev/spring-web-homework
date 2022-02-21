package com.geekbrains.springwebhomework.core.controllers;

import com.geekbrains.spring.web.api.dto.StringResponse;
import com.geekbrains.springwebhomework.core.intrgrations.CartServiceIntegration;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
@Tag(name = "Просто так контроллер", description = "Метод для передачи ошибки из корзины")
public class DemoController {
    private final CartServiceIntegration cartServiceIntegration;

    @GetMapping
    public StringResponse demo() {
        cartServiceIntegration.getUserCart("1");
        return new StringResponse("OK");
    }
}
