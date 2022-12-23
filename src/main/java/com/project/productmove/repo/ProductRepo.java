package com.project.productmove.repo;

import com.project.productmove.entity.ProductsEntity;
import com.project.productmove.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepo extends JpaRepository<ProductsEntity, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.status = ?1 WHERE pr.id = ?2")
    void upDateStatus(int status, long productId);

    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.userId = ?1 WHERE pr.id = ?2")
    void upDateUserId(long agentId, long productId);

}
