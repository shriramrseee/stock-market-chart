package com.stock.chart.repos;
import com.stock.chart.entities.Company;
import com.stock.chart.entities.Sector;
import com.stock.chart.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
    List<Company> findByStockExchanges(StockExchange stockExchange);

    List<Company> findBySector(Sector sector);
}
