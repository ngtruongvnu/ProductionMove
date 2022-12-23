package com.project.productmove.service.impl;

import com.project.productmove.entity.ProductDetailEntity;
import com.project.productmove.repo.ProductLineDetailRepo;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.service.ProductLineDetailService;
import com.project.productmove.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * This class created at 12/21/2022 20:50:33
 *
 * @author HoàngKhôngNgủ
 */
@Service
public class ProductLineDetailServiceImpl implements ProductLineDetailService {

    @PersistenceContext
    private EntityManager en;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductLineDetailRepo productLineDetailRepo;


    @Override
    public String checkProductWarranty(long productLine) {
        Boolean check = productLineDetailRepo.existsById((int)productLine);
        if(check = false) return "ProductLine không tồn tại";
        return "true";
    }
}
