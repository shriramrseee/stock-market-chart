package com.stock.chart.repos;

import com.stock.chart.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
}
