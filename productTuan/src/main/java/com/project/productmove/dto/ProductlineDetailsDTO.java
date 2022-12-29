package com.project.productmove.dto;

public class ProductlineDetailsDTO {
    private Long id;
    private Integer type;
    private Integer categoryCar;
    private String createdBy;
    private java.sql.Timestamp createdDate;
    private String modifiedBy;
    private java.sql.Timestamp modifiedDate;
    private String description;
    private String imgUrl;
    private Double lenght;
    private Double width;
    private String power;
    private Integer displacement;
    private String gearbox;
    private Integer seats;
    private String engine;
    private String name;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCategoryCar() {
        return this.categoryCar;
    }

    public void setCategoryCar(Integer categoryCar) {
        this.categoryCar = categoryCar;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getLenght() {
        return this.lenght;
    }

    public void setLenght(Double lenght) {
        this.lenght = lenght;
    }

    public Double getWidth() {
        return this.width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String getPower() {
        return this.power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public String getGearbox() {
        return this.gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getSeats() {
        return this.seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
