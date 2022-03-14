package com.tzonesoft.data.controller;


import com.tzonesoft.data.controller.dto.CityDTO;
import com.tzonesoft.data.model.City;
import com.tzonesoft.data.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "city")
public class CityController {
    public final CityService cityService;
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAll(){
        return cityService.getAll();
    }

    @GetMapping(path="{cityId}")
    public CityDTO getOne(@PathVariable Integer cityId){
        return cityService.getOne(cityId);
    }

    @PostMapping
    public City saveOne(@RequestBody CityDTO newCity){
        return cityService.save(newCity);
    }
    @PutMapping(path="{cityId}")
    public City replacedOne(@RequestBody City replacedCity,@PathVariable Integer cityId){
        replacedCity.setCity(replacedCity.getCity());
        replacedCity.setCityId(replacedCity.getCityId());
        replacedCity.setCountry(replacedCity.getCountry());
        replacedCity.setLastUpdate(LocalDateTime.now());
        return cityService.update(replacedCity,cityId);
    }
    @DeleteMapping(path = "{cityId}")
    public void deleteOne(@PathVariable Integer cityId){
        cityService.delete(cityId);
    }
}
