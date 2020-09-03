package com.stock.chart.core.services;

import com.stock.chart.core.entities.Sector;
import com.stock.chart.core.repos.SectorRepo;
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

    public Sector addSector(Sector sector) {
        return sectorRepo.save(sector);
    }

    public void updateSector(Sector Sector) {
        sectorRepo.save(Sector);
    }

    public void deleteSector(Integer id) {
        sectorRepo.deleteById(id);
    }
}
