package com.pizzaportal.service;

import com.pizzaportal.data.dto.CustomerDto;
import com.pizzaportal.data.entity.Customer;
import com.pizzaportal.data.repository.CustomerRepository;
import com.pizzaportal.mapper.CustomerMapper;
import com.pizzaportal.service.ex.CustomerAlreadyExistsException;
import com.pizzaportal.service.ex.InvalidRatingException;
import com.pizzaportal.service.ex.NoSuchCustomerException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public Optional<CustomerDto> getCustomerByPhoneNumber(String phoneNumber) {
        return repository.findByPhone(phoneNumber)
                .map(mapper::toDto);
    }

    @Override
    @Transactional
    public void updateRating(double rating, String phoneNumber) {
        Customer customer = repository.findByPhone(phoneNumber)
                .orElseThrow(() -> new NoSuchCustomerException(String.format("No such customer for phone number %s", phoneNumber)));

        if (rating < 0) {
            throw new InvalidRatingException("Negative values for rating are not allowed!");
        }

        customer.setRating(rating);
    }

    @Override
    public CustomerDto insertNewCustomer(CustomerDto dto) {
        Optional<Customer> optCustomer = repository.findByPhone(dto.getPhone());
        if (optCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists!");
        }

        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
