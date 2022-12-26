package com.project.productmove.repo;

import com.project.productmove.entity.ProductBatchesEntity;
import com.project.productmove.entity.ProductlineDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This class was created at 12/27/2022 01:51:05
 *
 * @author Minh.LN
 */

public interface ProductBatchRepo extends JpaRepository<ProductBatchesEntity, Long> {


}
