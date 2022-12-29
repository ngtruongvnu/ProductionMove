package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class OrderForProductDTO {
    private Long id;
    @JsonProperty(value = "product_id", required = true)
    private Long productId;
    @JsonProperty(value = "customer_id", required = true)
    private Long customerId;

    private Long sellBy;
//    private String createdBy;
    private Date createdDate;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    @JsonProperty(value = "customer_id", required = true)
    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSellBy() {
        return this.sellBy;
    }

    public void setSellBy(Long sellBy) {
        this.sellBy = sellBy;
    }

//    public String getCreatedBy() {
//        return this.createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
