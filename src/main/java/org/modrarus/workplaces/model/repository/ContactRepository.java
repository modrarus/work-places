package org.modrarus.workplaces.model.repository;

import org.modrarus.workplaces.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Репозиторий для работы с контактами
 */
public interface ContactRepository extends MongoRepository<Contact, String> {
}