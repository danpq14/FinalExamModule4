package com.example.exam_module4.service;

import com.example.exam_module4.model.City;

public interface CityService {
    Iterable<City> findAll();
    void add(City city);
    City edit(City city);
    City findById(Long id);
    void delete(City city);
}
