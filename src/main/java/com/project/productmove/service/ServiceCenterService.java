package com.project.productmove.service;

import com.project.productmove.dto.ProductsDTO;
import com.project.productmove.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface ServiceCenterService {

    void sendBackSuccessProductToAgent(ProductsDTO productsDTO);
    void sendProductFailedToFactory(ProductsDTO productsDTO);
}
