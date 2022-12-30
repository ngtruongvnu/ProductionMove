package com.project.productmove.service;

import com.project.productmove.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    List<SellProductFilterTime> getProductSoldFilterTime(String filter);

    void setStatusAndSaveRecordProductSold(OrderForProductDTO orderForProductDTO, int status);

    ProductStatusDTO getProductByStatus();

    String insertProducts(Long user_id,Long productline_id,Long quanlity,Long place_at);

    List<ProductsDTO> getProducts(Long user_id);

    Product_4_DTO getProduct4(Long id);

    Integer sendToAgent(Long user_id, Long agentID, List<Long> listId);

    List<ProductsDTO> getProductError(Long user_id);

    List<Object[]> getProductErrorByProductline(Long user_id);

    String recoverByProductBatchId(Long productbatch_id);

    List<ErrorProductBatchDTO> getErrorByFilterProductbatch(Long user_id, Long productline_id);

    List<ProductThongKeDTO> getProductByAgent();
    List<ProductThongKeDTO> getProductByServiceCenter();
    List<ProductThongKeDTO> getProductByFactory();

    List<ProductsInfooDto> getInfoProducts();
    String recoveryByProductBatchId( Long productline_id);

}
