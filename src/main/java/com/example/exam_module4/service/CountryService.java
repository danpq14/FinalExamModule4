package com.example.exam_module4.service;

import com.example.exam_module4.model.Country;

public interface CountryService {
    void add(Country country);
    Country edit(Country country);
    Country findById(Long id);
    void delete(Country country);
    Iterable<Country> findAll();
}
