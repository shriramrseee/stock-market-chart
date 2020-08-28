package com.stock.chart.controllers;

import com.stock.chart.entities.IPO;
import com.stock.chart.services.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ipo")
public class IPOController {

    @Autowired
    private IPOService sectorService;

    @PostMapping("/add")
    public void addIPO(@RequestBody IPO sector) {
        sectorService.addIPO(sector);
    }

    @GetMapping("/all")
    public List<IPO> getAllIPOs() {
        return sectorService.getAllIPOs();
    }

    @PutMapping("/update")
    public void updateIPO(@RequestBody IPO IPO) {
        sectorService.updateIPO(IPO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIPO(@PathVariable Integer id){
        sectorService.deleteIPO(id);
    }
}
