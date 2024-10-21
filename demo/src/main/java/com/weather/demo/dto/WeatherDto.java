package com.weather.demo.dto;

import com.weather.demo.entity.WeatherInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {

   private  List<WeatherInfo> list  ;
}
