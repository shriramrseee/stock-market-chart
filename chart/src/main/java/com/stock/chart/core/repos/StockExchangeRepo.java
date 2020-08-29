package com.stock.chart.core.repos;

import com.stock.chart.core.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepo extends JpaRepository<StockExchange, Integer> {
}
