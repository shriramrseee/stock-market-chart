package com.stock.chart.core.services;

import com.stock.chart.core.entities.Company;
import com.stock.chart.core.entities.Sector;
import com.stock.chart.core.entities.StockExchange;
import com.stock.chart.core.repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    public void addCompany(Company company){
        companyRepo.save(company);
    }

    public List<Company> GetAllCompanies(){
        return new ArrayList<>(companyRepo.findAll());
    }

    public void UpdateCompany(Company company){
        companyRepo.save(company);
    }
    public void DeleteCompany(Integer id){
        companyRepo.deleteById(id);
    }

    public List<Company> getAllCompaniesInAStockExchange(StockExchange stockExchange){
        return companyRepo.findByStockExchanges(stockExchange);
    }

    public List<Company> getAllCompaniesInASector(Sector sector) {
        return companyRepo.findBySector(sector);
    }

    public List<Company> getMatchingCompanies(String pattern) {
        return companyRepo.findByNameContainingIgnoreCase(pattern);
    }
}
