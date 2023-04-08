package com.example.SoftwareForQA.services;


import com.example.SoftwareForQA.models.City;
import com.example.SoftwareForQA.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

//    public List<Street> getAllStreetsByCity(Long id, StreetDTO streetDTO){
//        City city = getCityById(id);
//        Street street = new Street();
//        street.setName(streetDTO.getName());
//        street.setCity(city);
//        cityRepository.save(city);
//        return
//    }


    public City getCityById(Long id){
        return cityRepository.findById(id).orElse(null);
    }

    public City updateCity(Long id, City updCity){
        City oldCity = getCityById(id);
        oldCity.setName(updCity.getName());
        return cityRepository.save(oldCity);
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public void deleteCity(Long id){
        cityRepository.delete(getCityById(id));
    }
}
