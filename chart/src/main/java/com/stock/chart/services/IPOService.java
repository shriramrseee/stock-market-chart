package com.stock.chart.services;

import com.stock.chart.entities.Company;
import com.stock.chart.entities.IPO;
import com.stock.chart.repos.IPORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPOService {

    @Autowired
    private IPORepo ipoRepo;

    public List<IPO> getAllIPOs() {
        return new ArrayList<>(ipoRepo.findAll());
    }

    public void addIPO(IPO sector) {
        ipoRepo.save(sector);
    }

    public void updateIPO(IPO IPO) {
        ipoRepo.save(IPO);
    }

    public void deleteIPO(Integer id) {
        ipoRepo.deleteById(id);
    }

    public List<IPO> getCompanyIPOs(Company company) {
        return ipoRepo.findByCompany(company);
    }
}
