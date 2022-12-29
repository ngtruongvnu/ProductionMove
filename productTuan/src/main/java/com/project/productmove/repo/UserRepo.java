package com.project.productmove.repo;

import com.project.productmove.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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



    @Query(value = "select * from user where id = 0",nativeQuery = true)
    List<UserEntity> getAll();
    List<UserEntity> findAllById(long id);

    List<UserEntity> findUserEntitiesByRole(Integer role);

}
