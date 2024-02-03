package com.pizzaportal.service;

import com.pizzaportal.data.dto.CustomerDto;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerDto> getCustomerByPhoneNumber(String phoneNumber);

    void updateRating(double rating, String phoneNumber);

    CustomerDto insertNewCustomer(CustomerDto dto);
}
