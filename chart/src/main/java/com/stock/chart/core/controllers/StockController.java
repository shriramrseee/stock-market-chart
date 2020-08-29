package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.Stock;
import com.stock.chart.core.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

    @Autowired
    private StockService sectorService;

    @PostMapping("/add")
    public void addStock(@RequestBody Stock sector) {
        sectorService.addStock(sector);
    }

    @GetMapping("/all")
    public List<Stock> getAllStocks() {
        return sectorService.getAllStocks();
    }

    @PutMapping("/update")
    public void updateStock(@RequestBody Stock Stock) {
        sectorService.updateStock(Stock);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStock(@PathVariable Integer id){
        sectorService.deleteStock(id);
    }
}
