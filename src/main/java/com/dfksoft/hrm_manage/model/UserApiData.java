package com.dfksoft.hrm_manage.model;

import com.dfksoft.hrm_manage.entity.AccountInfo;
import org.springframework.http.ResponseEntity;

public class UserApiData {
    private int status;
    private AccountInfo accountInfo;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }
}
