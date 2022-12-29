package com.project.productmove.repo;

import com.project.productmove.entity.UserEntity;

import java.util.List;

public interface UserRepoCustom {

    List<UserEntity> findAllById(long id);


}
