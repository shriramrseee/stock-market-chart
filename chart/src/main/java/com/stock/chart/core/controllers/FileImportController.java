package com.stock.chart.core.controllers;

import com.stock.chart.core.services.FileImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;


@RestController
@RequestMapping(path = "/import")
public class FileImportController {

    @Autowired
    private FileImportService fileImportService;

    @PostMapping("/excel")
    public void importExcel(@RequestParam("file") MultipartFile data) throws IOException, ParseException {
        fileImportService.importExcelFile(data.getInputStream());
    }

}
