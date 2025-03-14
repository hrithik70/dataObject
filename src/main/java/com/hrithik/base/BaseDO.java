package com.hrithik.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(BaseDOListener.class)
public abstract class BaseDO implements Serializable {
    private String guid;
    private String createdUser;
    private String updatedUser;
    private LocalDateTime createdDt;
    private LocalDateTime updatedDt;
    private String workFlowStatusCd;
    private String baseCompanyCd;

    private String entityType;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(LocalDateTime createdDt) {
        this.createdDt = createdDt;
    }

    public LocalDateTime getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(LocalDateTime updatedDt) {
        this.updatedDt = updatedDt;
    }
    public String getWorkFlowStatusCd() {
        return workFlowStatusCd;
    }
    public void setWorkFlowStatusCd(String workFlowStatusCd) {
        this.workFlowStatusCd = workFlowStatusCd;
    }

    public String getBaseCompanyCd() {
        return baseCompanyCd;
    }

    public void setBaseCompanyCd(String baseCompanyCd) {
        this.baseCompanyCd = baseCompanyCd;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
}
