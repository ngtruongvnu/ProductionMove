package com.project.productmove.service.impl;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.entity.CustomerEntity;
import com.project.productmove.repo.CustomerRepo;
import com.project.productmove.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * This class created at 12/5/2022 12:00:07
 *
 * @author HoàngKhôngNgủ
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager en;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public List<CustomerDTO> findAll(){
        List<CustomerEntity> listE = customerRepo.findAll();
        List<CustomerDTO> ListD = listE.stream().map(CustomerEntity -> modelMapper.map(CustomerEntity,
                        CustomerDTO.class))
                .collect(Collectors.toList());
        return ListD;
    }

    @Override
    public List<CustomerDTO> upDateNew() {
        return null;
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO,CustomerEntity.class);
        System.out.println("use");
        System.out.println(customerEntity);
        customerRepo.save(customerEntity);
    }

    @Override
    @Transactional
    public void deleteCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO,CustomerEntity.class);

        System.out.println("use");
        customerRepo.deleteById(1);
    }




}