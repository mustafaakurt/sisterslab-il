package com.mustafaakurt.sisterslabil.controller;

import com.mustafaakurt.sisterslabil.dto.request.CityRequestDto;
import com.mustafaakurt.sisterslabil.dto.response.CityResponseDto;
import com.mustafaakurt.sisterslabil.model.City;
import com.mustafaakurt.sisterslabil.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public CityResponseDto createCity(@RequestBody CityRequestDto newCity){
        return cityService.createCity(newCity);
    }
    @GetMapping
    public List<City> getCities(@RequestParam(required = false) String city){
        return cityService.getCities(city);
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable Long id){
        return cityService.getCity(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id){
        cityService.deleteCity(id);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City city){
        return cityService.updateCity(id, city);
    }
}
