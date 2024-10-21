package com.weather.demo.service;

import com.weather.demo.dto.WeatherDto;
import com.weather.demo.entity.Location;
import com.weather.demo.entity.WeatherInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;


@Service
public class WeatherService {

    String API_KEY =   "26b41d17eea1eb323ba2b4bf4a7df288" ;
    String geoUrl = "http://api.openweathermap.org/geo/1.0/zip?zip=%s,IN&appid=%s" ;
    String url = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
    String url2 = "https://history.openweathermap.org/data/2.5/history/city?lat=%s&lon=%s&type=hour&start=%s&end=%s&appid=%s" ;

    WebClient webClient =  WebClient.builder().build() ;

    public WeatherDto getWeather(String pincode)
    {
        Location location =  getLocation(pincode) ;
        url = String.format(url , location.getLat() , location.getLon() , API_KEY );
        WeatherInfo result =  webClient.get().uri(url).retrieve().bodyToMono(WeatherInfo.class).block();
        List<WeatherInfo> r = new ArrayList<>();
        r.add(result);
        return new WeatherDto(r);
    }

    public WeatherDto getWeather(String pincode , LocalDate date)
    {
        LocalDateTime startOfDay = date.atStartOfDay();
        System.out.println(startOfDay);
        long startUnixTime = startOfDay.toEpochSecond(ZoneOffset.UTC);
        long endUnixTime = startUnixTime + 24 * 60 * 60;
        System.out.println(startUnixTime);
        String start =  Long.toString(startUnixTime);
        String end = Long.toString(endUnixTime);
        System.out.println(start);
        Location location =  getLocation(pincode) ;
        String requesturl  = String.format(url2 ,  location.getLat() , location.getLon() , start , end , API_KEY);
        System.out.println(requesturl);
        return webClient.get().uri(requesturl).retrieve().bodyToMono(WeatherDto.class).block();

    }

    private Location getLocation(String pincode)
    {
        geoUrl = String.format(geoUrl ,pincode ,  API_KEY);
        System.out.println(geoUrl);
        return webClient.get().uri(geoUrl).retrieve().bodyToMono(Location.class).block();
    }
}
