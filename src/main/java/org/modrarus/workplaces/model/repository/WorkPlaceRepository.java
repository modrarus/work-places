package org.modrarus.workplaces.model.repository;

import org.modrarus.workplaces.model.WorkPlace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkPlaceRepository extends MongoRepository<WorkPlace, String> {
}