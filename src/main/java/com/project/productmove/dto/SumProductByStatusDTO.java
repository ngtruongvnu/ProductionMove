package com.project.productmove.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * This class was created at 12/27/2022 00:53:51
 *
 * @author Minh.LN
 */

@ToString
@Data
@AllArgsConstructor
public class SumProductByStatusDTO {
    Integer moi_san_xuat;
    Integer o_dai_ly;
    Integer da_ban;
    Integer dang_bao_hanh;
    Integer da_hong;
}
