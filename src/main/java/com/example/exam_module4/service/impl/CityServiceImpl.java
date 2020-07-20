package com.example.exam_module4.service.impl;

import com.example.exam_module4.model.City;
import com.example.exam_module4.repositories.CityRepository;
import com.example.exam_module4.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void add(City city) {
        cityRepository.save(city);
    }

    @Override
    public City edit(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }
}
