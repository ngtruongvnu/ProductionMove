package com.project.productmove.service.impl;


import com.project.productmove.dto.OrderForProductDTO;
import com.project.productmove.dto.SellProductFilterTime;
import com.project.productmove.entity.OrderForProductEntity;
import com.project.productmove.dto.*;
import com.project.productmove.entity.ProductBatchesEntity;
import com.project.productmove.entity.ProductlineDetailsEntity;
import com.project.productmove.entity.ProductsEntity;
import com.project.productmove.repo.OrderForProductEntityRepo;
import com.project.productmove.repo.ProductBatchRepo;
import com.project.productmove.repo.ProductLineDetailRepo;
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
import java.sql.Timestamp;
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
    ProductLineDetailRepo productLineDetailRepo;

    @Autowired
    OrderForProductEntityRepo orderForProductEntityRepo;

    @Autowired
    ProductBatchRepo productBatchRepo;

    @Override
    public List<SellProductFilterTime> getProductSoldFilterTime(String filter) {
        List<SellProductFilterTime> spftList = new ArrayList<>();
        if(filter.equals("year")) {
            String queryGetProductSoldFilterTime = "SELECT pd.name, count(*) as quantity_sell,(SELECT EXTRACT(YEAR FROM ofp.created_date)) AS YEAR \n" +
                    "FROM productline_details pd \n" +
                    "join products pr on pd.id = pr.product_detail_id\n" +
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
            String queryGetProductSoldFilterTime = "SELECT pd.name, count(*) as quantity_sell,(SELECT EXTRACT(YEAR FROM ofp.created_date)) AS YEAR,\n" +
                    "EXTRACT(MONTH FROM ofp.created_date) AS MONTH \n" +
                    "FROM productline_details pd \n" +
                    "join products pr on pd.id = pr.product_detail_id\n" +
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
            String queryGetProductSoldFilterTime = "SELECT pd.name, count(*) as quantity_sell,\n" +
                    "QUARTER(ofp.created_date) AS QUATER, (SELECT EXTRACT(YEAR FROM ofp.created_date)) AS YEAR\n" +
                    "FROM productline_details pd \n" +
                    "join products pr on pd.id = pr.product_detail_id\n" +
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
        orderForProductEntity.setCreatedDate((Timestamp) date);
        orderForProductEntityRepo.save(orderForProductEntity);
    }

    @Override
    public ProductStatusDTO getProductByStatus() {
        List<Integer[]> integers =   productRepo.getProductsByStatus();
        int t = 0;
        Integer kind = null;
        ProductStatusDTO dto = new ProductStatusDTO();
        for (Integer[] i2: integers) {
            if (i2.length != 2) {
                log.error("Not enough param return from dtb!Please report this!");
                continue;
            }
            kind = i2[0];
            Integer i = i2[1];

            switch (kind){
                case 0:
                    dto.setMoi_san_xuat(i);
                    break;
                case 1:
                    dto.setDua_ve_dai_ly(i);
                    break;
                case 2:
                    dto.setDa_ban(i);
                    break;
                case 3:
                    dto.setLoi_can_bao_hanh(i);
                    break;
                case 4:
                    dto.setDang_sua_chua_bao_hanh(i);
                    break;
                case 5:
                    dto.setDa_bao_hanh_xong(i);
                    break;
                case 6:
                    dto.setDa_tra_lai_bao_hanh_cho_khach_hang(i);
                    break;
                case 7:
                    dto.setLoi_can_tra_ve_nha_may(i);
                    break;
                case 8:
                    dto.setLoi_can_tra_ve_nha_may(i);
                    break;
                case 9:
                    dto.setLoi_can_trieu_hoi(i);
                    break;
                case 10:
                    dto.setHet_thoi_gian_bao_hanh(i);
                    break;
                case 11:
                    dto.setTra_lai_co_so_san_xuat(i);
                    break;
                default:
                    log.warn("Unknown status exist!" + "kind = " + kind+" "+i);
            }
        }
        return dto;
    }

    @Override
    public Product_4_DTO getProduct4(Long id) {
        try{
            log.info("start getProduct4");
            ProductsEntity productsEntity = productRepo.findById(id).orElse(null);
            if (productsEntity == null ) return null;
            ProductsDTO productsDTO = modelMapper.map(productsEntity, ProductsDTO.class);
            log.info(productsDTO.toString());

            ProductlineDetailsEntity productlineDetailsEntity =
                    productLineDetailRepo.findById(productsEntity.getProductDetailId()).orElse(null);
            ProductlineDetailsDTO plDetail = modelMapper.map(productlineDetailsEntity, ProductlineDetailsDTO.class);
            log.info(plDetail.toString());

            ProductBatchesEntity productBatchesEntity =
                    productBatchRepo.findById(productsEntity.getProductBatchId()).orElse(null);
            ProductBatchesDTO productBatch = modelMapper.map(productBatchesEntity, ProductBatchesDTO.class);
            log.info(productBatch.toString());

            List<String[]> sellByArray = productRepo.getSellBy(id);
            String sellBy = null;
            if (!sellByArray.isEmpty())
            for (String s: sellByArray.get(0)) {
                if (sellBy != null) sellBy = sellBy + " " + s;
                else sellBy = s;
            }
            log.info(sellBy);

            List<String[]> customerList = productRepo.getCustomer(id);
            String customer = null;
            if (!customerList.isEmpty())
            for (String s: customerList.get(0)) {
               if (customer != null) customer = customer + " "+ s;
               else customer = s;
            }
            log.info(customer);

            Product_4_DTO product4Dto = new Product_4_DTO(productsDTO, plDetail, productBatch, sellBy, customer);
            log.info("end getProduct4 ");
            return product4Dto;

        } catch (Exception e){
            log.error("Error in getProduct4 " + id );
            log.error(e.toString());
            return null;
        }

    }

    @Override
    public Integer sendToAgent(Long user_id, Long agentID, List<Long> listId) {
        Integer siz = 0;
        List<ProductsEntity> entityList = productRepo.findAllById(listId);
        for (ProductsEntity entity : entityList){
            if (entity.getPlace() == user_id) {
                siz++;
                entity.setPlace(agentID);
            }
        }
        return siz;
    }
}
