package com.project.productmove.controller;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.dto.ProductReceiveFromFactory;
import com.project.productmove.dto.SellProductFilterTime;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.service.ProductService;
import com.project.productmove.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class created at 12/18/2022 16:02:22
 *
 * @author HoàngKhôngNgủ
 */
@RestController
@RequestMapping("api/v1/agent")

public class AgentController {

    private static Logger log = LogManager.getLogger();

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

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
        productService.setStatusAndSaveRecordProductSold(orderForProductDTO,1);
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
        userService.customerReceiveWarrantyProduct(5,productId);
        return ResponseEntity.ok("Chuyển thành công");
    }

    @PostMapping("/product_recall")
    ResponseEntity<Object> productRecall(@RequestParam("user_id") String userId,
                                         @RequestParam("productline_detail_id") long productLine){
        List<Long> listProductId = userService.getListProductIdByPrDetail(productLine);
        for (Long id : listProductId){
            log.info(id);
            userService.customerReceiveWarrantyProduct(8,id);
        }

        return null;
    }

    @GetMapping("/get-sell-product-filter-time")
    ResponseEntity<Object> getSellProductFilterTime(@RequestParam("user_id") String userId,
                                                    @RequestParam("filter") String filter){
        List<SellProductFilterTime> listResult = productService.getProductSoldFilterTime(filter);
        return ResponseEntity.ok(listResult);
    }


}
