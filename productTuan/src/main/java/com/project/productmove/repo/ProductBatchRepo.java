package com.project.productmove.repo;

import com.project.productmove.entity.ProductBatchesEntity;
import com.project.productmove.entity.ProductlineDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This class was created at 12/27/2022 01:51:05
 *
 * @author Tuan Vu
 */

public interface ProductBatchRepo extends JpaRepository<ProductBatchesEntity, Long> {

    List<ProductBatchesEntity> findByProducedAt(Long idUser);


}
