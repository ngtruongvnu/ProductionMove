package com.project.productmove.repo;

import com.project.productmove.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepo extends JpaRepository<WarehouseEntity, Integer> {

    @Query("SELECT wh FROM WarehouseEntity wh WHERE wh.userId = ?1")
    List<WarehouseEntity> listWarehouseFilterByUser(long userId);
}
