package com.accenture.hernangil.contacts.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.accenture.hernangil.contacts.dto.Contact;

/**
 * 
 * @author Theron
 * 
 * esta interfaz extiende la interfaz JpaRepository. 
 * Durante la inicialización de la aplicación, 
 * Spring Data busca estas interfaces y crea  clases 
 * que las implementan, ofreciendo automáticamente los 
 * métodos típicos para Crear, Actualizar o Eliminar (CRUD)
 *
 * @params
 * Los parámetros de esta interfaz son: la entidad a gestionar (Contact) 
 * y el tipo de dato de su clave primaria (Long).
 */
@Repository
public interface ContactRepository extends MongoRepository <Contact, String> {
	@SuppressWarnings("unchecked")
	Contact insert(Contact contact);
	List<Contact> findAll();
}
//void saveAll(List<Contact> contactos);
//void remove(String id);