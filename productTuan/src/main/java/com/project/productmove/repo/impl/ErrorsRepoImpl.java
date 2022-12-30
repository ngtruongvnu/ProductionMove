package com.project.productmove.repo.impl;

import com.project.productmove.repo.ErrorRepoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ErrorsRepoImpl implements ErrorRepoCustom {

    @PersistenceContext
    private EntityManager en;

    @Override
    public List<Object[]> listProductLineError() {
        String queryGetListProductLineError = "SELECT pd.name, pr.product_detail_id, er.description, COUNT(*) AS dem1 FROM errors er\n" +
                "JOIN products pr ON pr.id = er.product_id\n" +
                "JOIN productline_details pd ON pr.product_detail_id = pd.id\n" +
                "GROUP BY pr.product_detail_id,er.description;";
        Query query = en.createNativeQuery(queryGetListProductLineError);
        List<Object[]> result = query.getResultList();
        return result;
    }

    @Override
    public List<Object[]> getErrorProductByWarehouse(long warehouseId) {
        String queryGetErrorProductByWarehouse = "SELECT pd.name,er.product_id,er.description FROM errors er \n" +
                "JOIN products pr ON pr.id = er.product_id\n" +
                "JOIN productline_details pd ON pr.product_detail_id = pd.id WHERE pr.place = "+warehouseId;
        Query query = en.createNativeQuery(queryGetErrorProductByWarehouse);
        List<Object[]> result = query.getResultList();
        return result;
    }

    @Override
    public List<Object[]> getErrorProductToFilter() {
        String queryGetErrorProductToFilter = "SELECT pd.name,er.product_id,er.description FROM errors er \n" +
                "JOIN products pr ON pr.id = er.product_id\n" +
                "JOIN productline_details pd ON pr.product_detail_id = pd.id;";
        Query query = en.createNativeQuery(queryGetErrorProductToFilter);
        List<Object[]> result = query.getResultList();
        return result;
    }


}
