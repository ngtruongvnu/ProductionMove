package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsDTO {

    @JsonProperty(value = "product_id", required = true)
    private Long id;
    private Integer status;
    private Long place;
    private Integer warrantyPeriod;
    private java.sql.Timestamp warrantyFrom;
    private Long productBatchId;
    private Long productCode;
    private String createdBy;
    private java.sql.Timestamp createdDate;
    private String modifiedBy;
    private java.sql.Timestamp modifiedDate;
    private Long productDetailId;
    @JsonProperty(value = "user_id",required = true)
    private Long userId;
    private Integer warrantyCount;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPlace() {
        return this.place;
    }

    public void setPlace(Long place) {
        this.place = place;
    }

    public Integer getWarrantyPeriod() {
        return this.warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public java.sql.Timestamp getWarrantyFrom() {
        return this.warrantyFrom;
    }

    public void setWarrantyFrom(java.sql.Timestamp warrantyFrom) {
        this.warrantyFrom = warrantyFrom;
    }

    public Long getProductBatchId() {
        return this.productBatchId;
    }

    public void setProductBatchId(Long productBatchId) {
        this.productBatchId = productBatchId;
    }

    public Long getProductCode() {
        return this.productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public java.sql.Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.sql.Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public java.sql.Timestamp getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(java.sql.Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getProductDetailId() {
        return this.productDetailId;
    }

    public void setProductDetailId(Long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getWarrantyCount() {
        return this.warrantyCount;
    }

    public void setWarrantyCount(Integer warrantyCount) {
        this.warrantyCount = warrantyCount;
    }
}
