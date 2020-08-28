package com.stock.chart.repos;

import com.stock.chart.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo  extends JpaRepository<Stock, Integer> {
}

