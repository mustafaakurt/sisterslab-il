package com.mustafaakurt.sisterslabil.service;

import com.mustafaakurt.sisterslabil.dto.request.CityRequestDto;
import com.mustafaakurt.sisterslabil.dto.response.CityResponseDto;
import com.mustafaakurt.sisterslabil.model.City;
import com.mustafaakurt.sisterslabil.repository.CityRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class CityService {
    private final CityRepository cityRepository;

    public CityResponseDto createCity(CityRequestDto newCity) {
        City city = new City();
        city.setName(newCity.getName());
        city.setPlateNumber(newCity.getPlateNumber());

        City saveCity = new City();
        saveCity = cityRepository.save(city);

        CityResponseDto cityResponseDto = new CityResponseDto();
        cityResponseDto.setName(saveCity.getName());
        cityResponseDto.setPlateNumber(saveCity.getPlateNumber());
        cityResponseDto.setCreatedDate(saveCity.getCreatedDate());
        return cityResponseDto;
    }

    public List<City> getCities(String city) {
        if (city != null) {
            return cityRepository.findAllByName(city);
        } else {
            return cityRepository.findAll();
        }

    }

    public City getCity(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found with id: " + id));
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public City updateCity(Long id, City city) {
        City oldCity = cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        oldCity.setName(city.getName());
        oldCity.setPlateNumber(city.getPlateNumber());
        return cityRepository.save(oldCity);
    }
}
