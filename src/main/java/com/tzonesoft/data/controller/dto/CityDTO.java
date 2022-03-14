package com.tzonesoft.data.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tzonesoft.data.model.Country;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDTO {
    private Integer cityId;
    private String city;
    private Integer countryId;
    private String country;
    private Country country1;
    private LocalDateTime lastUpdate;
}
