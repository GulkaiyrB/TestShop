package com.example.SoftwareForQA.controllers;


import com.example.SoftwareForQA.dto.StreetDTO;
import com.example.SoftwareForQA.mappers.StreetMapper;
import com.example.SoftwareForQA.models.City;
import com.example.SoftwareForQA.models.Street;
import com.example.SoftwareForQA.services.CityService;
import com.example.SoftwareForQA.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/street")
public class StreetController {
    private final StreetService streetService;
    private final CityService cityService;
    private final StreetMapper streetMapper;

    @Autowired
    public StreetController(StreetService streetService, CityService cityService, StreetMapper streetMapper) {
        this.streetService = streetService;
        this.cityService = cityService;
        this.streetMapper = streetMapper;
    }


    @PostMapping("/add")
    public ResponseEntity<String> addStreet(@RequestBody StreetDTO streetDTO, @RequestParam Long city_id) {
        try {
            City city = cityService.getCityById(city_id);
            Street street = streetMapper.convertToEntity(streetDTO);
            street.setCity(city);
            streetService.saveStreet(street);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreetDTO> getStreetById(@PathVariable Long id) {
        try {
            Street street = streetService.getStreetById(id);
            StreetDTO streetDTO = streetMapper.convertToDTO(street);
            return ResponseEntity.ok(streetDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStreet(@PathVariable Long id, @RequestBody StreetDTO streetDTO) {
        try {
            Street street = streetMapper.convertToEntity(streetDTO);
            street.setId(id);
            streetService.updateStreet(id, street);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStreet(@PathVariable Long id) {
        try {
            streetService.deleteStreet(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<StreetDTO>> getAllStreets() {
        try {
            List<Street> streets = streetService.getAllStreets();
            List<StreetDTO> streetDTOs = streets.stream().map(streetMapper::convertToDTO).toList();
            return ResponseEntity.ok(streetDTOs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

