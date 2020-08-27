package com.stock.chart.models;

public class StockExchangeModel {

    private Integer id;
    private String brief;
    private String remarks;
    private ContactModel contactModel;

    public StockExchangeModel() {}

    public StockExchangeModel(Integer id, String brief, String remarks, ContactModel contactModel) {
        this.id = id;
        this.brief = brief;
        this.remarks = remarks;
        this.contactModel = contactModel;
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
