package org.Ike.Api.sys.model;

import java.util.Date;

public class SysSequence extends SysSequenceKey {
    /**
     * 
     */
    private Integer nextVal;

    /**
     * 
     */
    private Integer increment;

    /**
     * 
     */
    private Date updateTime;

    
    
    public Integer getNextVal() {
        return nextVal;
    }

    public void setNextVal(Integer nextVal) {
        this.nextVal = nextVal;
    }

    
    
    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    
    
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}