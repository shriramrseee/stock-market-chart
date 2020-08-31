package com.stock.chart.core.repos;

import com.stock.chart.core.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer> {
    List<StockExchange> findByBriefContainingIgnoreCase(String brief);
}
