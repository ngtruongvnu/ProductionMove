package com.project.productmove.repo;

import com.project.productmove.entity.OrderForProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class created at 12/20/2022 22:54:10
 *
 * @author HoàngKhôngNgủ
 */
@Repository
public interface OrderForProductEntityRepo extends JpaRepository<OrderForProductEntity,Integer> {
}
