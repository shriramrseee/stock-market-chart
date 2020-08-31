package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.Company;
import com.stock.chart.core.entities.Sector;
import com.stock.chart.core.entities.StockExchange;
import com.stock.chart.core.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/admin/add")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.GetAllCompanies();
    }

     @PutMapping("/admin/update")
     public void UpdateCompany(@RequestBody Company company){
        companyService.UpdateCompany(company);
    }

    @GetMapping("/admin/delete/{id}")
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

    @GetMapping(
            path = "/match",
            consumes = "text/plain"
    )
    public List<Company> getMatchingCompanies(@RequestBody String name) {
        return companyService.getMatchingCompanies(name);
    }
}
