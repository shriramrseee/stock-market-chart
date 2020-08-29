package com.stock.chart.core.repos;

import com.stock.chart.core.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo  extends JpaRepository<Stock, Integer> {
}

