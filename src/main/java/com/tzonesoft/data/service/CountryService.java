package com.tzonesoft.data.service;


import com.tzonesoft.data.model.Country;
import com.tzonesoft.data.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class CountryService {
    private final CountryRepository countryRepository;

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country getOne(Integer countryId) {
        return countryRepository.getById(countryId);
    }

    public Country saveOne(Country newCountry) {
        return countryRepository.save(newCountry);
    }
    public Country updateOne(Country replacedCountry, Integer countryId) {
        if (countryRepository.existsById(countryId)) {
            replacedCountry.setCountryId(countryId);
            replacedCountry.setLastUpdate(LocalDateTime.now());
            return countryRepository.saveAndFlush(replacedCountry);
        }
        throw new EntityNotFoundException();
    }
    public void deleteOne(Integer countryId){
        Country one = getOne(countryId);
        countryRepository.delete(one);
    }
}
