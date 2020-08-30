package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.Board_of_Directors;

import com.stock.chart.core.services.Board_of_DirectorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/board_of_directors")
public class Board_of_DirectorsController {
    @Autowired
    private Board_of_DirectorsService board_of_directorsService;

    @PostMapping("/add")
    public void addBoard_of_Directors(@RequestBody Board_of_Directors board_of_directors) {
        board_of_directorsService.addBoard_of_Directors(board_of_directors);
    }

    @GetMapping("/all")
    public List<Board_of_Directors> getAllBoard_of_Directors() {
        return board_of_directorsService.getAllBoard_of_Directors();
    }

    @PutMapping("/update")
    public void updateBoard_of_Directors(@RequestBody Board_of_Directors board_of_directors) {
        board_of_directorsService.updateBoard_of_Directors(board_of_directors);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBoard_of_Directors(@PathVariable Integer id){
        board_of_directorsService.deleteBoard_of_Directors(id);
    }

}
