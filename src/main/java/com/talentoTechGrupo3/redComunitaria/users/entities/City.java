package com.talentoTechGrupo3.redComunitaria.users.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCity;
    private String nameCity;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "cities",fetch = FetchType.LAZY)
    private List<User> users;

}
