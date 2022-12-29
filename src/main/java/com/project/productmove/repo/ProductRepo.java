package com.project.productmove.repo;

import com.project.productmove.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepo extends JpaRepository<ProductsEntity, Long>, ProductRepoCustom {
    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.status = ?1 WHERE pr.id = ?2")
    void upDateStatus(int status, long productId);

    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.userId = ?1 WHERE pr.id = ?2")
    void upDateUserId(long agentId, long productId);

    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.place = ?1 WHERE pr.id = ?2")
    void updateWarehouseAfterReceiveFromSV(long place, long productId);

    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.place = ?1, pr.userId = ?2 WHERE pr.id = ?3")
    void upDateWarehouseAndUser(long warehouseId, long userId, long productId);

    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.status = 9 WHERE pr.productBatchId = ?1")
    void upStatusRecallByBatch(long productBatchId);

}
