package com.project.productmove.service.impl;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.entity.CustomerEntity;
import com.project.productmove.entity.OrderForProductEntity;
import com.project.productmove.entity.ProductsEntity;
import com.project.productmove.repo.CustomerRepo;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.service.CustomerService;
import com.project.productmove.service.OrderForProductRepo;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class created at 12/5/2022 12:00:07
 *
 * @author HoàngKhôngNgủ
 */
@Log4j2
@Service
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager en;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderForProductRepo orderForProductRepo;

    @Override
    public List<CustomerDTO> findAll(){
        List<CustomerEntity> listE = customerRepo.findAll();
        List<CustomerDTO> ListD = listE.stream().map(CustomerEntity -> modelMapper.map(CustomerEntity,
                        CustomerDTO.class))
                .collect(Collectors.toList());
        return ListD;
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

    @Override
    public CustomerDTO notifyCustomer(OrderForProductDTO orderForProductDTO) {
        ProductsEntity productsEntity = productRepo.getById(orderForProductDTO.getProductId());
        LocalDateTime current = LocalDateTime.now();
        Instant instant = current.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        if(productsEntity != null && productsEntity.getStatus()==1){
            log.info("productsEntity != null && productsEntity.getStatus()==1");
            OrderForProductEntity orderForProductEntity = modelMapper.map(orderForProductDTO, OrderForProductEntity.class);
            productRepo.upDateStatus(2, orderForProductDTO.getProductId());
            orderForProductEntity.setCreatedDate(date);
            orderForProductRepo.save(orderForProductEntity);
            CustomerEntity customerEntity = customerRepo.getById(orderForProductDTO.getCustomerId());
            CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
            return customerDTO;
        } else {
            log.info("loi entity khong ton tai hoac status khong hop le");
        }
        return null;
    }


}