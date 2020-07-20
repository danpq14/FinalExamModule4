package com.example.exam_module4.repositories;

import com.example.exam_module4.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByName(String name);
}
