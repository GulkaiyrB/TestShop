package com.example.SoftwareForQA.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
}
