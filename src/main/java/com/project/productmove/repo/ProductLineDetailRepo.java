package com.project.productmove.repo;

import com.project.productmove.entity.ProductlineDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductLineDetailRepo extends JpaRepository<ProductlineDetailsEntity, Long> {

    @Query(value = "SELECT * from productline_details pd  WHERE pd.id IN (SELECT p.productline_detail_id  FROM product_batches p WHERE p.id = 1) LIMIT 1", nativeQuery = true)
    ProductlineDetailsEntity findPDLByID(Long id );
}
