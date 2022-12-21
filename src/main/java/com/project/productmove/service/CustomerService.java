package com.project.productmove.service;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Component
public interface CustomerService {
    List<CustomerDTO> findAll();
    List<CustomerDTO> upDateNew();
    void addCustomer(CustomerDTO customerDTO);
    void deleteCustomer(CustomerDTO customerDTO);
}
