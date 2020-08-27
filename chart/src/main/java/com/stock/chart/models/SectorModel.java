package com.stock.chart.models;

public class SectorModel {

    private Integer id;

    private String name;

    private String brief;

    public SectorModel(Integer id, String name, String brief) {
        this.id = id;
        this.name = name;
        this.brief = brief;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

}
