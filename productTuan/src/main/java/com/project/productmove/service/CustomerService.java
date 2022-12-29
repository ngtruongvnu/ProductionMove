package com.project.productmove.service;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.OrderForProductDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService {
    List<CustomerDTO> findAll();
    void addCustomer(CustomerDTO customerDTO);
    void deleteCustomer(CustomerDTO customerDTO);

    CustomerDTO notifyCustomer(OrderForProductDTO orderForProductDTO);


}
