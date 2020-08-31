package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.Company;
import com.stock.chart.core.entities.IPO;
import com.stock.chart.core.services.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ipo")
public class IPOController {

    @Autowired
    private IPOService ipoService;

    @PostMapping("/admin/add")
    public void addIPO(@RequestBody IPO ipo) {
        ipoService.addIPO(ipo);
    }

    @GetMapping("/all")
    public List<IPO> getAllIPOs() {
        return ipoService.getAllIPOs();
    }

    @PutMapping("/admin/update")
    public void updateIPO(@RequestBody IPO IPO) {
        ipoService.updateIPO(IPO);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteIPO(@PathVariable Integer id){
        ipoService.deleteIPO(id);
    }

    @GetMapping("/company")
    public List<IPO> getCompanyIPOs(@RequestBody Company company) {
       return ipoService.getCompanyIPOs(company);
    }
}
