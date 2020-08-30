package com.stock.chart.core.services;

import com.stock.chart.core.entities.Board_of_Directors;

import com.stock.chart.core.repos.Board_of_DirectorsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Board_of_DirectorsService {

    @Autowired
    private Board_of_DirectorsRepo board_of_directorsRepo;

    public List<Board_of_Directors> getAllBoard_of_Directors() {
        return new ArrayList<>(board_of_directorsRepo.findAll());
    }

    public void addBoard_of_Directors(Board_of_Directors board_of_directors) {
        board_of_directorsRepo.save(board_of_directors);
    }

    public void updateBoard_of_Directors(Board_of_Directors board_of_directors) {
        board_of_directorsRepo.save(board_of_directors);
    }

    public void deleteBoard_of_Directors(Integer id) {
        board_of_directorsRepo.deleteById(id);
    }
}
