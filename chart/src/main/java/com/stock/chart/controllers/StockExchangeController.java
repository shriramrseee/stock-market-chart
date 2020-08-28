package com.stock.chart.controllers;

import com.stock.chart.entities.StockExchange;
import com.stock.chart.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-exchange")
public class StockExchangeController {

    @Autowired
    private StockExchangeService stockExchangeService;

    @PostMapping("/add")
    public void addStockExchange(@RequestBody StockExchange stockExchange) {
        stockExchangeService.addStockExchange(stockExchange);
    }

    @GetMapping("/all")
    public List<StockExchange> getAllStockExchanges() {
        return stockExchangeService.getAllStockExchanges();
    }

    @PutMapping("/update")
    public void updateStockExchange(@RequestBody StockExchange stockExchange) {
        stockExchangeService.updateStockExchange(stockExchange);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStockExchange(@PathVariable Integer id){
        stockExchangeService.deleteStockExchange(id);
    }
}
