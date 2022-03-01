package com.dfksoft.hrm_manage.model;

import com.dfksoft.hrm_manage.entity.AccountInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.ResponseEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserApiData {
    private int status;
    private AccountInfo dataReport;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AccountInfo getDataReport() {
        return dataReport;
    }

    public void setDataReport(AccountInfo dataReport) {
        this.dataReport = dataReport;
    }
}
