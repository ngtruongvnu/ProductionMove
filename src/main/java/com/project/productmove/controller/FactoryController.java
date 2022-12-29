package com.project.productmove.controller;

/**
 * This class was created at 12/28/2022 15:06:38
 *
 * @author Minh.LN
 */

import com.project.productmove.dto.ProductBatchesAndProduclineDTO;
import com.project.productmove.dto.ProductBatchesDTO;
import com.project.productmove.service.ProductBatchService;
import com.project.productmove.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/factory")
public class FactoryController {
    static private Logger log = LogManager.getLogger(FactoryController.class);

    @Autowired
    ProductBatchService productBatchService;

    @Autowired
    ProductService productService;

    @GetMapping("/get-product-batch")
    ResponseEntity<Object> getProducbatch(@RequestParam Long user_id)
    {
        try {
            List<ProductBatchesAndProduclineDTO> list = productBatchService.getProductBatche(user_id);
            log.info("get productbatch ok");
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            log.error("Unexpected Error! (Should not be exist)");
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
    }

    @PostMapping("/insert-products")
    ResponseEntity<Object> insertProducts(@RequestParam Long user_id,@RequestParam Long productline_id, @RequestParam Long quanlity, @RequestParam Long place_at)
    {
        try {

            return ResponseEntity.ok().body(productService.insertProducts(user_id, productline_id,quanlity,place_at));
        } catch (Exception e) {
            log.error("Unexpected Error! (Should not be exist)");
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
    }


    @GetMapping("/get-products")
    ResponseEntity<Object> getProducts(@RequestParam Long user_id){
        return ResponseEntity.ok().body(productService.getProducts(user_id));
    }

    @PostMapping("/send-to-agent/{userID}/{agentID}")
    ResponseEntity<Object> sendToAgent(@PathVariable("userID") Long userID,@PathVariable("agentID") Long agentID, @RequestBody List<Long> listId){
        try {
            Integer siz = productService.sendToAgent(userID, agentID, listId);
            log.info("sendToAgent ok");
            return ResponseEntity.ok().body("Nhập thành công "+siz+" sản phẩm");
        } catch (Exception e) {
            log.error("Unexpected Error! (Should not be exist)");
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
    }

    @GetMapping("/product-error")
    ResponseEntity<Object> getProductError(@RequestParam Long user_id){
        return ResponseEntity.ok().body(productService.getProductError(user_id));
    }

//    @GetMapping("/get-product-by-filter-productline")
//    ResponseEntity<Object> getProductByFilterProductline(){
//
//    }
    @GetMapping("/error/get-error-by-filter-productline")
    ResponseEntity<Object> getProductErrorByProductline(@RequestParam Long user_id){
        return ResponseEntity.ok().body(productService.getProductErrorByProductline(user_id));
    }

    @GetMapping("/get-error-by-filter-productbatch")
    ResponseEntity<Object> getErrorByFilterProductbatch(@RequestParam Long user_id, @RequestParam Long productline_id){
        return ResponseEntity.ok().body(productService.getErrorByFilterProductbatch(user_id, productline_id));
    }

    @PostMapping("/recover-by-product-batch-id")
    ResponseEntity<Object> getRecoverByProductBatchId(@RequestParam Long productbatch_id){
        return ResponseEntity.ok().body(productService.recoverByProductBatchId(productbatch_id));
    }

}
