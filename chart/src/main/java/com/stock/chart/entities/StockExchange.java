package com.stock.chart.entities;

import javax.persistence.*;

@Entity
public class StockExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brief;
    private String remarks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public StockExchange() {}

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

