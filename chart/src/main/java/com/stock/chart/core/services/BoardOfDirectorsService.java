package com.stock.chart.core.services;

import com.stock.chart.core.entities.BoardOfDirectors;

import com.stock.chart.core.repos.BoardOfDirectorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardOfDirectorsService {

    @Autowired
    private BoardOfDirectorsRepo boardOfDirectorsRepo;

    public List<BoardOfDirectors> getAllBoard_of_Directors() {
        return new ArrayList<>(boardOfDirectorsRepo.findAll());
    }

    public void addBoard_of_Directors(BoardOfDirectors board_of_directors) {
        boardOfDirectorsRepo.save(board_of_directors);
    }

    public void updateBoard_of_Directors(BoardOfDirectors board_of_directors) {
        boardOfDirectorsRepo.save(board_of_directors);
    }

    public void deleteBoard_of_Directors(Integer id) {
        boardOfDirectorsRepo.deleteById(id);
    }
}
