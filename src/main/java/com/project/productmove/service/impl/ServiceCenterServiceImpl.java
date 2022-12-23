package com.project.productmove.service.impl;


import com.project.productmove.dto.ProductsDTO;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCenterServiceImpl implements ServiceCenterService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public void sendBackSuccessProductToAgent(ProductsDTO productsDTO) {
         productRepo.upDateUserId(productsDTO.getUserId(),productsDTO.getId());
    }

    @Override
    public void sendProductFailedToFactory(ProductsDTO productsDTO) {
        productRepo.upDateUserId(productsDTO.getUserId(),productsDTO.getId());
    }
}
