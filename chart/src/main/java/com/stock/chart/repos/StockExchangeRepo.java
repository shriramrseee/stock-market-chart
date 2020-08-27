package com.stock.chart.repos;

import com.stock.chart.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer> {
}
