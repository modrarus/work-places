package org.modrarus.workplaces.controller;

import java.util.List;

import org.modrarus.workplaces.model.Contact;
import org.modrarus.workplaces.model.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {
	private ContactRepository repository;
	
	@Autowired
	public ContactsController(final ContactRepository _repository) {
		repository = _repository;
	}
	
	/**
	 * Получение полного списка контактов телефонной книги
	 * @return Список контактов телфонной книги
	 */
	@GetMapping(value = "/api/contacts", produces = "application/json")
	public List<Contact> getAll() {
		return repository.findAll();
	}
}