package com.pizzaportal.data.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.CharJdbcType;

import java.util.UUID;

public class PizzaOrder {
    @Id
    @JdbcType(CharJdbcType.class)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String customerPhoneNumber;
    private String description;
    private String status;
}
