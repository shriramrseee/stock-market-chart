package com.stock.chart.controllers;

import com.stock.chart.entities.Sector;
import com.stock.chart.repos.SectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/sector")
public class SectorController {

    @Autowired
    private SectorRepo sectorRepo;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestParam String name, @RequestParam String brief) {
        Sector s = new Sector();
        s.setName(name);
        s.setBrief(brief);
        sectorRepo.save(s);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Sector> getAllSectors() {
        return sectorRepo.findAll();
    }
}
