package org.modrarus.workplaces.model.repository;

import org.modrarus.workplaces.model.WorkPlace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface WorkPlaceRepository extends MongoRepository<WorkPlace, String>, QueryByExampleExecutor<WorkPlace> {
}