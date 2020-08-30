package com.stock.chart.core.repos;

import com.stock.chart.core.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
    List<Contact> findByCityContainingIgnoreCase(String city);

}
