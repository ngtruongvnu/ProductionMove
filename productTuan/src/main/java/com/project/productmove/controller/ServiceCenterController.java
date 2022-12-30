package com.project.productmove.controller;

import com.project.productmove.dto.*;
import com.project.productmove.service.ServiceCenterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * This class created at 12/18/2022 16:09:49
 *
 * @author HoàngKhôngNgủ
 */
@RestController
@RequestMapping("api/v1/service-center")
@Log4j2
public class ServiceCenterController {

    @Autowired
    ServiceCenterService serviceCenterService;

    @GetMapping("/receive_warranty_product_fiter")
    ResponseEntity<Object> receiveWarrantyProductFiter(@RequestParam("user_id") long userId,
                                           @RequestParam("filter") String filter){
        if(filter.equals("product")) {
            log.info("filter is product");
            List<ErrorFilterByProductDTO> result1 = serviceCenterService.getListProductError();
            return ResponseEntity.ok(result1);
        } else if(filter.equals("product_line")){
            log.info("filter is product_line");
            List<ErrorFilterByProductLineDTO> result2 = serviceCenterService.getListProductLineError();
            return ResponseEntity.ok(result2);
        }

//        try {
//            result = serviceCenterService.getListProductError();
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return ResponseEntity.ok("filter doesn't exist");
    }

    @PostMapping("/send_to_warehouse_service")
    ResponseEntity<Object> sendToWarehouseService(@RequestParam("user_id") long userId,
                                                  @RequestBody SendToWarehouseServiceDTO sendToWarehouseServiceDTO){
        List<ErrorFilterByProductDTO> result1 = new ArrayList<>();
        try {
            for(long stws : sendToWarehouseServiceDTO.getProductIdList()) {
                serviceCenterService.sendToWarehouseServiceDTO(sendToWarehouseServiceDTO.getWarehouseId(),
                        userId,stws);
            }
            result1 = serviceCenterService.getListProductErrorByWarehouse(sendToWarehouseServiceDTO.getWarehouseId());
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(result1);
    }

    @PostMapping("/sendback_to_agent")
    ResponseEntity<Object> sendBackToAgent(@RequestParam("user_id") long userId,
                                           @RequestBody ProductsDTO productsDTO){
        try {
            serviceCenterService.sendBackSuccessProductToAgent(productsDTO);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Chuyển cho đại lý thành công");
    }

    @PostMapping("/send_to_factory")
    ResponseEntity<Object> sendToFactory(@RequestParam("user_id") long userId,
                                           @RequestBody ProductsDTO productsDTO){
        try {
            serviceCenterService.sendProductFailedToFactory(productsDTO);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Chuyển sản phẩm về nhà máy thành công");
    }

    @GetMapping("/get-list-warranty-product")
    ResponseEntity<Object> getListWarrantyProduct(@RequestParam("user_id") long userId){
        List <ProductWarrantyDTO> productWarrantyDTOList;
        try {
            productWarrantyDTOList = serviceCenterService.getListWarrantyProduct(userId);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(productWarrantyDTOList);
    }

    @PostMapping("/generate-error")
    ResponseEntity<Object> generateError(@RequestParam("user_id") long userId,
                                         @RequestBody ErrorsDTO errorsDTO){
         log.info(errorsDTO.getProductId() + " :  " + errorsDTO.getType());
         serviceCenterService.errorGenerate(errorsDTO);
//        try {
//            serviceCenterService.errorGenerate(errorsDTO);
//        } catch (Exception e) {
//            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return ResponseEntity.ok("Thành công");
    }

}
