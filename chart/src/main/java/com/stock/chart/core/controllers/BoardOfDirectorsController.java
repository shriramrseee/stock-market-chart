package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.BoardOfDirectors;

import com.stock.chart.core.services.BoardOfDirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/board_of_directors")
public class BoardOfDirectorsController {
    @Autowired
    private BoardOfDirectorsService boardOfDirectorsService;

    @PostMapping("/add")
    public void addBoard_of_Directors(@RequestBody BoardOfDirectors board_of_directors) {
        boardOfDirectorsService.addBoard_of_Directors(board_of_directors);
    }

    @GetMapping("/all")
    public List<BoardOfDirectors> getAllBoard_of_Directors() {
        return boardOfDirectorsService.getAllBoard_of_Directors();
    }

    @PutMapping("/update")
    public void updateBoard_of_Directors(@RequestBody BoardOfDirectors board_of_directors) {
        boardOfDirectorsService.updateBoard_of_Directors(board_of_directors);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBoard_of_Directors(@PathVariable Integer id){
        boardOfDirectorsService.deleteBoard_of_Directors(id);
    }

}
