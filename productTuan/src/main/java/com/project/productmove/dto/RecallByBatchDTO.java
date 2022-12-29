package com.project.productmove.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecallByBatchDTO {
    private long batch_id;
    @JsonProperty(value = "error",required = true)
    private String errorDescription;
    private String serviceCenterId;

    public String getServiceCenterId() {
        return serviceCenterId;
    }

    public void setServiceCenterId(String serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }

    public long getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(long batch_id) {
        this.batch_id = batch_id;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

}
