package com.project.productmove.service.impl;

import com.project.productmove.dto.CustomerDTO;
import com.project.productmove.dto.UserDTO;
import com.project.productmove.entity.CustomerEntity;
import com.project.productmove.entity.UserEntity;
import com.project.productmove.repo.CustomerRepo;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.repo.UserRepo;
import com.project.productmove.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class created at 12/6/2022 12:22:02
 *
 * @author HoàngKhôngNgủ
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger log = LogManager.getLogger();

    @PersistenceContext
    EntityManager em;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;

    @Autowired
    ModelMapper mapper;

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
                " product_detail pd on pr.product_detail = pd.id where pr.product_detail = " + productDetailId;
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
    public Boolean newCreateUser(UserDTO userDTO) {
        try {
            UserEntity entity = mapper.map(userDTO, UserEntity.class);
            UserEntity savedEntity = userRepo.save(entity);
            log.info("Created " + savedEntity);
            return true;
        } catch (Exception e) {
            log.error(e);
            log.error("Can't create new user " + userDTO.toString());
            return false;
        }
    }

    @Override
    public List<UserDTO> getUserByRole(Integer role) {
        try {
            List<UserEntity> entityList = userRepo.findUserEntitiesByRole(role);
            List<UserDTO> userDTOS = entityList.stream()
                    .map(x -> modelMapper.map(x, UserDTO.class))
                    .collect(Collectors.toList());
            return userDTOS;
        } catch (Exception e) {
            log.error(e);
            log.error("Error in getUserByRole " + role);
            return null;
        }
    }
}
