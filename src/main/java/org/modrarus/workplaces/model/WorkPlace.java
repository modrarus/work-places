package org.modrarus.workplaces.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Контейнер места работы
 */
@Document("WorkPlaces")
public class WorkPlace {
	/**
	 * ObjectID
	 */
	@Id
	private String id;
	/**
	 * Имя
	 */
	@NotEmpty
	@Size(min = 1, max = 10)
	private String firstName;
	/**
	 * Фамилия
	 */
	@NotEmpty
	@Size(min = 1, max = 20)
	private String lastName;
	/**
	 * Место работы
	 */
	@NotEmpty
	private String workPlace;
	/**
	 * Адрес работы
	 */
	@NotEmpty
	private String workAddress;
	
	/**
	 * Конструктор для репозитория
	 */
	@SuppressWarnings("unused")
	private WorkPlace() {}
	
	/**
	 * Конструирование объекта по данным
	 * @param _firstName   Имя
	 * @param _lastName    Фамилия
	 * @param _workPlace   Место работы
	 * @param _workAddress Адрес работы
	 */
	public WorkPlace(final String _firstName, final String _lastName, final String _workPlace,
			final String _workAddress) {
		firstName   = _firstName;
		lastName    = _lastName;
		workPlace   = _workPlace;
		workAddress = _workAddress;
	}
	
	/**
	 * Получение имени
	 * @return Имя
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Получение фамилии
	 * @return Фамилия
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Получение места работы
	 * @return Место работы
	 */
	public String getWorkPlace() {
		return workPlace;
	}
	
	/**
	 * Получение адреса работы
	 * @return Адрес работы
	 */
	public String getWorkAddress() {
		return workAddress;
	}
}