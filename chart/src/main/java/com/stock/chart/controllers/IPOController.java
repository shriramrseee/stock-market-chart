package com.stock.chart.controllers;

import com.stock.chart.entities.Company;
import com.stock.chart.entities.IPO;
import com.stock.chart.services.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ipo")
public class IPOController {

    @Autowired
    private IPOService ipoService;

    @PostMapping("/add")
    public void addIPO(@RequestBody IPO ipo) {
        ipoService.addIPO(ipo);
    }

    @GetMapping("/all")
    public List<IPO> getAllIPOs() {
        return ipoService.getAllIPOs();
    }

    @PutMapping("/update")
    public void updateIPO(@RequestBody IPO IPO) {
        ipoService.updateIPO(IPO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIPO(@PathVariable Integer id){
        ipoService.deleteIPO(id);
    }

    @GetMapping("/company")
    public List<IPO> getCompanyIPOs(@RequestBody Company company) {
       return ipoService.getCompanyIPOs(company);
    }
}
