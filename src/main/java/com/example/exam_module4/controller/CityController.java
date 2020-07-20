package com.example.exam_module4.controller;

import com.example.exam_module4.model.City;
import com.example.exam_module4.model.Country;
import com.example.exam_module4.service.CityService;
import com.example.exam_module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @RequestMapping("/")
    public String getHomepage(Model model) {
        Iterable<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "list";
    }

    @GetMapping("/create-new-city")
    public String newCityForm(Model model){
        model.addAttribute("city", new City());
        model.addAttribute("countries", countryService.findAll());
        return "create-form";
    }

    @PostMapping("/create-new-city")
    public String createCity(@Validated @ModelAttribute City city, @RequestParam("country_id") Long countryId, BindingResult bindingResult) {
        Country country = countryService.findById(countryId);
        city.setCountry(country);
        if (bindingResult.hasFieldErrors()) {
            return "create-form";
        }
        else {
            cityService.add(city);
            return "new-city-success";
        }
    }

    @GetMapping("/edit/city/{id}")
    public String getEditForm(Model model, @PathVariable Long id){
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        model.addAttribute("countries", countryService.findAll());
        return "edit-form";
    }

    @PostMapping("/edit/city/{id}")
    public String editCity(@Valid @ModelAttribute City city, @RequestParam("country_id") Long countryId, BindingResult bindingResult) {
        Country country = countryService.findById(countryId);
        city.setCountry(country);
        if (bindingResult.hasFieldErrors()) {
            return "edit-form";
        }
        else {
            cityService.edit(city);
            return "edit-city-success";
        }
    }

    @GetMapping("/city/{id}")
    public String getCity(@PathVariable Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "city-detail";
    }

    @GetMapping("/delete/city/{id}")
    public String deleteForm(@PathVariable Long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "delete-city";
    }

    @PostMapping("/delete/city/{id}")
    public String deleteCity(@PathVariable Long id, Model model){
        City city = cityService.findById(id);
        cityService.delete(city);
        Iterable<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "list";
    }
}
