package com.project.productmove.repo.impl;

import com.project.productmove.entity.UserEntity;
import com.project.productmove.repo.UserRepo;
import com.project.productmove.repo.UserRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRepoImpl implements UserRepoCustom {



    @Override
    public List<UserEntity> findAllById(long id) {
        return null;
    }



}
