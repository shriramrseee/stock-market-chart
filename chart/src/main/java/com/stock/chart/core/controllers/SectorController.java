package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.Sector;
import com.stock.chart.core.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @PostMapping("/admin/add")
    public void addSector(@RequestBody Sector sector) {
        sectorService.addSector(sector);
    }

    @GetMapping("/all")
    public List<Sector> getAllSectors() {
        return sectorService.getAllSectors();
    }

    @PutMapping("/admin/update")
    public void updateSector(@RequestBody Sector Sector) {
        sectorService.updateSector(Sector);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteSector(@PathVariable Integer id){
        sectorService.deleteSector(id);
    }
}
