package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductWarrantyDTO {
    @JsonProperty(value = "product_id",required = true)
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @JsonProperty(value = "product_line_name",required = true)
    private String productLineName;

    public String getProductLineName() {
        return productLineName;
    }

    public void setProductLineName(String productLineName) {
        this.productLineName = productLineName;
    }
}
