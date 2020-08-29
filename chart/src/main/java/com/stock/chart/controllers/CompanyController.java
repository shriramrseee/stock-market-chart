package com.stock.chart.controllers;

import com.stock.chart.entities.Company;
import com.stock.chart.entities.Sector;
import com.stock.chart.entities.StockExchange;
import com.stock.chart.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/add")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.GetAllCompanies();
    }

     @PutMapping("/update")
     public void UpdateCompany(@RequestBody Company company){
        companyService.UpdateCompany(company);
    }

    @GetMapping("/delete/{id}")
    public void DeleteCompany(@PathVariable Integer id){
        companyService.DeleteCompany(id);
    }

    @GetMapping("/stock-exchange")
    public List<Company> getAll(@RequestBody StockExchange stockExchange) {
        return companyService.getAllCompaniesInAStockExchange(stockExchange);
    }

    @GetMapping("/sector")
    public List<Company> getBySector(@RequestBody Sector sector) {
        return companyService.getAllCompaniesInASector(sector);
    }
}
