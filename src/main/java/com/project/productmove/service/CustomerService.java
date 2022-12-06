package com.project.productmove.service;

import com.project.productmove.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService {
    List<CustomerDTO> findAll();
}
