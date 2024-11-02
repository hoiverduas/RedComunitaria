package com.talentoTechGrupo3.redComunitaria.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameDepartment;

    @OneToMany(mappedBy = "department")
    private List<City>cities;
}
