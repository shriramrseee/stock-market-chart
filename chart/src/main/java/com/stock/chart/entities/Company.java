package com.stock.chart.entities;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_exchange_id", nullable = false)
    private StockExchange stockExchange;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Stock> stocks;

    @OneToOne(cascade = CascadeType.ALL)
    private BoardOfDirectors boardOfDirectors;

    @OneToOne(mappedBy = "company")
    private IPO ipo;

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

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public IPO getIpo() {
        return ipo;
    }

    public void setIpo(IPO ipo) {
        this.ipo = ipo;
    }
}
