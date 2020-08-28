package com.stock.chart.repos;

import com.stock.chart.entities.IPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPORepo extends JpaRepository<IPO, Integer> {
}
