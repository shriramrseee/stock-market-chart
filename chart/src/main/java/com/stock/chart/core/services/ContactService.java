package com.stock.chart.core.services;

import com.stock.chart.core.entities.Contact;
import com.stock.chart.core.repos.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactRepo.findAll());
    }

    public void addContact(Contact contact) {
        contactRepo.save(contact);
    }

    public void updateContact(Contact Contact) {
        contactRepo.save(Contact);
    }

    public void deleteContact(Integer id) {
        contactRepo.deleteById(id);
    }
}
