package org.modrarus.workplaces.controller;

import java.util.List;

import javax.validation.Valid;

import org.modrarus.workplaces.model.WorkPlace;
import org.modrarus.workplaces.model.repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkPlacesController {
	private WorkPlaceRepository repository;
	
	@Autowired
	public WorkPlacesController(final WorkPlaceRepository _repository) {
		repository = _repository;
	}
	
	/**
	 * Получение списка мест работы. Возможно получение как полного списка без передачи параметров,
	 * так и осуществление поиска по части полей, переданных в параметре запроса
	 * @param _firstName   Имя
	 * @param _lastName    Фамилия
	 * @param _workPlace   Место работы
	 * @param _workAddress Адрес работы
	 * @return
	 */
	@GetMapping(value = "/api/workplaces", produces = "application/json")
	public List<WorkPlace> getPlaces(
			@RequestParam(name = "firstName", required = false) final String _firstName,
			@RequestParam(name = "lastName", required = false) final String _lastName,
			@RequestParam(name = "workPlace", required = false) final String _workPlace,
			@RequestParam(name = "workAddress", required = false) final String _workAddress) {
		if (_firstName == null && _lastName == null && _workPlace == null && _workAddress == null) {
			return repository.findAll();
		}
		
		final Example<WorkPlace> example = Example.of(new WorkPlace(_firstName, _lastName, _workPlace, _workAddress));
		return repository.findAll(example);
	}
	
	/**
	 * Получение списка мест работы. Возможно получение как полного списка без передачи параметров,
	 * так и осуществление поиска по части полей, переданных в параметре запроса
	 * @param _place Новое место работы
	 * @return Сохраненное место работы
	 */
	@PostMapping(value = "/api/workplaces", consumes = "application/json")
	public WorkPlace createPlace(@Valid @RequestBody final WorkPlace _place) {
		return repository.save(_place);
	}
}