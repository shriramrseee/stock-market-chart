package com.stock.chart.repos;
import com.stock.chart.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Integer >{

}
