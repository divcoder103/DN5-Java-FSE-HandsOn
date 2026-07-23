package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private CountryService countryService;

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("----- FIND COUNTRY -----");
		Country country = countryService.getCountry("IN");
		System.out.println(country.getCode() + " " + country.getName());

		System.out.println("\n----- ADD COUNTRY -----");
		countryService.addCountry(new Country("UK", "United Kingdom"));
		System.out.println("Country Added");

		System.out.println("\n----- UPDATE COUNTRY -----");
		countryService.updateCountry(new Country("IN", "Bharat"));
		System.out.println("Country Updated");

		System.out.println("\n----- DELETE COUNTRY -----");
		countryService.deleteCountry("FR");
		System.out.println("Country Deleted");

		System.out.println("\n----- SEARCH 'ou' -----");
		countryService.searchCountry("ou")
				.forEach(System.out::println);

		System.out.println("\n----- SEARCH 'ou' SORTED -----");
		countryService.searchCountrySorted("ou")
				.forEach(System.out::println);

		System.out.println("\n----- STARTS WITH 'Z' -----");
		countryService.getCountryStartingWith("Z")
				.forEach(System.out::println);

		System.out.println("\n----- EMPLOYEE DETAILS -----");

		Employee employee = employeeService.getEmployee(102);

		if (employee != null) {
			System.out.println("Employee Id : " + employee.getId());
			System.out.println("Employee Name : " + employee.getName());
			System.out.println("Department : " + employee.getDepartment().getName());
		} else {
			System.out.println("Employee not found");
		}
		System.out.println("\n----- HQL QUERY -----");

		Country hqlCountry = countryService.getCountryByNameHQL("Bharat");

		if (hqlCountry != null)
			System.out.println(hqlCountry);

		System.out.println("\n----- NATIVE QUERY -----");

		Country nativeCountry = countryService.getCountryByNameNative("Bharat");

		if (nativeCountry != null)
			System.out.println(nativeCountry);
	}


}