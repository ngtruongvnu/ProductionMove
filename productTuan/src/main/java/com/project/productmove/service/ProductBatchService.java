package com.project.productmove.service;

import com.project.productmove.dto.ProductBatchesAndProduclineDTO;

import java.util.List;

/**
 * This class was created at 12/28/2022 15:11:28
 *
 * @author Tuan Vu
 */

public interface ProductBatchService {
    List<ProductBatchesAndProduclineDTO> getProductBatche(Long idUser);

}
