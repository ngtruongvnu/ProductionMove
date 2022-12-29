package com.project.productmove.controller;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.UserDTO;
import com.project.productmove.service.CustomerService;
import com.project.productmove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * This class created at 12/5/2022 18:02:05
 *
 * @author HoàngKhôngNgủ
 */
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

//    @GetMapping("/findAll")
//    List<CustomerDTO> findAll(){
//        return customerService.findAll();
//    }

    @GetMapping("/findAll")
    ResponseEntity<Object> customer(){
        List<CustomerDTO> listC = customerService.findAll();
        return new ResponseEntity<Object>("success", HttpStatus.NOT_FOUND);
    }


        @GetMapping("/info")
        public ResponseEntity<CustomerDTO> getUserInfo(@RequestParam("username") String username) {
            // Tìm User trong database bằng username
            CustomerDTO user = new CustomerDTO();

            // Nếu không tìm thấy, trả về message lỗi 404 Not found
            if (user == null)
                return (ResponseEntity<CustomerDTO>) ResponseEntity.notFound();  // Tạm thời là vậy, thực tế người ta dùng AOP để bắt exception

            // Nếu tìm thấy return 200 OK
            return ResponseEntity.ok(user);
        }


    @GetMapping("/getAll")
    List<UserDTO> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getUserName")
    String getUserName(){
        return userService.getUser();
    }

    @PostMapping(value = "/customerInfo",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getCustomerInfo(@RequestBody CustomerDTO customerDTO) throws ParseException {

         LocalDateTime current = LocalDateTime.now();
         System.out.println("time : "+ current);
         Instant instant = current.atZone(ZoneId.systemDefault()).toInstant();
         Date date = Date.from(instant);
         System.out.println(date);
         customerDTO.setCreatedDate((Timestamp) date);
         customerService.addCustomer(customerDTO);
         return new ResponseEntity<Object>("success", HttpStatus.OK);
    }

    @DeleteMapping(value = "/customerDelete",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> deleteCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.deleteCustomer(customerDTO);
        return new ResponseEntity<Object>("success", HttpStatus.OK);
    }
}
