package com.project.productmove.repo;

import com.project.productmove.entity.ProductsEntity;
import com.project.productmove.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductsEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE ProductsEntity pr SET pr.status = ?1 WHERE pr.id = ?2")
    void upDateStatus(int status, long productId);

    @Query(value = "SELECT p.status, COUNT(*) FROM products p GROUP BY p.STATUS ORDER BY status;", nativeQuery = true)
    List<Integer[]> getProductsByStatus();

    @Query(value = "SELECT u.first_name, u.last_name FROM products p  JOIN order_for_product o ON p.id = o.product_id JOIN USER u ON o.sell_by = u.id  WHERE p.id = :id", nativeQuery = true)
    List<String[]> getSellBy(@Param("id") Long id);

    @Query(value = "SELECT u.firstname, u.lastname FROM products p  \n" +
            "JOIN order_for_product o ON p.id = o.product_id \n" +
            "JOIN customer u ON o.customer_id = u.id \n" +
            "WHERE p.id = ?1", nativeQuery = true)
    List<String[]> getCustomer(Long id);

    List<ProductsEntity> getAllByPlaceAndStatus(Long user_id, Integer status);

    @Query(value = "SELECT  COUNT(*), e.description FROM products p JOIN errors e ON p.id = e.product_id WHERE p.product_detail_id =?1 GROUP BY e.`type`", nativeQuery = true)
    List<Object[]> getProductErrorByProductline(Long user_id);

    List<ProductsEntity> getAllByProductBatchId(Long productbatch_id);

    @Query(value = "SELECT COUNT(*), p.product_batch_id FROM products p WHERE p.user_id = ?1 AND p.product_detail_id = ?2 \n" +
            "GROUP BY p.product_batch_id\n" +
            "ORDER BY p.product_batch_id", nativeQuery = true)
    List<Object[]> countAllByUserAndProductline(Long user_id, Long productline_id);

    @Query(value = "SELECT COUNT(*), p.product_batch_id  FROM products p WHERE p.`status` >=3 AND p.status <=9  and p.user_id = ?1 AND p.product_detail_id = ?2 GROUP BY p.product_batch_id ORDER BY p.product_batch_id", nativeQuery = true)
    List<Object[]> countErrorByUserAndProductline(Long user_id, Long productline_id);

    List<ProductsEntity> getAllByStatusAndUserId(Integer status, Long user_id);

    @Query(value = "SELECT  u.user_name , COUNT(1) FROM products p \n" +
            "JOIN user u ON p.user_id = u.id\n" +
            "WHERE p.`status` <=9 AND p.status >=2 GROUP BY p.user_id", nativeQuery = true)
    List<Object[]> getSumProducByAgent();
}
