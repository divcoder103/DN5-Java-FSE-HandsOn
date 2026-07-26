package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContaining(String text);

    List<Country> findByNameContainingOrderByNameAsc(String text);

    List<Country> findByNameStartingWith(String alphabet);

    @Query("FROM Country c WHERE c.name = :name")
    Country findCountryByNameHQL(@Param("name") String name);

    @Query(value = "SELECT * FROM country WHERE name = :name", nativeQuery = true)
    Country findCountryByNameNative(@Param("name") String name);
}