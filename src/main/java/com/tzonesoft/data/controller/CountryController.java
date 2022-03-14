package com.tzonesoft.data.controller;


import com.tzonesoft.data.model.Country;
import com.tzonesoft.data.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping(path = "{countryId}")
    public Country getOne(@PathVariable Integer countryId){
        return countryService.getOne(countryId);
    }

    @PostMapping
    public Country saveOne(@RequestBody Country country){
        Country newCountry= new Country();
        newCountry.setCountry(country.getCountry());
        newCountry.setLastUpdate(LocalDateTime.now());
        return countryService.saveOne(newCountry);
    }


    @PutMapping(path = "{countryId}")
    public Country updateOne(@RequestBody Country country, @PathVariable Integer countryId){
        Country replacedCountry=new Country();
        replacedCountry.setCountryId(country.getCountryId());
        replacedCountry.setCountry(country.getCountry());
        replacedCountry.setLastUpdate(LocalDateTime.now());
        return countryService.updateOne(replacedCountry, countryId);

    }
    @DeleteMapping(path = "{countryId}")
    public void deleteOne(@PathVariable Integer countryId){
        countryService.deleteOne(countryId);


    }


}
