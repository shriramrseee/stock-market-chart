package com.stock.chart.core.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        scope = Company.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "stock_exchange_companies",
            joinColumns = @JoinColumn(name = "stock_exchange_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "id")
    )
    private Set<StockExchange> stockExchanges;

    @OneToOne(cascade = CascadeType.ALL)
    private BoardOfDirectors boardOfDirectors;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ipo_id", nullable = false, referencedColumnName = "id")
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

    public IPO getIpo() {
        return ipo;
    }

    public void setIpo(IPO ipo) {
        this.ipo = ipo;
    }

    public Set<StockExchange> getStockExchanges() {
        return stockExchanges;
    }

    public void setStockExchanges(Set<StockExchange> stockExchanges) {
        this.stockExchanges = stockExchanges;
    }
}
