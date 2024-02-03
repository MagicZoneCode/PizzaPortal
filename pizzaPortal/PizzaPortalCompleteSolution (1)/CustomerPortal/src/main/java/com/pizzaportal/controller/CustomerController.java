package com.pizzaportal.controller;

import com.pizzaportal.data.dto.CustomerDto;
import com.pizzaportal.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/by-phone")
    public ResponseEntity<CustomerDto> byPhone(@RequestParam String phoneNumber) {
        return ResponseEntity.of(service.getCustomerByPhoneNumber(phoneNumber));
    }

    @PatchMapping("/update-rating/{phoneNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRatingPhoneNumber(@RequestParam double rating,
                                        @PathVariable String phoneNumber) {
        service.updateRating(rating, phoneNumber);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> newCustomer(@RequestBody CustomerDto dto) {
        CustomerDto savedCustomer = service.insertNewCustomer(dto);
        //http://www.customerapi.com/by-phone?phoneNumber=123456789
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/by-phone")
                .queryParam("phoneNumber", savedCustomer.getPhone())
                .build()
                .toUri();

        return ResponseEntity.created(location).body(savedCustomer);
    }
}
