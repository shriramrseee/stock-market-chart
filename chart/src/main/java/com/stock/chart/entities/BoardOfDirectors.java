package com.stock.chart.entities;

import javax.persistence.*;

@Entity

public class BoardOfDirectors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Directors;

    @OneToOne
    @MapsId
    private Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirectors() {
        return Directors;
    }

    public void setDirectors(String directors) {
        Directors = directors;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
