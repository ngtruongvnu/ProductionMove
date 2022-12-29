package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SendToWarehouseServiceDTO {

    @JsonProperty("product_id")
    private List<Long> productIdList;
    @JsonProperty("warehouse_id")
    private long warehouseId;

    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }
}
