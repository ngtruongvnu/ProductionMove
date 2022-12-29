package com.project.productmove.controller;

/**
 * This class was created at 12/28/2022 15:06:38
 *
 * @author Minh.LN
 */

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
    static private Logger log = LogManager.getLogger(AdminController.class);

    @Autowired
    ProductBatchService productBatchService;

    @Autowired
    ProductService productService;

    @GetMapping("/get-product-batch")
    ResponseEntity<Object> getProducbatch(@RequestParam Long user_id)
    {
        try {
            List<ProductBatchesDTO> list = productBatchService.getProductBatche(user_id);
            log.info("get productbatch ok");
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            log.error("Unexpected Error! (Should not be exist)");
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
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

    @PostMapping("/send-to-agent2/")
    ResponseEntity<Object> sendToAgent2(){
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        return ResponseEntity.ok().body(x);
    }


}
