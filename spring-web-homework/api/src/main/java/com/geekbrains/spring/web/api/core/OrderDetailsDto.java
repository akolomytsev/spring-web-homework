package com.geekbrains.spring.web.api.core;


import io.swagger.v3.oas.annotations.media.Schema;

public class OrderDetailsDto {
    @Schema(description = "Адрес доставки", required = true, maxLength = 255, minLength = 3, example = "Тибет_@xxx.com")
    private String address;

    @Schema(description = "Номер телефона пользователя", required = true, example = "8-800-2000-600")
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }
}
