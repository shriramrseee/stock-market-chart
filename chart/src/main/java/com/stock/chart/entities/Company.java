package com.stock.chart.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ceo;
    private String brief;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", nullable = false)
    private Sector sector;

    @ManyToMany(mappedBy = "companies")
    private Set<StockExchange> stockExchanges;

    @OneToMany(mappedBy = "company")
    private Set<Stock> stocks;

    @OneToOne(cascade = CascadeType.ALL)
    private BoardOfDirectors boardOfDirectors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<IPO> ipos;

    public Company(Integer id, String ceo, String brief, String name, Sector sector, Set<StockExchange> stockExchanges, Set<Stock> stocks, BoardOfDirectors boardOfDirectors, Set<IPO> ipos) {
        this.id = id;
        this.ceo = ceo;
        this.brief = brief;
        this.name = name;
        this.sector = sector;
        this.stockExchanges = stockExchanges;
        this.stocks = stocks;
        this.boardOfDirectors = boardOfDirectors;
        this.ipos = ipos;
    }

    public Company(){}

    public BoardOfDirectors getBoardOfDirectors() {
        return boardOfDirectors;
    }

    public void setBoardOfDirectors(BoardOfDirectors boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Set<IPO> getIpos() {
        return ipos;
    }

    public void setIpos(Set<IPO> ipos) {
        this.ipos = ipos;
    }

    public Set<StockExchange> getStockExchanges() {
        return stockExchanges;
    }

    public void setStockExchanges(Set<StockExchange> stockExchanges) {
        this.stockExchanges = stockExchanges;
    }
}
