package com.project.productmove.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class was created at 12/29/2022 17:29:46
 *
 * @author Minh.LN
 */
@Data
@ToString
@NoArgsConstructor
public class ProductThongKeDTO {
    String username;
    Integer da_ban;
    Integer ton_kho;
    Integer dang_bao_hanh;
    Integer da_san_xuat;

}
