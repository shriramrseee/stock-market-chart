package com.stock.chart.repos;

import com.stock.chart.entities.Company;
import com.stock.chart.entities.IPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPORepo extends JpaRepository<IPO, Integer> {
    List<IPO> findByCompany(Company company);
}
