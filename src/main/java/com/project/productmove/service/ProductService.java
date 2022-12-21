package com.project.productmove.service;

import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.dto.SellProductFilterTime;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    List<SellProductFilterTime> getProductSoldFilterTime(String filter);

    void setStatusAndSaveRecordProductSold(OrderForProductDTO orderForProductDTO, int status);
}
