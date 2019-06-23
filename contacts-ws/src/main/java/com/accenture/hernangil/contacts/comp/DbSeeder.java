package com.accenture.hernangil.contacts.comp;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.accenture.hernangil.contacts.dto.Contact;
import com.accenture.hernangil.contacts.service.ContactService;

@Component
public class DbSeeder implements CommandLineRunner {

	private ContactService contactService;
	
	public DbSeeder(ContactService contactService) {
		this.contactService = contactService;
	}

	@Override
	public void run(String... args) throws Exception {
		Contact contactoUno = new Contact(
				"Hernan", 
				"Gil", 
				"+573015546136",
				"elcorreodehero@gmail.com"
				);
		Contact contactoDos = new Contact(
				"Rodrigo", 
				"Arenas", 
				"+573010000000",
				"rodrigoarenas@gmail.com"
				);
		Contact contactoTres = new Contact(
				"Pedro", 
				"Gonzalez", 
				"+573052014596",
				"pedrogonzalez@gmail.com"
				);
		//drop off all contacts
		//this.contactService.deleteAll();
		
		//add all contacts to the database
		List<Contact> contactos = Arrays.asList(contactoUno, contactoDos, contactoTres);
		//this.contactService.saveAll(contactos);
	}

}
