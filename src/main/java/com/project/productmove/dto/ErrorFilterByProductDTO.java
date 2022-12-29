package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorFilterByProductDTO {
    @JsonProperty(value = "product_name", required = true)
    String productName;

    long product_id;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public List<String> getProductErrorList() {
        return productErrorList;
    }

    public void setProductErrorList(List<String> productErrorList) {
        this.productErrorList = productErrorList;
    }

    @JsonProperty(value = "product_error_list")
    List<String> productErrorList;
}
