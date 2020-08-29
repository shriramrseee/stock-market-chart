package com.stock.chart.core.controllers;

import com.stock.chart.core.entities.Contact;
import com.stock.chart.core.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }

    @GetMapping("/all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PutMapping("/update")
    public void updateContact(@RequestBody Contact Contact) {
        contactService.updateContact(Contact);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable Integer id){
        contactService.deleteContact(id);
    }
}
