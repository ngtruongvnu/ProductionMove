package com.project.productmove.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class was created at 12/27/2022 18:24:21
 *
 * @author Minh.LN
 */
@Data
@ToString
@NoArgsConstructor
public class ProductStatusDTO {
    int moi_san_xuat;
    int dua_ve_dai_ly;
    int da_ban;
    int loi_can_bao_hanh;
    int dang_sua_chua_bao_hanh;
    int da_bao_hanh_xong;
    int da_tra_lai_bao_hanh_cho_khach_hang;
    int loi_can_tra_ve_nha_may;
    int loi_da_dua_ve_co_so_san_xuat;
    int loi_can_trieu_hoi;
    int het_thoi_gian_bao_hanh;
    int tra_lai_co_so_san_xuat;
}
