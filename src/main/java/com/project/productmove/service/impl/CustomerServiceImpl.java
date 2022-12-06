package com.project.productmove.service.impl;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.entity.CustomerEntity;
import com.project.productmove.repo.CustomerRepo;
import com.project.productmove.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class created at 12/5/2022 12:00:07
 *
 * @author HoàngKhôngNgủ
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CustomerRepo accountRepo;
    @Override
    public List<CustomerDTO> findAll(){
        List<CustomerEntity> listE = accountRepo.findAll();
        List<CustomerDTO> ListD = listE.stream().map(AccountEntity -> modelMapper.map(AccountEntity,
                        CustomerDTO.class))
                .collect(Collectors.toList());
        return ListD;
    }
}
