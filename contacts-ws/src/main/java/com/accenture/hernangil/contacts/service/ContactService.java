package com.accenture.hernangil.contacts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.hernangil.contacts.dao.ContactRepository;
import com.accenture.hernangil.contacts.dto.Contact;

/**
 * 
 * @author Theron
 *
 * En este caso esta capa es muy simple pues no requerimos hacer operaciones 
 * con reglas de negocio o cálculos complejos y por ahora, sólo vamos a guardar 
 * los datos tal como nos llegan. En un servicio más complejo, es aquí en donde 
 * debemos dejar todas las operaciones que implementen la lógica de negocio,
 *  por ejemplo, consultar servicios externos, hacer validaciones complejas, 
 *  calcular otros campos, etc., haciendo que nuestro @RestController tenga la 
 *  menor cantidad de lógica posible.
 */
@Service
public class ContactService {
	
	@Autowired
	ContactRepository dao;
	
    public Contact save(Contact contact){
        //return dao.saveAndFlush(contact);
    	return dao.insert(contact);
    }

//	public void deleteAll() {
//		dao.deleteAll();
//	}

	public void saveAll(List<Contact> contactos) {
		dao.saveAll(contactos);
	}

	public List<Contact> findAll() {
		return dao.findAll();
	}

	public void insert(Contact contact) {
		dao.insert(contact);
	}

	public Optional<Contact> findById(String id) {
		return dao.findById(id);
	}

	public void deleteById(String id) {
		dao.deleteById(id);
	}
}
