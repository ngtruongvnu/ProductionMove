package com.project.productmove.repo;

import com.project.productmove.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {


    @Modifying
    @Query("DELETE FROM CustomerEntity WHERE id=?1")
    void deleteById(long id);

}
