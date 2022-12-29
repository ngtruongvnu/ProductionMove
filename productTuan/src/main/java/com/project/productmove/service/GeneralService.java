package com.project.productmove.service;

import com.project.productmove.dto.UserDTO;
import com.project.productmove.dto.UserLoginDTO;
import com.project.productmove.dto.WarehouseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GeneralService {

    List<WarehouseDTO> filterWarehousebyUser(long user_id);

    void addWarehouse(WarehouseDTO warehouseDTO);

    UserLoginDTO getUserLoginDTO(UserDTO userDTO);

    Boolean checkUserExistById(long userId);
    Boolean checkUserExistByUserName(String userName);
}
