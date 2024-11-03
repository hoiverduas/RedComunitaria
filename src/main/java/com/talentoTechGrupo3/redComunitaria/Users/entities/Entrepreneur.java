package com.talentoTechGrupo3.redComunitaria.Users.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ENTREPRENEUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrepreneur extends User {

    private String experience;
    private String contact;
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;
}
