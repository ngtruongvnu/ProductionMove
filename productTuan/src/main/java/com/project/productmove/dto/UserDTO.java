package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    private Long id;
    private Integer role;

    @JsonProperty(value = "user_name",required = true)
    private String userName;
    private String password;
    private String imgUrl;
    private String createdBy;
    private java.sql.Timestamp createdDate;
    private String modifiedBy;
    private java.sql.Timestamp modifiedDate;
    private String firstName;
    private String lastName;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
