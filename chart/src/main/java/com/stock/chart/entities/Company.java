package com.stock.chart.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.*;

@Entity

public class Company {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String ceo;
	private String brief;
	private String name;
	private Integer sector_id;
	@OneToOne(cascade = CascadeType.ALL)
	private BoardOfDirectors boardOfDirectors;



	public Company(){}

	public BoardOfDirectors getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(BoardOfDirectors boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSector_id() {
		return sector_id;
	}

	public void setSector_id(Integer sector_id) {
		this.sector_id = sector_id;
	}


}
