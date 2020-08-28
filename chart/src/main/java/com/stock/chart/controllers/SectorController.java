package com.stock.chart.controllers;

import com.stock.chart.entities.Sector;
import com.stock.chart.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @PostMapping("/add")
    public void addSector(@RequestBody Sector sector) {
        sectorService.addSector(sector);
    }

    @GetMapping("/all")
    public List<Sector> getAllSectors() {
        return sectorService.getAllSectors();
    }
}
