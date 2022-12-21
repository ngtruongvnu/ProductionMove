package com.project.productmove.service.impl;

import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.dto.SellProductFilterTime;
import com.project.productmove.entity.CustomerEntity;
import com.project.productmove.entity.OrderForProductEntity;
import com.project.productmove.repo.CustomerRepo;
import com.project.productmove.repo.OrderForProductEntityRepo;
import com.project.productmove.repo.ProductRepo;
import com.project.productmove.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class created at 12/20/2022 16:25:44
 *
 * @author HoàngKhôngNgủ
 */
@Log4j2
@Service
public class ProductServiceImpl implements ProductService {
    @PersistenceContext
    private EntityManager en;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderForProductEntityRepo orderForProductEntityRepo;

    @Override
    public List<SellProductFilterTime> getProductSoldFilterTime(String filter) {
        List<SellProductFilterTime> spftList = new ArrayList<>();
        if(filter.equals("year")) {
            String queryGetProductSoldFilterTime = "SELECT pd.product_name, count(*) as quantity_sell,(SELECT EXTRACT(YEAR FROM ofp.created_date)) AS YEAR \n" +
                    "FROM product_detail pd \n" +
                    "join products pr on pd.id = pr.product_detail\n" +
                    "JOIN order_for_product ofp ON pr.id = ofp.product_id\n" +
                    "group by YEAR;";
            Query query = en.createNativeQuery(queryGetProductSoldFilterTime);
            List<Object[]> result = query.getResultList();

            for (Object[] obj : result) {
                SellProductFilterTime spft = new SellProductFilterTime();
                spft.setProductLineName(String.valueOf(obj[0]));
                spft.setQuantitySell((BigInteger) obj[1]);
                spft.setTime(String.valueOf(obj[2]));
                spftList.add(spft);
            }
        } else if (filter.equals("month")) {
            String queryGetProductSoldFilterTime = "SELECT pd.product_name, count(*) as quantity_sell,(SELECT EXTRACT(YEAR FROM ofp.created_date)) AS YEAR,\n" +
                    "EXTRACT(MONTH FROM ofp.created_date) AS MONTH \n" +
                    "FROM product_detail pd \n" +
                    "join products pr on pd.id = pr.product_detail\n" +
                    "JOIN order_for_product ofp ON pr.id = ofp.product_id\n" +
                    "group by MONTH,YEAR;";
            Query query = en.createNativeQuery(queryGetProductSoldFilterTime);
            List<Object[]> result = query.getResultList();

            for (Object[] obj : result) {
                SellProductFilterTime spft = new SellProductFilterTime();
                spft.setProductLineName(String.valueOf(obj[0]));
                spft.setQuantitySell((BigInteger) obj[1]);
                spft.setTime("T" + String.valueOf(obj[3]) + "-" + String.valueOf(obj[2]));
                spftList.add(spft);
            }
        } else if(filter.equals("quater")){
            String queryGetProductSoldFilterTime = "SELECT pd.product_name, count(*) as quantity_sell,\n" +
                    "QUARTER(ofp.created_date) AS QUATER, (SELECT EXTRACT(YEAR FROM ofp.created_date)) AS YEAR\n" +
                    "FROM product_detail pd \n" +
                    "join products pr on pd.id = pr.product_detail\n" +
                    "JOIN order_for_product ofp ON pr.id = ofp.product_id\n" +
                    "group by QUATER,YEAR;";
            Query query = en.createNativeQuery(queryGetProductSoldFilterTime);
            List<Object[]> result = query.getResultList();

            for (Object[] obj : result) {
                SellProductFilterTime spft = new SellProductFilterTime();
                spft.setProductLineName(String.valueOf(obj[0]));
                spft.setQuantitySell((BigInteger) obj[1]);
                spft.setTime("Q" + String.valueOf(obj[3]) + "-" + String.valueOf(obj[2]));
                spftList.add(spft);
            }
        }
        return spftList;
    }

    @Override
    public void setStatusAndSaveRecordProductSold(OrderForProductDTO orderForProductDTO, int status) {
        productRepo.upDateStatus(status, orderForProductDTO.getProductId());
        OrderForProductEntity orderForProductEntity = modelMapper.map(orderForProductDTO, OrderForProductEntity.class);
        LocalDateTime current = LocalDateTime.now();
        Instant instant = current.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        orderForProductEntity.setCreatedDate(date);
        orderForProductEntityRepo.save(orderForProductEntity);
    }
}
