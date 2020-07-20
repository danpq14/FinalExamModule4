package com.example.exam_module4.repositories;

import com.example.exam_module4.model.City;
import com.example.exam_module4.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Iterable<City> findAllByCountry(Country country);
}
