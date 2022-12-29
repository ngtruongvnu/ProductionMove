package com.project.productmove.controller;

import com.project.productmove.dto.ProductStatusDTO;
import com.project.productmove.dto.Product_4_DTO;
import com.project.productmove.dto.ProductlineDetailsDTO;
import com.project.productmove.dto.UserDTO;
import com.project.productmove.service.ProductLineDetailService;
import com.project.productmove.service.ProductService;
import com.project.productmove.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class was created at 12/22/2022 15:01:42
 *
 * @author Minh.LN
 */
@RestController
@RequestMapping("api/v1")
public class AdminController {

    static private Logger log = LogManager.getLogger(AdminController.class);

    @Autowired
    ProductLineDetailService productLineDetailService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/productline/get-all")
    ResponseEntity<Object> getProductLineAll()
    {
        try {
            List<ProductlineDetailsDTO> list = productLineDetailService.getPLDetailsEs();
            log.info("get all productline ok");
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            log.error("Unexpected Error! (Should not be exist)");
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
    }

    @PostMapping("/productline/insert-productline")
    ResponseEntity<Object> postProuctLine(@RequestBody ProductlineDetailsDTO dto){
        try {
            dto.setId(null);
            Boolean ok = productLineDetailService.newCreatePLD(dto);
            if (ok) return ResponseEntity.ok("Created " + dto );
            else return ResponseEntity.badRequest().body("Can't create new product line " + dto);
        } catch (Exception e) {
            log.error("Can't create new product line " + dto);
            log.error(e);
            return ResponseEntity.badRequest().body("Can't create new product line " + dto.toString());
        }
    }

    @PutMapping("/productline/{id}")
    ResponseEntity<Object> putProuctLine(@RequestBody ProductlineDetailsDTO dto, @PathVariable Long id){
        try {
            if (id == null || id < 1) return ResponseEntity.badRequest().body("Id is not valid");
            dto.setId(id);
            Boolean ok = productLineDetailService.newCreatePLD(dto);
            if (ok == true) {
                log.info("Updated " + dto);
                return ResponseEntity.ok("Updated " + dto.toString() );
            }
            else if (ok == false) return  ResponseEntity.status(404).body("Not found!");
            else return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        } catch (Exception e) {
            log.error("Can't create new product line " + dto.toString());
            log.error(e);
            return ResponseEntity.badRequest().body("Can't create new product line " + dto.toString());
        }
    }

    @GetMapping("/productline/{id}")
    ResponseEntity<Object> getProductLineByID( @PathVariable Long id)
    {
        try {
            if (id == null || id < 1) return ResponseEntity.badRequest().body("Id is not valid");
            ProductlineDetailsDTO dto = productLineDetailService.getPLDByID(id);
            if (dto == null) return ResponseEntity.status(404).build();
            log.info("get productline {} ok", id);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            log.error("Unexpected Error! (Should not be exist)");
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
    }

    @PostMapping("/user/insert")
    ResponseEntity<Object> postUser(@RequestBody UserDTO dto){
        try {
            dto.setId(null);
            Boolean ok = userService.newCreateUser(dto);
            if (ok) return ResponseEntity.ok("Created " + dto );
            else return ResponseEntity.badRequest().body("Can't create new user " + dto);
        } catch (Exception e) {
            log.error("Can't create new user " + dto);
            log.error(e);
            return ResponseEntity.badRequest().body("Can't create new user " + dto.toString());
        }
    }

    @GetMapping("/user/get-user-by-filter")
    ResponseEntity<Object> getUserByFiler(@RequestParam Integer role) {
        try {
            if (role == null) return ResponseEntity.badRequest().body("Role is not valid");
            List<UserDTO> dto = userService.getUserByRole(role);
            log.info("get productline {} ok", dto);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            log.error("Unexpected Error! (Should not be exist)");
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
    }

    @GetMapping("/product/get-product-by-status")
    ResponseEntity<Object> getProductByStatus(){
        try {
            ProductStatusDTO dto = productService.getProductByStatus();
            log.info("getProductByStatus success");
            return ResponseEntity.ok().body(dto);
        } catch (Exception e){
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
        }
    }

//    @GetMapping("/product/get-product-by-productline")
//    ResponseEntity<Object> getProductByProductline(){
//        try {
//            List<> dto = productService.getProductByProductline();
//            log.info("getProductByStatus success");
//            return ResponseEntity.ok().body(dto);
//        } catch (Exception e){
//            log.error(e);
//            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
//        }
//    }


    @GetMapping("/product")
    ResponseEntity<Object> getProducts(){
//        try {
//            SumProductByStatusDTO dto = productService.getProductByStatus();
//            log.info("getProductByStatus success");
//            return ResponseEntity.ok().body(dto);
//        } catch (Exception e){
//            log.error(e);
//            return ResponseEntity.internalServerError().body("Unexpected Error! (Should not be exist)");
//        }
        return null;
    }

    @GetMapping("/product/{id}")
    ResponseEntity<Object> get4_ProductByID(@PathVariable Long id){
        try {
            if (id == null || id < 0) return ResponseEntity.badRequest().body("ID is not valid");
            Product_4_DTO dto = productService.getProduct4(id);
            if (dto == null) return ResponseEntity.badRequest().body("Not found or Error");
            log.info("getProductByStatus success");
            return ResponseEntity.ok().body(dto);
        } catch (Exception e){
            log.error(e);
            return ResponseEntity.internalServerError().body("Unexpected Error!");
        }
    }

}
