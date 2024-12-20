package com.talentoTechGrupo3.redComunitaria.publications.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrepreneurships")
@DiscriminatorValue("ENTREPRENEURSHIP")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entrepreneurship extends Publication {


    @Column(name = "name_company")
    private String nameCompany;
    private LocalDateTime startDate;
    private String receivedInvestment;
    @Enumerated(EnumType.STRING)
    private TypeSector typeSector;


}
