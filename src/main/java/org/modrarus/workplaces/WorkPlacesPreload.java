package org.modrarus.workplaces;

import java.util.ArrayList;
import java.util.List;

import org.modrarus.workplaces.model.WorkPlace;
import org.modrarus.workplaces.model.repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Предзагрузка компонентов в БД
 */
@Component
public class WorkPlacesPreload implements CommandLineRunner {
	private WorkPlaceRepository repository;
	
	@Autowired
	public WorkPlacesPreload(final WorkPlaceRepository _repository) {
		repository = _repository;
	}
	
	@Override
	public void run(final String... args) throws Exception {
		if (repository.count() > 0) {
			return;
		}
		final List<WorkPlace> preload = new ArrayList<WorkPlace>();
		preload.add(new WorkPlace("Василий", "Васильев", "Работа 1", "Адрес 1"));
		preload.add(new WorkPlace("Сергей", "Сергеев", "Работа 2", "Адрес 2"));
		preload.add(new WorkPlace("Александр", "Александров", "Работа 3", "Адрес 3"));
		preload.add(new WorkPlace("Виктор", "Викторов", "Работа 4", "Адрес 4"));
		repository.saveAll(preload);
	}
}