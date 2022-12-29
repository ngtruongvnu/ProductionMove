package com.project.productmove.service.impl;

import com.project.productmove.dto.UserDTO;
import com.project.productmove.dto.UserLoginDTO;
import com.project.productmove.dto.WarehouseDTO;
import com.project.productmove.entity.UserEntity;
import com.project.productmove.entity.WarehouseEntity;
import com.project.productmove.repo.UserRepo;
import com.project.productmove.repo.WarehouseRepo;
import com.project.productmove.service.GeneralService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    WarehouseRepo warehouseRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public List<WarehouseDTO> filterWarehousebyUser(long user_id) {
        List<WarehouseEntity> listE = warehouseRepo.listWarehouseFilterByUser(user_id);
        List<WarehouseDTO> ListD = listE.stream().map(WarehouseEntity -> modelMapper.map(WarehouseEntity,
                        WarehouseDTO.class))
                .collect(Collectors.toList());
        return ListD;
    }

    @Override
    public void addWarehouse(WarehouseDTO warehouseDTO) {
        WarehouseEntity warehouseEntity = modelMapper.map(warehouseDTO, WarehouseEntity.class);
        warehouseRepo.save(warehouseEntity);
    }

    @Override
    public UserLoginDTO getUserLoginDTO(UserDTO userDTO) {
        log.info(userDTO.getUserName()+ "   " +userDTO.getPassword());
        UserEntity userEntity = userRepo.getUserEntityLogin(userDTO.getUserName(),userDTO.getPassword());
        UserLoginDTO userLoginDTO = modelMapper.map(userEntity, UserLoginDTO.class);
        return userLoginDTO;
    }

    @Override
    public Boolean checkUserExistById(long userId) {
        UserEntity userEntity = userRepo.getUserById(userId);
        if(userEntity == null) return false;

        return true;
    }

    @Override
    public Boolean checkUserExistByUserName(String userName) {
        UserEntity userEntity = userRepo.getUserByUserName(userName);
        if(userEntity == null) return false;
        return true;
    }


}
