package com.example.SoftwareForQA.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "shops")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private Street street;

    private String house;

    private LocalTime openingTime;

    private LocalTime closingTime;
}
