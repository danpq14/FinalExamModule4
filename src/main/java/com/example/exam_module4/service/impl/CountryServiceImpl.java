package com.example.exam_module4.service.impl;

import com.example.exam_module4.model.Country;
import com.example.exam_module4.repositories.CountryRepository;
import com.example.exam_module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public void add(Country country) {
        countryRepository.save(country);
    }

    @Override
    public Country edit(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }
}
