package com.example.sdpbackend.controller;

import com.example.sdpbackend.dto.ContactDTO;
import com.example.sdpbackend.entity.Contact;
import com.example.sdpbackend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/contact")
@CrossOrigin
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Save new contact
    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveContact(@RequestBody ContactDTO contactDTO) {
        boolean res = contactService.addContact(contactDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", res ? "Contact saved successfully" : "Failed to save contact");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get all contacts
    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
    }

    // Get contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") int id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null)
            return new ResponseEntity<>(contact, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete contact
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteContact(@PathVariable("id") int id) {
        boolean res = contactService.deleteContact(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", res ? "Contact deleted successfully" : "Contact not found");
        return new ResponseEntity<>(response, res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
