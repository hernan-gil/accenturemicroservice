package com.accenture.hernangil.contacts.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.hernangil.contacts.dto.Contact;
import com.accenture.hernangil.contacts.service.ContactService;

/**
 * 
 * @author Theron
 *	Para que Spring reconozca una clase como servicio web y la trate como tal, 
 *	debemos anotar la clase con @RestController. También debemos anotar cada método 
 *  público que deseemos exponer a los clientes con la anotación @RequestMapping.
 *
 * Dozer
 * las propiedades del DTO y del Entity se llaman igual, así que no requerimos 
 * especificar mapeos explícitamente y nuestra clase de interfaz (ContactsApi)
 */
@RestController
@RequestMapping("/contactos")
public class ContactsApi {

	// Inyecta mapper de Dozer
	@Autowired
	Mapper mapper;
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
    public Contact getById(){
        return new Contact("1", "Hernan", "Gil", "+573015546136", "elcoreodehero@gmail.com");
    }
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public ContactResponse updateOrSave(@RequestBody  @Valid ContactRequest  contactRequest ){
		//Mapeo del dto request entity
		Contact contact = mapper.map(contactRequest, Contact.class);
		// Invoca lógica de negocio
	    Contact updatedContact = contactService.save(contact);
	    // Mapeo entity response dto
	    ContactResponse contactResponse = mapper.map(updatedContact, ContactResponse.class);
	    
	    return contactResponse;
	    //return contactService.save(contactRequest);
	}
	
	
	@GetMapping ("/All")
	public List<Contact> getAll(){
		List<Contact> contactos = contactService.findAll();
		return contactos;
	}
	@PutMapping
	public void insert(@RequestBody @Valid ContactRequest  contactRequest) {
		Contact contact = mapper.map(contactRequest, Contact.class);
		contactService.save(contact);
	}
	@PostMapping
	public void update(@RequestBody @Valid ContactRequest  contactRequest) {
		Contact contact = mapper.map(contactRequest, Contact.class);
		contactService.save(contact);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		contactService.deleteById(id);
	}
	@GetMapping ("/{id}")
	public ContactResponse getById(@PathVariable("id") String id) {
		Optional<Contact> searchedContact = contactService.findById(id);
		ContactResponse contactResponse = mapper.map(searchedContact, ContactResponse.class);
		return contactResponse;
	}
}
