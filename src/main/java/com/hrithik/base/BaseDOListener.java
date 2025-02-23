package com.hrithik.base;

import com.hrithik.Constants.Constant;
import com.hrithik.Utility.GuidGenerator;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class BaseDOListener {

    @PrePersist
    public void preCreated(BaseDO baseDO){
        if(baseDO.getCreatedDt() == null)
            baseDO.setCreatedDt(LocalDateTime.now());
        if(baseDO.getUpdatedDt() == null)
            baseDO.setUpdatedDt(LocalDateTime.now());
        if(baseDO.getGuid() == null)
            baseDO.setGuid(GuidGenerator.getGuid());
        if(baseDO.getCreatedUser()== null)
            baseDO.setCreatedUser(Constant.SYSTEM);
        if(baseDO.getUpdatedUser()== null)
            baseDO.setUpdatedUser(Constant.SYSTEM);
    }

    @PreUpdate
    public void preUpdated(BaseDO baseDO){
        if(baseDO.getUpdatedDt() != null)
            baseDO.setUpdatedDt(LocalDateTime.now());
        if(baseDO.getUpdatedUser() != null)
            baseDO.setUpdatedUser(Constant.SYSTEM);
    }
}
