package com.weather.demo;


import com.weather.demo.dto.InputDto;
import com.weather.demo.dto.WeatherDto;
import com.weather.demo.service.ValidationService;
import com.weather.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class Controller {


    @Autowired
    WeatherService service;
    @Autowired
    ValidationService validationService ;

    @PostMapping("/weather")
    public WeatherDto getWeatherInfo(@RequestBody InputDto dto)
    {
        if(!validationService.validate(dto))
        {
            throw new InvalidInputException("Invalid input , pincode is mandatory and date should be in the span of 1 month");
        }
        System.out.println(dto);
        if (dto.getDate() == null)
        {
            return service.getWeather(dto.getPincode());
        }
        return service.getWeather(dto.getPincode() , LocalDate.parse(dto.getDate()));

    }
}
