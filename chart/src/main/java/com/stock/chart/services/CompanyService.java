package com.stock.chart.services;

import com.stock.chart.entities.Company;
import com.stock.chart.entities.StockExchange;
import com.stock.chart.repos.CompanyRepo;
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
}
