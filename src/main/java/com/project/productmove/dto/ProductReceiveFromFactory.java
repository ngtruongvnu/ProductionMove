package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class created at 12/19/2022 00:23:20
 *
 * @author HoàngKhôngNgủ
 */
public class ProductReceiveFromFactory {
    public long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(long factoryId) {
        this.factoryId = factoryId;
    }

    public List<Integer> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Integer> productIdList) {
        this.productIdList = productIdList;
    }

    @JsonProperty(value = "factory_id", required = true)
    private long factoryId;

    @JsonProperty(value = "product_id", required = true)
    private List<Integer> productIdList;
}
