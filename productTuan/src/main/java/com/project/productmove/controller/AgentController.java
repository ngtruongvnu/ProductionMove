package com.project.productmove.controller;

import com.project.productmove.dto.*;
import com.project.productmove.service.CustomerService;
import com.project.productmove.service.ProductLineDetailService;
import com.project.productmove.service.ProductService;
import com.project.productmove.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/agent")

public class AgentController {

    private static Logger log = LogManager.getLogger();

    @Autowired
    UserService userService;


    @Autowired
    ProductLineDetailService productLineDetailService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @PostMapping("/receive-from-factory")
    ResponseEntity<Object> receiveFromFactory(@RequestParam("user_id") String userId,
                                              @RequestBody ProductReceiveFromFactory productReceiveFromFactory){
        log.info(productReceiveFromFactory.getFactoryId());
        log.info(productReceiveFromFactory.getProductIdList());

        return ResponseEntity.ok(productReceiveFromFactory);
    }

    @PostMapping("/sell-product")
    ResponseEntity<Object> sellProduct(@RequestParam("user_id") String userId,
                                       @RequestBody OrderForProductDTO orderForProductDTO){
        log.info(orderForProductDTO.getCustomerId());
        log.info(orderForProductDTO.getProductId());
        productService.setStatusAndSaveRecordProductSold(orderForProductDTO,2);
        //userService.customerReceiveWarrantyProduct(1,orderForProductDTO.getProductId());
        return ResponseEntity.ok(orderForProductDTO);
    }

    @PostMapping("/warranty_product")
    ResponseEntity<Object> warranty_product(@RequestParam("user_id") String userId){
        return null;
    }

    @GetMapping("/customer_receive_warranty_product")
    ResponseEntity<Object> cusReceiveWarrantyProduct(@RequestParam("user_id") long userId,
                                                     @RequestParam("product_id") long productId){
        userService.customerReceiveWarrantyProduct(6,productId);
        return ResponseEntity.ok("Chuyển thành công");
    }

    @PostMapping("/product_recall")
    ResponseEntity<Object> productRecall(@RequestParam("user_id") String userId,
                                         @RequestParam("productline_detail_id") long productLine){
        String result = productLineDetailService.checkProductWarranty(productLine);
        if(result.equals("true")) {
            List<Long> listProductId = userService.getListProductIdByPrDetail(productLine);
            for (Long id : listProductId) {
                log.info("product_id in list:" + id);
                userService.customerReceiveWarrantyProduct(8, id);
            }
        }

        return null;
    }


    @GetMapping("/get-sell-product-filter-time")
    ResponseEntity<Object> getSellProductFilterTime(@RequestParam("user_id") String userId,
                                                    @RequestParam("filter") String filter){
        List<SellProductFilterTime> listResult = productService.getProductSoldFilterTime(filter);
        return ResponseEntity.ok(listResult);
    }

//    @GetMapping("/get-impossible-fix-product")
//    ResponseEntity<Object> getImpossibleFixProduct(@RequestParam("user_id") long userId){
//        List<SellProductFilterTime> listResult = productService.getProductSoldFilterTime(filter);
//        return ResponseEntity.ok(listResult);
//    }

    @PostMapping("/notify-customer")
    ResponseEntity<Object> notifyCustomer(@RequestParam("user_id") long userId,
                                          @RequestBody OrderForProductDTO orderForProductDTO){
        CustomerDTO customerDTO;
        try{
            log.info("customer_id: " + orderForProductDTO.getCustomerId()+"  product_id:  "+orderForProductDTO.getProductId());
            orderForProductDTO.setSellBy(userId);
            customerDTO = customerService.notifyCustomer(orderForProductDTO);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(customerDTO);
    }

    @PostMapping("/receive-from-service")
    ResponseEntity<Object> receiveFromService(@RequestParam("user_id") String userId,
                                              @RequestBody ProductsDTO productsDTO){
        try {
            System.out.println("warehouseId: " + productsDTO.getPlace() + "  ,   productId: " + productsDTO.getId());
            userService.customerReceiveWarrantyProduct(5,productsDTO.getId());
            userService.UpdateWarehouseAfterReceiveFromSC(productsDTO.getPlace(),productsDTO.getId());
        } catch (Exception e){
            return new ResponseEntity<Object>(e, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("success");
    }

    @PostMapping("/recall-by-batch")
    ResponseEntity<Object> recallByBatch(@RequestParam("user_id") String userId,
                                                    @RequestBody RecallByBatchDTO recallByBatchDTO){

        try {
           userService.recallByBatch(recallByBatchDTO);
        } catch (Exception e){
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("success");
    }



}
