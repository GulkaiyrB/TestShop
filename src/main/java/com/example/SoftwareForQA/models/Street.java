package com.example.SoftwareForQA.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "streets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
}
