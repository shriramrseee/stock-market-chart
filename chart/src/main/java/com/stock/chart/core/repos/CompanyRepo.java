package com.stock.chart.core.repos;
import com.stock.chart.core.entities.Company;
import com.stock.chart.core.entities.Sector;
import com.stock.chart.core.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
    List<Company> findByStockExchanges(StockExchange stockExchange);

    List<Company> findBySector(Sector sector);
}
