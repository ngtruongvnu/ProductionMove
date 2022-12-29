package com.project.productmove.service;

import com.project.productmove.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServiceCenterService {

    void sendBackSuccessProductToAgent(ProductsDTO productsDTO);
    void sendProductFailedToFactory(ProductsDTO productsDTO);

    List<ErrorFilterByProductDTO> getListProductError();

    List<ErrorFilterByProductLineDTO> getListProductLineError();
    void sendToWarehouseServiceDTO(long warehouseId, long userId, long productId);




}
