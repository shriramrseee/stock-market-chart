package com.stock.chart.services;

import com.stock.chart.entities.Company;
import com.stock.chart.entities.StockExchange;
import com.stock.chart.repos.StockExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepo stockExchangeRepo;

    public List<StockExchange> getAllStockExchanges() {
        return new ArrayList<>(stockExchangeRepo.findAll());
    }

    public void addStockExchange(StockExchange stockExchange) {
        stockExchangeRepo.save(stockExchange);
    }

    public void updateStockExchange(StockExchange stockExchange) {
        stockExchangeRepo.save(stockExchange);
    }

    public void deleteStockExchange(Integer id) {
        stockExchangeRepo.deleteById(id);
    }

    public List<Company> getCompaniesList(StockExchange stockExchange) {
        // TODO
        return null;
    }
}
