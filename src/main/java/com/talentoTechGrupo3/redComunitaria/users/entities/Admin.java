package com.talentoTechGrupo3.redComunitaria.users.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@DiscriminatorValue("ADMIN")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin extends User {

    private Integer accessLevel;
    @Enumerated(EnumType.STRING)
    private AreaOfResponsibility areaOfResponsibility;


}
