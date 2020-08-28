package com.stock.chart.entities;

import javax.persistence.*;

@Entity
public class IPO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // TODO : Add other fields

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false, referencedColumnName = "id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
