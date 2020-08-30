package com.stock.chart.core.controllers;

import com.stock.chart.core.services.FileImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;


@RestController
@RequestMapping(path = "/import")
public class FileImportController {

    @Autowired
    private FileImportService fileImportService;

    @GetMapping("/excel")
    public void addSector() throws IOException, ParseException {
        FileInputStream fs = new FileInputStream("path");
        fileImportService.importExcelFile(fs);
    }

}
