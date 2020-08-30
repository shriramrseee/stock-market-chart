package com.stock.chart.core.services;

import com.stock.chart.core.entities.*;
import com.stock.chart.core.repos.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FileImportService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private StockExchangeRepo stockExchangeRepo;

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private SectorRepo sectorRepo;

    public void importExcelFile(InputStream inputStream) throws IOException, ParseException {
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.iterator();
        rowIterator.next();
        DateFormat format = new SimpleDateFormat("DD-MM-YYYY HH:MM:SS", Locale.ENGLISH);
        while(rowIterator.hasNext()) {
            Iterator<Cell> cells = rowIterator.next().cellIterator();
            String companyName = cells.next().getStringCellValue();
            String stockExchangeName = cells.next().getStringCellValue();
            Double price = cells.next().getNumericCellValue();
            Date day = cells.next().getDateCellValue();
            cells.next(); // TODO: Capture time
            StockExchange se = getorCreateStockExchange(stockExchangeName);
            createStockPrice(price, day, getOrCreateCompany(companyName, se), se);
        }
    }

    private StockExchange getorCreateStockExchange(String stockExchangeName) {
        List<StockExchange> ses = stockExchangeRepo.findByBriefContainingIgnoreCase(stockExchangeName);
        if (ses == null || ses.size() == 0) {
            // Create
            StockExchange se = new StockExchange();
            se.setBrief(stockExchangeName);
            se.setContact(getOrCreateContact(stockExchangeName+"City"));
            return stockExchangeRepo.save(se);
        }
        else {
            return ses.get(0);
        }
    }

    private Contact getOrCreateContact(String cityName) {
        List<Contact> cns = contactRepo.findByCityContainingIgnoreCase(cityName);
        if (cns == null || cns.size() == 0) {
            Contact c = new Contact();
            c.setCity(cityName);
            return contactRepo.save(c);
        }
        else {
            return cns.get(0);
        }
    }

    private Sector getOrCreateSector() {
       List<Sector> ss = sectorRepo.findByNameContainingIgnoreCase("Test");
       if(ss == null || ss.size() == 0) {
           Sector s = new Sector();
           s.setName("Test");
           return  sectorRepo.save(s);
       }
       else {
           return ss.get(0);
       }
    }

    private Company getOrCreateCompany(String companyName, StockExchange stockExchange) {
        List<Company> cs = companyRepo.findByNameContainingIgnoreCase(companyName);
        if(cs == null || cs.size() == 0) {
            Company c = new Company();
            c.setName(companyName);
            c.setStockExchanges(new HashSet<>());
            c.getStockExchanges().add(stockExchange);
            c.setSector(getOrCreateSector());
            return companyRepo.save(c);
        }
        else {
            return cs.get(0);
        }
    }

    private Stock createStockPrice(Double price, Date day, Company company, StockExchange se) {
        Stock s = new Stock();
        s.setClosePrice(price);
        s.setOpenPrice(price);
        s.setCompany(company);
        s.setStockExchange(se);
        s.setDate(day);
        return stockRepo.save(s);
    }

}
