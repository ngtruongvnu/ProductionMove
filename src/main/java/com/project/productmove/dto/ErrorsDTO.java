package com.project.productmove.dto;

public class ErrorsDTO {
    private Long id;
    private Long productId;
    private Integer type;
    private Long productBatch;
    private String description;
    private java.sql.Timestamp createdDate;
    private String createdBy;
    private java.sql.Timestamp modifiedDate;
    private String modifiedBy;

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

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getProductBatch() {
        return this.productBatch;
    }

    public void setProductBatch(Long productBatch) {
        this.productBatch = productBatch;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Timestamp getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.sql.Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public java.sql.Timestamp getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(java.sql.Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
