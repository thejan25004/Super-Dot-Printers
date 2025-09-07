package com.example.sdpbackend.service;

import com.example.sdpbackend.dto.ContactDTO;
import com.example.sdpbackend.entity.Contact;
import com.example.sdpbackend.repo.ContactRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private ModelMapper modelMapper;

    // Save contact message
    public boolean addContact(ContactDTO contactDTO) {
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contactRepo.save(contact);
        return true;
    }

    // Get all messages
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }

    // Get contact by ID
    public Contact getContactById(int contactId) {
        return contactRepo.findById(contactId).orElse(null);
    }

    // Delete contact
    public boolean deleteContact(int contactId) {
        if(contactRepo.existsById(contactId)){
            contactRepo.deleteById(contactId);
            return true;
        }
        return false;
    }
}
