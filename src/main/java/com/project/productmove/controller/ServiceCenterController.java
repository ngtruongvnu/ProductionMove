package com.project.productmove.controller;

import com.project.productmove.dto.ProductsDTO;
import com.project.productmove.service.ServiceCenterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
