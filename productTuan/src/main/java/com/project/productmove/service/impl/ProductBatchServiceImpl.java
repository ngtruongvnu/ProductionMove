package com.project.productmove.service.impl;

import com.project.productmove.dto.ProductBatchesDTO;
import com.project.productmove.entity.ProductBatchesEntity;
import com.project.productmove.repo.ProductBatchRepo;
import com.project.productmove.service.ProductBatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class was created at 12/28/2022 15:15:43
 *
 * @author Minh.LN
 */
@Service
public class ProductBatchServiceImpl implements ProductBatchService {

    @Autowired
    ProductBatchRepo productBatchRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductBatchesDTO> getProductBatche(Long idUser) {
        List<ProductBatchesEntity> entityList = productBatchRepo.findByProducedAt(idUser);
        List<ProductBatchesDTO> dtos = entityList.stream()
                .map(x -> modelMapper.map(x, ProductBatchesDTO.class)).collect(Collectors.toList());
        return dtos;
    }
}
