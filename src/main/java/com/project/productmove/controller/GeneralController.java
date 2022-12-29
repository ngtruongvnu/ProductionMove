package com.project.productmove.controller;

import com.project.productmove.dto.UserDTO;
import com.project.productmove.dto.UserLoginDTO;
import com.project.productmove.dto.WarehouseDTO;
import com.project.productmove.service.GeneralService;
import com.project.productmove.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class created at 12/20/2022 14:52:14
 *
 * @author HoàngKhôngNgủ
 */

@RestController
@RequestMapping("api/v1/")
@Log4j2
public class GeneralController {

    @Autowired
    UserService userService;

    @Autowired
    GeneralService generalService;

    @GetMapping("user/get-users-by-filter")
    ResponseEntity<Object> getUserByFilter(@RequestParam("user_id") String userId,
                                          @RequestParam("role") int role) {
        List<UserDTO> userDTOlist;
        if(role==0 || role==1 || role==2 || role==3) {
            try {
                userDTOlist = userService.filterByRole(role);
            } catch (Exception e){
                return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else{
            return new ResponseEntity<Object>("Lỗi : role không tồn tại", HttpStatus.NOT_FOUND);
        }
        if(userDTOlist.isEmpty()) {
            return new ResponseEntity<Object>("Lỗi : chưa có user với role " + role, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userDTOlist);
    }

    @GetMapping("warehouse/get-all")
    ResponseEntity<Object> getWarehouseByUser(@RequestParam("user_id") long userId) {
        List<WarehouseDTO> warehouseDTOList;
        try {
            warehouseDTOList = generalService.filterWarehousebyUser(userId);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(warehouseDTOList.isEmpty()) return new ResponseEntity<Object>("Lỗi : user_id không tồn tại", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(warehouseDTOList);
    }

    @PostMapping("warehouse/insert-warehouse")
    ResponseEntity<Object> addWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
        if(generalService.checkUserExistById(warehouseDTO.getUserId())) {
            generalService.addWarehouse(warehouseDTO);
        } else {
            return new ResponseEntity<Object>("Lỗi : user_id không tồn tại", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Thành công");
    }

    @PostMapping("user/login")
    ResponseEntity<Object> login(@RequestBody UserDTO userDTO) {
        UserLoginDTO userLoginDTO = null;
        if(generalService.checkUserExistByUserName(userDTO.getUserName())) {
            try {
                userLoginDTO = generalService.getUserLoginDTO(userDTO);

            } catch (Exception e) {
                if (userLoginDTO == null) {
                    return new ResponseEntity<Object>("Lỗi : sai password", HttpStatus.NOT_ACCEPTABLE);
                }
                return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<Object>("Lỗi : sai user_name", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(userLoginDTO);
    }


}
