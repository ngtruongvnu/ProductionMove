package com.project.productmove.repo;

import com.project.productmove.entity.CustomerEntity;
import com.project.productmove.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>,UserRepoCustom{

    @Query("SELECT u FROM UserEntity u WHERE u.id = ?1")
    UserEntity getUserById(long id);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1")
    UserEntity getUserByUserName(String userName);

    @Query("SELECT u FROM UserEntity u WHERE u.role = ?1")
    List<UserEntity> listUserEntityByRole(int role);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.password = ?2")
    UserEntity getUserEntityLogin(String userName, String password);



}
