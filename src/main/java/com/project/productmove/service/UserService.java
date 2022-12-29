package com.project.productmove.service;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<UserDTO> getAll();

    String getUser();

    void customerReceiveWarrantyProduct(int status, long productId);

    List<Long> getListProductIdByPrDetail(long productDetailId);

    Boolean newCreateUser(UserDTO userDTO);

    List<UserDTO> getUserByRole(Integer role);
    List<UserDTO> getAllUserByRole();

}
