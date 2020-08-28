package com.stock.chart.services;

import com.stock.chart.entities.Stock;
import com.stock.chart.repos.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public List<Stock> getAllStocks() {
        return new ArrayList<>(stockRepo.findAll());
    }

    public void addStock(Stock sector) {
        stockRepo.save(sector);
    }

    public void updateStock(Stock Stock) {
        stockRepo.save(Stock);
    }

    public void deleteStock(Integer id) {
        stockRepo.deleteById(id);
    }
}
