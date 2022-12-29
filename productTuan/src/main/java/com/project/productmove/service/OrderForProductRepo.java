package com.project.productmove.service;

import com.project.productmove.entity.OrderForProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderForProductRepo extends JpaRepository<OrderForProductEntity, Long> {
}
