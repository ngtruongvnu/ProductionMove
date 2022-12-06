package com.project.productmove.controller;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class created at 12/5/2022 18:02:05
 *
 * @author HoàngKhôngNgủ
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/findAll")
    List<CustomerDTO> findAll(){
        return customerService.findAll();
    }
}
