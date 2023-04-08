package com.example.SoftwareForQA.services;


import com.example.SoftwareForQA.models.City;
import com.example.SoftwareForQA.models.Street;
import com.example.SoftwareForQA.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {
    private final StreetRepository streetRepository;

    private final CityService cityService;

    @Autowired
    public StreetService(StreetRepository streetRepository, CityService cityService) {
        this.streetRepository = streetRepository;
        this.cityService = cityService;
    }

    public Street getStreetById(Long id){
        return streetRepository.findById(id).orElse(null);
    }

    public List<Street> getAllStreets(){
        return streetRepository.findAll();
    }

    public List<Street> getStreetsByCity(City city){
        return streetRepository.findByCity(city);
    }


    public Street updateStreet(Long id, Street updStreet){
        Street oldStreet = getStreetById(id);
        oldStreet.setName(updStreet.getName());
        oldStreet.setCity(updStreet.getCity());
        return streetRepository.save(oldStreet);
    }

    public Street saveStreet(Street street){
        return streetRepository.save(street);
    }

    public void deleteStreet(Long id){
        streetRepository.deleteById(id);
    }
}
