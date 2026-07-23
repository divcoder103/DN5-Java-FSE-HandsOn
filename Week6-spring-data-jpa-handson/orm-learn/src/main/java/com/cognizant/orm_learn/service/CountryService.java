package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountry(String code) {
        Optional<Country> country = countryRepository.findById(code);

        return country.orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    public List<Country> searchCountry(String text) {
        return countryRepository.findByNameContaining(text);
    }

    public List<Country> searchCountrySorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    public List<Country> getCountryStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }
    public Country getCountryByNameHQL(String name) {
        return countryRepository.findCountryByNameHQL(name);
    }

    public Country getCountryByNameNative(String name) {
        return countryRepository.findCountryByNameNative(name);
    }
}