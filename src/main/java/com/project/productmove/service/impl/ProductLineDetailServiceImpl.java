package com.project.productmove.service.impl;

import com.project.productmove.dto.ProductlineDetailsDTO;
import com.project.productmove.dto.UserDTO;
import com.project.productmove.entity.ProductlineDetailsEntity;
import com.project.productmove.entity.UserEntity;
import com.project.productmove.repo.ProductLineDetailRepo;
import com.project.productmove.repo.UserRepo;
import com.project.productmove.service.ProductLineDetailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class created at 12/21/2022 20:50:33
 *
 * @author HoàngKhôngNgủ
 */
@Service
public class ProductLineDetailServiceImpl implements ProductLineDetailService {
    @Autowired
    ProductLineDetailRepo pLDetailRepo;

    @Autowired
    UserRepo userRepo;

    private static Logger log = LogManager.getLogger();

    @Autowired
    ModelMapper mapper;

    @Override
    public String checkProductWarranty(long productLine) {
        Boolean check = pLDetailRepo.existsById(productLine);
        if (check = false) return "ProductLine không tồn tại";
        return null;
    }

    @Override
    public List<ProductlineDetailsDTO> getPLDetailsEs() {
        List<ProductlineDetailsEntity> entityList = pLDetailRepo.findAll();
        List<ProductlineDetailsDTO> dtoList = entityList.stream().map(
                x -> mapper.map(x, ProductlineDetailsDTO.class)
        ).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public Boolean newCreatePLD(ProductlineDetailsDTO dto) {
        try {
            ProductlineDetailsEntity entity = mapper.map(dto, ProductlineDetailsEntity.class);
            ProductlineDetailsEntity savedEntity = pLDetailRepo.save(entity);
            log.info("Created " + savedEntity);
            return true;
        } catch (Exception e) {
            log.error(e);
            log.error("Can't create new PLD " + dto.toString());
            return false;
        }
    }

    @Override
    public Boolean updatePLD(ProductlineDetailsDTO dto) {
        try {
            Boolean isExist = pLDetailRepo.existsById((long) Math.toIntExact(dto.getId()));
            if (!isExist) return false;

            ProductlineDetailsEntity entityNew = mapper.map(dto, ProductlineDetailsEntity.class);
            pLDetailRepo.save(entityNew);
            return true;
        } catch (Exception e) {
            log.error(e);
            log.error("ERROR with update productline detail" + dto);
            return null;
        }

    }

    @Override
    public ProductlineDetailsDTO getPLDByID(Long id) {
        try {
            ProductlineDetailsEntity entity = pLDetailRepo.findById(id).orElse(null);
            if (entity == null) return null;
            ProductlineDetailsDTO dto = mapper.map(entity, ProductlineDetailsDTO.class);
            return dto;
        } catch (Exception e) {
            log.error(e);
            log.error("ERROR with getPLDByID productline detail" + id);
            return null;
        }
    }



}
