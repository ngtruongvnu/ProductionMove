package com.project.productmove.service;

import com.project.productmove.dto.ProductBatchesDTO;

import java.util.List;

/**
 * This class was created at 12/28/2022 15:11:28
 *
 * @author Minh.LN
 */

public interface ProductBatchService {
    List<ProductBatchesDTO> getProductBatche(Long idUser);

}
