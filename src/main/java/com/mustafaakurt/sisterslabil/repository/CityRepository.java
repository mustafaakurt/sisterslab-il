package com.mustafaakurt.sisterslabil.repository;

import com.mustafaakurt.sisterslabil.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long>{

    public List<City> findAllByName(String city);
}
