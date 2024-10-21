package com.weather.demo.service;

import com.weather.demo.dto.InputDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ValidationService {

    public boolean validate(InputDto dto)
    {
        if(dto.getPincode() == null)
        {
            return false ;
        }
        int months = (int) ChronoUnit.MONTHS.between(LocalDate.parse(dto.getDate()), LocalDate.now());
        System.out.println(months);
        if( months > 12)
        {
            return false;
        }

        return true  ;
    }

}
