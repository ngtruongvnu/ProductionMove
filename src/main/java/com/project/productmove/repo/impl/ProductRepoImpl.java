package com.project.productmove.repo.impl;

import com.project.productmove.repo.ErrorsRepo;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.repo.ProductRepoCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ProductRepoImpl implements ProductRepoCustom {
    @PersistenceContext
    private EntityManager en;


    @Override
    public List<Object[]> listProductLineCount() {
        String queryGetListProductLineCount = "SELECT pr.product_detail_id,COUNT(*) AS dem FROM products pr\n" +
                "GROUP BY pr.product_detail_id;";
        Query query = en.createNativeQuery(queryGetListProductLineCount);
        List<Object[]> result = query.getResultList();
        return result;
    }
}
