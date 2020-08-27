package com.stock.chart.models;

public class ContactModel {

    private Integer id;
    private String city;
    private String email;
    private String phone;
    private String state;
    private String zip;

    public ContactModel() { }

    public ContactModel(Integer id, String city, String email, String phone, String state, String zip) {
        this.id = id;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
