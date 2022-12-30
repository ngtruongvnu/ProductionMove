package com.project.productmove.repo;

import com.project.productmove.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductsEntity, Long>,ProductRepoCustom {
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

    @Query(value = "SELECT p.status, COUNT(*) FROM products p GROUP BY p.STATUS ORDER BY status;", nativeQuery = true)
    List<Integer[]> getProductsByStatus();

    @Query(value = "SELECT u.first_name, u.last_name FROM products p  JOIN order_for_product o ON p.id = o.product_id JOIN USER u ON o.sell_by = u.id  WHERE p.id = :id", nativeQuery = true)
    List<String[]> getSellBy(@Param("id") Long id);

    @Query(value = "SELECT u.firstname, u.lastname FROM products p  \n" +
            "JOIN order_for_product o ON p.id = o.product_id \n" +
            "JOIN customer u ON o.customer_id = u.id \n" +
            "WHERE p.id = ?1", nativeQuery = true)
    List<String[]> getCustomer(Long id);

    @Query(value = "SELECT pr.product_batch_id FROM products pr WHERE pr.id =?", nativeQuery = true)
    Long productBatchId(Long productId);


}
