package com.stock.chart.core.test;
import com.stock.chart.core.entities.Sector;
import com.stock.chart.core.repos.SectorRepo;
import com.stock.chart.core.services.SectorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSector {

    @Autowired
    private SectorService service;

    @MockBean
    private SectorRepo repo;

    @Test
    public void getAllSectorsTest(){
        when(repo.findAll()).thenReturn(Stream.of(new Sector(21,"abc","def"),new Sector(15,"pharma","good work")).collect(Collectors.toList()));
        assertEquals(2,service.getAllSectors().size());
    }

    @Test
    public void addSectorTest(){
        Sector sector = new Sector(31,"food", "great food");
        when(repo.save(sector)).thenReturn(sector);
        assertEquals(sector, service.addSector(sector));
    }

    @Test
    public void deleteSectorTest(){
        Sector sector =new Sector(25,"sports","too good");
        service.deleteSector(25);
        verify(repo,times(1)).deleteById(25);
    }
    
}
