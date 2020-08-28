package com.stock.chart.controllers;

import com.stock.chart.entities.Company;
import com.stock.chart.entities.Contact;
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

}
