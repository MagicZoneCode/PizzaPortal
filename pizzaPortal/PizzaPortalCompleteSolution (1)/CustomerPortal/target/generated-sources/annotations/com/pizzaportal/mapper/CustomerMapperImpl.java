package com.pizzaportal.mapper;

import com.pizzaportal.data.dto.CustomerDto;
import com.pizzaportal.data.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-10T21:18:37+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.name( dto.getName() );
        customer.address( dto.getAddress() );
        customer.phone( dto.getPhone() );
        customer.rating( dto.getRating() );

        return customer.build();
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setName( entity.getName() );
        customerDto.setAddress( entity.getAddress() );
        customerDto.setPhone( entity.getPhone() );
        customerDto.setRating( entity.getRating() );

        return customerDto;
    }
}
