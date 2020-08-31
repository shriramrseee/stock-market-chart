package com.stock.chart.core.models;

import java.util.Date;

public class StockFilter {

    private Integer companyId;
    private Integer stockExchangeId;
    private Date from;
    private Date to;

    public StockFilter() {

    }

    public StockFilter(Integer company_id, Integer stockExchangeId, Date from, Date to) {
        this.companyId = company_id;
        this.stockExchangeId = stockExchangeId;
        this.from = from;
        this.to = to;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStockExchangeId() {
        return stockExchangeId;
    }

    public void setStockExchangeId(Integer stockExchangeId) {
        this.stockExchangeId = stockExchangeId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

}
