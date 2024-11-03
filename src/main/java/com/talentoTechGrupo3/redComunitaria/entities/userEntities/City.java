package com.talentoTechGrupo3.redComunitaria.entities.userEntities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCity;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "cities")
    private List<User> users;
}
