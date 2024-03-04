package com.mustafaakurt.sisterslabil.service;

import com.mustafaakurt.sisterslabil.model.City;
import com.mustafaakurt.sisterslabil.repository.CityRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class CityService {
    private final CityRepository cityRepository;

    public City createCity(City city) {
        return cityRepository.save(city);
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
