package com.project.productmove.repo;

import com.project.productmove.entity.CustomerEntity;
import com.project.productmove.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select * from user where id = 0",nativeQuery = true)
    List<UserEntity> getAll();



    List<UserEntity> findAllById(long id);
}
