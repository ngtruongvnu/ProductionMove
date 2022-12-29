package com.project.productmove.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "products", schema = "product_move_offical", catalog = "")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "place")
    private long place;
    @Basic
    @Column(name = "warranty_period")
    private int warrantyPeriod;
    @Basic
    @Column(name = "warranty_from")
    private Timestamp warrantyFrom;
    @Basic
    @Column(name = "product_batch_id")
    private long productBatchId;
    @Basic
    @Column(name = "product_code")
    private long productCode;
    @Basic
    @Column(name = "created_by")
    private String createdBy;
    @Basic
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Basic
    @Column(name = "modified_by")
    private String modifiedBy;
    @Basic
    @Column(name = "modified_date")
    private Timestamp modifiedDate;
    @Basic
    @Column(name = "product_detail_id")
    private long productDetailId;
    @Basic
    @Column(name = "user_id")
    private long userId;
    @Basic
    @Column(name = "warranty_count")
    private Integer warrantyCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPlace() {
        return place;
    }

    public void setPlace(long place) {
        this.place = place;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Timestamp getWarrantyFrom() {
        return warrantyFrom;
    }

    public void setWarrantyFrom(Timestamp warrantyFrom) {
        this.warrantyFrom = warrantyFrom;
    }

    public long getProductBatchId() {
        return productBatchId;
    }

    public void setProductBatchId(long productBatchId) {
        this.productBatchId = productBatchId;
    }

    public long getProductCode() {
        return productCode;
    }

    public void setProductCode(long productCode) {
        this.productCode = productCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Integer getWarrantyCount() {
        return warrantyCount;
    }

    public void setWarrantyCount(Integer warrantyCount) {
        this.warrantyCount = warrantyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (place != that.place) return false;
        if (warrantyPeriod != that.warrantyPeriod) return false;
        if (productBatchId != that.productBatchId) return false;
        if (productCode != that.productCode) return false;
        if (productDetailId != that.productDetailId) return false;
        if (userId != that.userId) return false;
        if (warrantyFrom != null ? !warrantyFrom.equals(that.warrantyFrom) : that.warrantyFrom != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        if (warrantyCount != null ? !warrantyCount.equals(that.warrantyCount) : that.warrantyCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + status;
        result = 31 * result + (int) (place ^ (place >>> 32));
        result = 31 * result + warrantyPeriod;
        result = 31 * result + (warrantyFrom != null ? warrantyFrom.hashCode() : 0);
        result = 31 * result + (int) (productBatchId ^ (productBatchId >>> 32));
        result = 31 * result + (int) (productCode ^ (productCode >>> 32));
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (int) (productDetailId ^ (productDetailId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (warrantyCount != null ? warrantyCount.hashCode() : 0);
        return result;
    }
}
