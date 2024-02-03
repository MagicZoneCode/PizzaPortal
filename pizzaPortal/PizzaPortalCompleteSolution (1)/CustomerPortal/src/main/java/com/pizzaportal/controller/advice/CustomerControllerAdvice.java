package com.pizzaportal.controller.advice;

import com.pizzaportal.controller.CustomerController;
import com.pizzaportal.service.ex.CustomerAlreadyExistsException;
import com.pizzaportal.service.ex.InvalidRatingException;
import com.pizzaportal.service.ex.NoSuchCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = CustomerController.class)
public class CustomerControllerAdvice {
    @ExceptionHandler(NoSuchCustomerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleNoSuchCustomer(NoSuchCustomerException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler({InvalidRatingException.class, CustomerAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleForBadRequest(RuntimeException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
