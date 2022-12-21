package com.project.productmove.repo;

import com.project.productmove.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineDetailRepo extends JpaRepository<ProductDetailEntity, Integer> {
}
