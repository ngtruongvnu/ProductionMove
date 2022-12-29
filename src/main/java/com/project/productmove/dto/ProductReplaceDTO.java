package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductReplaceDTO {

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @JsonProperty(value = "product_id",required = true)
    long productId;

    @JsonProperty(value = "customer_id",required = true)
    long customerId;
}
