package com.project.productmove.service.impl;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.dto.RecallByBatchDTO;
import com.project.productmove.dto.UserDTO;
import com.project.productmove.entity.*;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.repo.UserRepo;
import com.project.productmove.service.OrderForProductRepo;
import com.project.productmove.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class created at 12/6/2022 12:22:02
 *
 * @author HoàngKhôngNgủ
 */

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    EntityManager em;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderForProductRepo orderForProductRepo;
    @Override
    public List<UserDTO> getAll(){
        List<UserEntity> listE = userRepo.findAllById(1);
        List<UserDTO> ListD = listE.stream().map(UserEntity -> modelMapper.map(UserEntity,
                        UserDTO.class))
                .collect(Collectors.toList());
        return ListD;
    }

    @Override
    public String getUser() {
        String spl = "Select u.name,u.user_name from user u join" +
                " warehouse wa on u.id = wa.user_id";
        Query queryCustomer = em.createNativeQuery(spl);
        List<Object[]> result = queryCustomer.getResultList();

        String name="",username="";
        for(Object[] object : result){
          name = String.valueOf(object[0]);
          username = String.valueOf(object[1]);
        }
        return name + username;
    }

    @Override
    public void customerReceiveWarrantyProduct(int status, long productId) {
         productRepo.upDateStatus(status, productId);
    }

    @Override
    public List<Long> getListProductIdByPrDetail(long productDetailId) {
        String spl = "Select pr.id from products pr join" +
                " product_detail pd on pr.product_detail_id = pd.id where pr.product_detail_id = " + productDetailId;
        Query queryProductList = em.createNativeQuery(spl);
        List<Object> result = queryProductList.getResultList();
        List<Long> listProductId = new ArrayList<>();
        long productId;
        for(Object object : result){
            productId = Long.parseLong(String.valueOf(object));
            listProductId.add(productId);
        }
        return listProductId;
    }

    @Override
    public List<UserDTO> filterByRole(int role) {
        List<UserEntity> listE = userRepo.listUserEntityByRole(role);
        List<UserDTO> ListD = listE.stream().map(UserEntity -> modelMapper.map(UserEntity,
                        UserDTO.class))
                .collect(Collectors.toList());
        return ListD;
    }

    @Override
    public void UpdateWarehouseAfterReceiveFromSC(long warehouseId, long productId) {
        productRepo.updateWarehouseAfterReceiveFromSV(warehouseId,productId);
    }

    @Override
    public void recallByBatch(RecallByBatchDTO recallByBatchDTO) {
        productRepo.upStatusRecallByBatch(recallByBatchDTO.getBatch_id());
    }

}
