package com.project.productmove.repo;

import com.project.productmove.entity.ErrorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorsRepo extends JpaRepository<ErrorsEntity, Integer>, ErrorRepoCustom{

}
