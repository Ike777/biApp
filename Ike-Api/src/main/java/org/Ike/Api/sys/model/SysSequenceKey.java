package org.Ike.Api.sys.model;

import java.util.Date;

public class SysSequenceKey {
    private Date startDate;

    private String tableName;

    private String startDateQuery;

    public String getStartDateQuery() {
        return startDateQuery;
    }

    public void setStartDateQuery(String startDateQuery) {
        this.startDateQuery = startDateQuery;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }
}