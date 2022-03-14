package com.tzonesoft.data.mapper;

import com.tzonesoft.data.controller.dto.CityDTO;
import com.tzonesoft.data.model.City;
import com.tzonesoft.data.model.Country;
import com.tzonesoft.data.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CityMapper {
    private final CountryRepository countryRepository;

    public CityDTO toDto(City entity){
        CityDTO cityDTO = new CityDTO();;
        cityDTO.setCity(entity.getCity());
        cityDTO.setLastUpdate(entity.getLastUpdate());
        cityDTO.setCountryId(entity.getCountry().getCountryId());
        cityDTO.setCountry(entity.getCountry().getCountry());
        cityDTO.setCountry1(entity.getCountry());
        cityDTO.setCityId(entity.getCityId());
        return cityDTO;
    }

    public City toEntity(CityDTO dto) {
        City city = new City();
        city.setCity(dto.getCity());
        Country country = countryRepository.getById(dto.getCountryId());
        city.setCountry(country);
        city.setLastUpdate(LocalDateTime.now());
        return city;
    }
}
