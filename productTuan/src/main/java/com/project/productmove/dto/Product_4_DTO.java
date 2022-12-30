package com.project.productmove.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * This class was created at 12/27/2022 01:33:02
 *
 * @author Tuan Vu
 */

@Data
@ToString
@AllArgsConstructor
public class Product_4_DTO {
    ProductsDTO product;
    ProductlineDetailsDTO product_line;
    ProductBatchesDTO product_batch;
    String sellBy;
    String customer;
}
