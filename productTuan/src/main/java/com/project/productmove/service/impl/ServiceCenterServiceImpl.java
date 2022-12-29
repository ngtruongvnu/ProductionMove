package com.project.productmove.service.impl;


import com.project.productmove.dto.*;
import com.project.productmove.repo.ErrorsRepo;
import com.project.productmove.repo.ProductLineDetailRepo;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.service.ServiceCenterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class ServiceCenterServiceImpl implements ServiceCenterService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ErrorsRepo errorsRepo;

    @Autowired
    ProductLineDetailRepo productLineDetailRepo;



    @Override
    public void sendBackSuccessProductToAgent(ProductsDTO productsDTO) {
         log.info(productsDTO.getUserId() + "       "  +   productsDTO.getId());
         productRepo.upDateUserId(productsDTO.getUserId(),productsDTO.getId());
    }

    @Override
    public void sendProductFailedToFactory(ProductsDTO productsDTO) {
        productRepo.upDateUserId(productsDTO.getUserId(),productsDTO.getId());
    }

    @Override
    public List<ErrorFilterByProductDTO> getListProductError() {
        List<ErrorFilterByProductDTO> errorFilterByProductDTOList = new ArrayList<>();
        List<Object[]> listErrorFilterByProduct = errorsRepo.getErrorProductToFilter();
        List<Long> listProductId = new ArrayList<>();
        for(Object[] obj : listErrorFilterByProduct){
            if(!listProductId.contains(Long.parseLong(String.valueOf(obj[1])))) {
                ErrorFilterByProductDTO eFBP = new ErrorFilterByProductDTO();
                List<String> errors = new ArrayList<>();
                eFBP.setProductName(obj[0].toString());
                eFBP.setProduct_id(Long.parseLong(String.valueOf(obj[1])));
                listProductId.add(Long.parseLong(String.valueOf(obj[1])));
                errors.add((String) obj[2]);
                eFBP.setProductErrorList(errors);
                errorFilterByProductDTOList.add(eFBP);
            } else {
                for(ErrorFilterByProductDTO efbp : errorFilterByProductDTOList){
                    if(efbp.getProduct_id() == Long.parseLong(String.valueOf(obj[1]))){
                        efbp.getProductErrorList().add((String) obj[2]);
                        break;
                    }
                }
            }
        }
        return errorFilterByProductDTOList;
    }

    @Override
    public List<ErrorFilterByProductLineDTO> getListProductLineError() {
        List<ErrorFilterByProductLineDTO> errorFilterByProductLineDTOS = new ArrayList<>();
        List<Object[]> listError = errorsRepo.listProductLineError();
        List<Object[]> countProduct = productRepo.listProductLineCount();
        log.info("get listError and countProduct success");
        for(Object[] objects1 : listError){
            for(Object[] objects2 : countProduct){
                log.info(Long.parseLong(String.valueOf(objects2[0])));
                log.info(Long.parseLong(String.valueOf(objects1[1])));
                if(String.valueOf(objects2[0]).equals(String.valueOf(objects1[1]))
                    && (BigInteger)objects2[1] == (BigInteger) objects1[3]){
                    log.info("ProductLine error name : " + String.valueOf(objects1[0]));
                    ErrorFilterByProductLineDTO efbpl = new ErrorFilterByProductLineDTO();
                    efbpl.setProductLineId(Long.parseLong(String.valueOf(objects1[1])));
                    efbpl.setDescibleError(String.valueOf(objects1[2]));
                    efbpl.setProductName(String.valueOf(objects1[0]));
                    errorFilterByProductLineDTOS.add(efbpl);
                    break;
                }
            }
        }
        return errorFilterByProductLineDTOS;
    }

    @Override
    public void sendToWarehouseServiceDTO(long warehouseId, long userId, long productId) {
        productRepo.upDateWarehouseAndUser(warehouseId,userId,productId);
    }


}
