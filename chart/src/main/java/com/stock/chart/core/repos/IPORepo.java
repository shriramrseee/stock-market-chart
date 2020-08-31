package com.stock.chart.core.repos;

import com.stock.chart.core.entities.Company;
import com.stock.chart.core.entities.IPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPORepo extends JpaRepository<IPO, Integer> {
    List<IPO> findByCompany(Company company);
}
