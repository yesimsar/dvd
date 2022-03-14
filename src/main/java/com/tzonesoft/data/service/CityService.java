package com.tzonesoft.data.service;


import com.tzonesoft.data.controller.dto.CityDTO;
import com.tzonesoft.data.mapper.CityMapper;
import com.tzonesoft.data.model.City;
import com.tzonesoft.data.model.Country;
import com.tzonesoft.data.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<City> getAll(){
        return cityRepository.findAll();
    }

    public CityDTO getOne(Integer id){
        City city = cityRepository.getById(id);
        return cityMapper.toDto(city);
    }
    public City save(CityDTO newCity){
        City city = cityMapper.toEntity(newCity);
        return cityRepository.save(city);

    }
    public City update(City replacedCity, Integer id){
        delete(id);
        return cityRepository.save(replacedCity);
    }
    public void delete(Integer id){
        cityRepository.deleteById(id);
    }

}
