package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.Stock;
import com.stock.chart.core.models.StockFilter;
import com.stock.chart.core.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/add")
    public void addStock(@RequestBody Stock stock) {
        stockService.addStock(stock);
    }

    @GetMapping("/all")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PutMapping("/update")
    public void updateStock(@RequestBody Stock Stock) {
        stockService.updateStock(Stock);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStock(@PathVariable Integer id){
        stockService.deleteStock(id);
    }

    @PostMapping("/get-by-company")
    public List<Stock> getStockByCompany(@RequestBody StockFilter sf) {
        return stockService.getByCompanyStockExchangeDateRange(sf);
    }
}
