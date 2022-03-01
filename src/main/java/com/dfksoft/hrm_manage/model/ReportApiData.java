package com.dfksoft.hrm_manage.model;

import com.dfksoft.hrm_manage.entity.Report;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReportApiData {
    private int status;
    private ArrayList<Report> dataReport;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Report> getDataReport() {
        return dataReport;
    }

    public void setDataReport(ArrayList<Report> dataReport) {
        this.dataReport = dataReport;
    }
}
