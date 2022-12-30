package com.project.productmove.service.impl;

import com.project.productmove.dto.*;
import com.project.productmove.entity.OrderForProductEntity;
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
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    public String insertProducts(Long user_id, Long productline_id, Long quanlity, Long place_at) {
        ProductlineDetailsEntity pld = productLineDetailRepo.findById(productline_id).orElse(null);
        ProductBatchesEntity productBatchesEntity = new ProductBatchesEntity();
        productBatchesEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        productBatchesEntity.setQuantity(Math.toIntExact(quanlity));
        productBatchesEntity.setProducedAt(user_id);
        productBatchesEntity.setCreatedBy("System");
        productBatchesEntity = productBatchRepo.save(productBatchesEntity);
        List<ProductsEntity> productsEntityList = new ArrayList<>();
        for (int i = 1; i <= quanlity; i++){
            ProductsEntity entity = new ProductsEntity();
            entity.setCreatedBy("system");
            entity.setStatus(0);
            entity.setPlace(user_id);
            entity.setProductBatchId(productBatchesEntity.getId());
            entity.setProductDetailId(productline_id);
            entity.setUserId(user_id);
            entity.setPlace(place_at);
            entity.setProductCode(null);
            entity.setWarrantyPeriod(2);
            productsEntityList.add(entity);
        }
        System.out.println(productRepo.saveAll(productsEntityList));
        return "ok";
    }

    @Override
    public List<ProductsDTO> getProducts(Long user_id) {
        List<ProductsEntity> productsEntities = productRepo.getAllByStatusAndUserId(0, user_id);
        List<ProductsDTO> dtos = productsEntities.stream()
                .map(e -> modelMapper.map(e, ProductsDTO.class))
                .collect(Collectors.toList());
        return dtos;
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
        productRepo.saveAll(entityList);
        return siz;
    }

    @Override
    public List<ProductsDTO> getProductError(Long user_id) {
        List<ProductsEntity> list = productRepo.getAllByPlaceAndStatus(user_id, 7);
        List<ProductsDTO> dtos = list.stream()
                .map(x -> modelMapper.map(x, ProductsDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<Object[]> getProductErrorByProductline(Long user_id) {
        List<Object[]> list = productRepo.getProductErrorByProductline(user_id);
        return list;
    }

    @Override
    public String recoverByProductBatchId(Long productbatch_id) {
        try{
            List<ProductsEntity> entityList = productRepo.getAllByProductBatchId(productbatch_id);
            for (ProductsEntity entity : entityList){
                entity.setStatus(7);
            }
            productRepo.saveAll(entityList);
            return "Success";
        } catch (Exception e){
            log.error(e);
            return "Error";
        }
    }

    @Override
    public List<ErrorProductBatchDTO> getErrorByFilterProductbatch(Long user_id, Long productline_id) {
        try{
            List<Object[]> listSum = productRepo.countAllByUserAndProductline(user_id, productline_id);
            List<Object[]> errorList =  productRepo.countErrorByUserAndProductline(user_id, productline_id);
            List<ErrorProductBatchDTO> list = new ArrayList<>();
            int vt = 0;
            for (Object[] i : errorList){
                if (vt >=listSum.size()) break;
                if (i[1].equals(listSum.get(vt)[1])) {
                    Long x = Long.parseLong(String.valueOf( i[0]));
                    x = x * 100;
                    Long y = Long.parseLong(String.valueOf(listSum.get(vt)[0]));
                    list.add(new ErrorProductBatchDTO( Long.parseLong(String.valueOf(  i[1])), (float) (x/y)));
                } else {
                    list.add(new ErrorProductBatchDTO( Long.parseLong(String.valueOf(listSum.get(vt)[1])),0f));
                }
                vt++;
            }
            return list;
        } catch (Exception e){
            log.error(e);
            return null;
        }
    }

    @Override
    public List<ProductThongKeDTO> getProductByAgent() {
    List<Object[]> objectList = productRepo.getSumProducByAgent();
    List <ProductThongKeDTO> productThongKeDTOS = new ArrayList<>();
    for (Object[] i : objectList){
        ProductThongKeDTO dto = new ProductThongKeDTO();
        String name = (String) i[0];
        dto.setUsername(name);
        Integer ton_kho = Integer.valueOf(i[1].toString()) ;
        dto.setTon_kho(ton_kho);
        Integer da_ban = Integer.valueOf(i[2].toString()) ;
        dto.setDa_ban(da_ban);
        productThongKeDTOS.add(dto);
    }
    return  productThongKeDTOS;
    }

    @Override
    public List<ProductThongKeDTO> getProductByFactory() {
        List<Object[]> objectList = productRepo.getProductByFactory();
        List <ProductThongKeDTO> productThongKeDTOS = new ArrayList<>();
        for (Object[] i : objectList){
            ProductThongKeDTO dto = new ProductThongKeDTO();
            String name = (String) i[0];
            dto.setUsername(name);
            Integer da_san_xuat = Integer.valueOf(i[1].toString()) ;
            dto.setDa_san_xuat(da_san_xuat);
            Integer ton_kho = Integer.valueOf(i[2].toString());
            dto.setTon_kho(ton_kho);
            productThongKeDTOS.add(dto);
        }
        return  productThongKeDTOS;
    }

    @Override
    public List<ProductsInfooDto> getInfoProducts() {
        List <ProductsInfooDto> dtoList = new ArrayList<>();
        HashMap<Long, String> map = new HashMap<>();
        List<ProductlineDetailsEntity> name = productLineDetailRepo.findAll();
        for (ProductlineDetailsEntity n : name){
            map.put(n.getId(), n.getName());
        }
        List<ProductsEntity> entityList = productRepo.findAll();
        for (ProductsEntity i : entityList){
            ProductsInfooDto dto = new ProductsInfooDto(i.getId(), i.getProductCode(), null, i.getStatus(), i.getWarrantyCount());
            if (dto.getSo_lan_bao_hanh() == null)
                dto.setSo_lan_bao_hanh(0);
            dto.setProduct_name(map.get(i.getProductDetailId()));
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public String recoveryByProductBatchId(Long productline_id) {
        try {
            List<ProductsEntity> entityList = productRepo.findAllByProductDetailId(productline_id);
            for (ProductsEntity entity : entityList){
                entity.setStatus(9);
            }
            productRepo.saveAll(entityList);
            return "ok";
        } catch (Exception e){
            log.error("error in recoveryByProductBatchId " + productline_id);
            log.error(e);
            return "error";
        }

    }

    @Override
    public List<ProductThongKeDTO> getProductByServiceCenter() {
        List<Object[]> objectList = productRepo.getProductByServiceCenter();
        List <ProductThongKeDTO> productThongKeDTOS = new ArrayList<>();
        for (Object[] i : objectList){
            ProductThongKeDTO dto = new ProductThongKeDTO();
            String name = (String) i[0];
            dto.setUsername(name);
            Integer dang_bao_hanh = Integer.valueOf(i[1].toString()) ;
            dto.setDang_bao_hanh(dang_bao_hanh);
            productThongKeDTOS.add(dto);
        }
        return  productThongKeDTOS;
    }

}
