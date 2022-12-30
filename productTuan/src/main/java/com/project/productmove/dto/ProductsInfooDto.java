package com.project.productmove.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class was created at 12/29/2022 23:24:56
 *
 * @author Tuan Vu
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductsInfooDto {
    Long product_id;
    Long product_code;
    String product_name;
    Integer product_status;
    Integer so_lan_bao_hanh;
}
