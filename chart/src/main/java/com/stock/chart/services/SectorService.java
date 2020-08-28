package com.stock.chart.services;

import com.stock.chart.entities.Sector;
import com.stock.chart.repos.SectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorService {

    @Autowired
    private SectorRepo sectorRepo;

    public List<Sector> getAllSectors() {
        return new ArrayList<>(sectorRepo.findAll());
    }

    public void addSector(Sector sector) {
        sectorRepo.save(sector);
    }
}
