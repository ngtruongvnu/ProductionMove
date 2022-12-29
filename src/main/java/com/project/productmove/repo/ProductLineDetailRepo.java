package com.project.productmove.repo;

import com.project.productmove.entity.ProductlineDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLineDetailRepo extends JpaRepository<ProductlineDetailsEntity, Integer> {
}
