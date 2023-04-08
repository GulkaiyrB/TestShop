package com.example.SoftwareForQA.dto;


import com.example.SoftwareForQA.models.City;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class StreetDTO {
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

}
