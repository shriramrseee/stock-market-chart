package com.stock.chart.core.repos;

import com.stock.chart.core.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface StockRepo  extends JpaRepository<Stock, Integer> {

    @Query(value = "SELECT * FROM Stock s WHERE s.company_id = ?1 AND s.date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Stock> findByCompanyDateRange(Integer companyId, Date from, Date to);

}

