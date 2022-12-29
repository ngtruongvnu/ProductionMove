package com.project.productmove.service;

import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.dto.ProductStatusDTO;
import com.project.productmove.dto.Product_4_DTO;
import com.project.productmove.dto.SellProductFilterTime;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    List<SellProductFilterTime> getProductSoldFilterTime(String filter);

    void setStatusAndSaveRecordProductSold(OrderForProductDTO orderForProductDTO, int status);

    ProductStatusDTO getProductByStatus();

    Product_4_DTO getProduct4(Long id);

    Integer sendToAgent(Long user_id, Long agentID, List<Long> listId);
}
