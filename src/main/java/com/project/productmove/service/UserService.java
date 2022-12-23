package com.project.productmove.service;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.UserDTO;
import com.project.productmove.dto.UserLoginDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<UserDTO> getAll();

    String getUser();

    void customerReceiveWarrantyProduct(int status, long productId);

    List<Long> getListProductIdByPrDetail(long productDetailId);

    List<UserDTO> filterByRole(int role);


}
