package com.project.productmove.service.impl;

import com.project.productmove.dto.ProductBatchesAndProduclineDTO;
import com.project.productmove.dto.ProductBatchesDTO;
import com.project.productmove.dto.ProductlineDetailsDTO;
import com.project.productmove.entity.ProductBatchesEntity;
import com.project.productmove.entity.ProductlineDetailsEntity;
import com.project.productmove.repo.ProductBatchRepo;
import com.project.productmove.repo.ProductLineDetailRepo;
import com.project.productmove.service.ProductBatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    ProductLineDetailRepo productLineDetailRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductBatchesAndProduclineDTO> getProductBatche(Long idUser) {
        List<ProductBatchesEntity> entityList = productBatchRepo.findByProducedAt(idUser);
        List<ProductBatchesDTO> dtos = entityList.stream()
                .map(x -> modelMapper.map(x, ProductBatchesDTO.class)).collect(Collectors.toList());
        List<ProductBatchesAndProduclineDTO> list = new ArrayList<>();
        for (ProductBatchesDTO d : dtos){
            ProductBatchesAndProduclineDTO rt = new ProductBatchesAndProduclineDTO();
            rt.setProductBatch(d);
            ProductlineDetailsEntity productlineDetailsEntity = productLineDetailRepo.findPDLByID(d.getId());
            rt.setProductlineDetail(modelMapper.map(productlineDetailsEntity, ProductlineDetailsDTO.class));
            list.add(rt);
        }
        return list;
    }
}
