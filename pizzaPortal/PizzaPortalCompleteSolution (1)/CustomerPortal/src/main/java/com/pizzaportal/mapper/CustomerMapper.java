package com.pizzaportal.mapper;

import com.pizzaportal.data.dto.CustomerDto;
import com.pizzaportal.data.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);
}
