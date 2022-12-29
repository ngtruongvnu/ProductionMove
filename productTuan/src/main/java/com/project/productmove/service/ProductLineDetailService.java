package com.project.productmove.service;


import com.project.productmove.dto.ProductlineDetailsDTO;
import com.project.productmove.dto.UserDTO;
import com.project.productmove.entity.ProductlineDetailsEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductLineDetailService {

    String checkProductWarranty(long productLine);

    List<ProductlineDetailsDTO> getPLDetailsEs();

    Boolean newCreatePLD(ProductlineDetailsDTO dto);

    Boolean updatePLD(ProductlineDetailsDTO dto);

    ProductlineDetailsDTO getPLDByID(Long id);


}
