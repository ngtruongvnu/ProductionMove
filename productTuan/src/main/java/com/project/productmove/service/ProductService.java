package com.project.productmove.service;

import com.project.productmove.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    List<SellProductFilterTime> getProductSoldFilterTime(String filter);

    void setStatusAndSaveRecordProductSold(SellProductDTO sellProductDTO, int status);

    ProductStatusDTO getProductByStatus();

    Product_4_DTO getProduct4(Long id);

    Integer sendToAgent(Long user_id, Long agentID, List<Long> listId);

}
