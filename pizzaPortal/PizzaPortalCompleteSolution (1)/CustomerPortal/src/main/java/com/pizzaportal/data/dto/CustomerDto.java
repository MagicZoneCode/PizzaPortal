package com.pizzaportal.data.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String address;
    private String phone;
    private double rating;
}
