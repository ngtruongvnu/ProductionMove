package com.project.productmove.service;

import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.dto.Product_4_DTO;
import com.project.productmove.dto.SellProductFilterTime;
import com.project.productmove.dto.SumProductByStatusDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    List<SellProductFilterTime> getProductSoldFilterTime(String filter);

    void setStatusAndSaveRecordProductSold(OrderForProductDTO orderForProductDTO, int status);

    SumProductByStatusDTO getProductByStatus();

    Product_4_DTO getProduct4(Long id);
}
