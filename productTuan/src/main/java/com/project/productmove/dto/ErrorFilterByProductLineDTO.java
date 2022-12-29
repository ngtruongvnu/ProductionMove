package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorFilterByProductLineDTO {

    @JsonProperty(value = "product_name", required = true)
    String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(long productLineId) {
        this.productLineId = productLineId;
    }

    public String getDescibleError() {
        return descibleError;
    }

    public void setDescibleError(String descibleError) {
        this.descibleError = descibleError;
    }

    @JsonProperty(value = "product_line_id", required = true)
    long productLineId;

    @JsonProperty(value = "descible_error", required = true)
    String descibleError;
}
