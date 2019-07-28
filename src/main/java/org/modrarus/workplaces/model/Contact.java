package org.modrarus.workplaces.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Контейнер контакта телефонной книги
 */
@Document("PhonesBook")
public class Contact {
	/**
	 * ObjectID
	 */
	@Id
	private String id;
	/**
	 * Имя
	 */
	private String firstName;
	/**
	 * Фамилия
	 */
	private String lastName;
	/**
	 * Рабочий телефон
	 */
	private String phoneWork;
	/**
	 * Мобильный телефон
	 */
	private String phoneMobile;
	/**
	 * Электронная почта
	 */
	private String email;
	/**
	 * Место работы
	 */
	private String workPlace;
	/**
	 * День рождения
	 */
	private LocalDate birthday;
	
	/**
	 * Конструктор для репозитория
	 */
	private Contact() {} 
	
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
	 * Получение рабочего телефона
	 * @return Рабочий телефон
	 */
	public String getPhoneWork() {
		return phoneWork;
	}
	
	/**
	 * Получение мобильного телефона
	 * @return Мобильный телефон
	 */
	public String getPhoneMobile() {
		return phoneMobile;
	}
	
	/**
	 * Получение электронной почты
	 * @return Электронная почта
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Получение места работы
	 * @return Место работы
	 */
	public String getWorkPlace() {
		return workPlace;
	}
	
	/**
	 * Получение даты рождения
	 * @return Дата рождения
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
}