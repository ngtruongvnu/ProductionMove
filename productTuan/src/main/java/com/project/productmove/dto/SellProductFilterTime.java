package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * This class created at 12/20/2022 15:23:58
 *
 * @author HoàngKhôngNgủ
 */
public class SellProductFilterTime {
    @JsonProperty(value = "productline_name", required = true)
    private String productLineName;
    @JsonProperty(value = "quantity_sell", required = true)
    private BigInteger quantitySell;

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProductLineName() {
        return productLineName;
    }

    public void setProductLineName(String productLineName) {
        this.productLineName = productLineName;
    }

    public BigInteger getQuantitySell() {
        return quantitySell;
    }

    public void setQuantitySell(BigInteger quantitySell) {
        this.quantitySell = quantitySell;
    }

}