package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellProductDTO {
    @JsonProperty(value = "first_name",required = true)
    private String fisrtName;

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @JsonProperty(value = "last_name",required = true)
    private String lastName;

    private String phone;

    private String address;

    @JsonProperty(value = "product_id",required = true)
    private Long productId;

}
